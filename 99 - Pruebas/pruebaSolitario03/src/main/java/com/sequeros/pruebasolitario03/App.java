package com.sequeros.pruebasolitario03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final String[] CARD_IMAGES = {
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Playing_card_diamond_3.svg/120px-Playing_card_diamond_3.svg.png",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Playing_card_diamond_3.svg/120px-Playing_card_diamond_3.svg.png",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Playing_card_diamond_3.svg/120px-Playing_card_diamond_3.svg.png"
    };

    private List<ImageView> pile1 = new ArrayList<>();
    private List<ImageView> pile2 = new ArrayList<>();
    private Pane root;

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();

        createPile(pile1, 50, 100);
        createPile(pile2, 300, 100);

        Scene scene = new Scene(root, 600, 400, Color.DARKGREEN);
        primaryStage.setTitle("Solitaire Drag & Drop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createPile(List<ImageView> pile, double x, double y) {
        for (int i = 0; i < CARD_IMAGES.length; i++) {
            System.out.println(i);
            Image image = new Image(CARD_IMAGES[i]);
            ImageView card = new ImageView(image);

            card.setFitWidth(100);
            card.setFitHeight(150);
            card.setX(x);
            card.setY(y + i * 30); // Apilar visualmente

            setupDragAndDrop(card, pile);
            root.getChildren().add(card);
            pile.add(card);
        }
    }

    private void setupDragAndDrop(ImageView card, List<ImageView> sourcePile) {
        card.setOnDragDetected(event -> {
            int cardIndex = sourcePile.indexOf(card);
            if (cardIndex == -1) {
                return;
            }

            Dragboard db = card.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(card.getImage());
            db.setContent(content);

            event.consume();
        });

        card.setOnDragOver(event -> {
            if (event.getGestureSource() != card) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        card.setOnDragDropped(event -> {
            ImageView draggedCard = (ImageView) event.getGestureSource();
            List<ImageView> targetPile = sourcePile == pile1 ? pile2 : pile1;
            moveCards(draggedCard, sourcePile, targetPile);
            event.setDropCompleted(true);
            event.consume();
            System.out.println("pepe");
            for (ImageView imageView : targetPile) {
                System.out.println(imageView);
            }
        });
    }

    private void moveCards(ImageView draggedCard, List<ImageView> fromPile, List<ImageView> toPile) {
        int startIndex = fromPile.indexOf(draggedCard);
        if (startIndex == -1) {
            return;
        }

        List<ImageView> movingCards = new ArrayList<>(fromPile.subList(startIndex, fromPile.size()));
        fromPile.removeAll(movingCards);
        toPile.addAll(movingCards);

        // Reposicionar la pila de destino
        updatePilePositions(fromPile);
        updatePilePositions(toPile);
    }

    private void updatePilePositions(List<ImageView> pile) {
        if (pile.isEmpty()) {
            return;
        }

        double x = pile.get(0).getX();
        double y = pile.get(0).getY();

        for (int i = 0; i < pile.size(); i++) {
            pile.get(i).setX(x);
            pile.get(i).setY(y + i * 30); // Desplazamiento visual en la pila

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
