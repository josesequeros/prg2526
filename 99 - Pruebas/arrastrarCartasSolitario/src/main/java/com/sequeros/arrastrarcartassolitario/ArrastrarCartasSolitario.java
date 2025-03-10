/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sequeros.arrastrarcartassolitario;

/**
 *
 * @author jabue
 */
public class ArrastrarCartasSolitario {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SolitaireLikeGame extends Application {
    private static final String[] CARD_IMAGES = {
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Playing_card_diamond_A.svg/120px-Playing_card_diamond_A.svg.png",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Playing_card_diamond_2.svg/120px-Playing_card_diamond_2.svg.png",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Playing_card_diamond_3.svg/120px-Playing_card_diamond_3.svg.png"
    };
    
    private ImageView[] cardViews = new ImageView[3];
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        for (int i = 0; i < CARD_IMAGES.length; i++) {
            Image image = new Image(CARD_IMAGES[i]);
            ImageView card = new ImageView(image);
            
            card.setFitWidth(100);
            card.setFitHeight(150);
            card.setX(50 + i * 120);
            card.setY(100);
            
            int cardIndex = i;
            
            card.setOnDragDetected(event -> {
                Dragboard db = card.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(card.getImage());
                db.setContent(content);
                event.consume();
            });
            
            card.setOnDragOver(event -> {
                if (event.getGestureSource() != card && isValidMove((ImageView) event.getGestureSource(), cardIndex)) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                event.consume();
            });
            
            card.setOnDragDropped(event -> {
                ImageView draggedCard = (ImageView) event.getGestureSource();
                if (isValidMove(draggedCard, cardIndex)) {
                    draggedCard.setX(card.getX());
                    draggedCard.setY(card.getY() + 30); // Apilar cartas visualmente
                }
                event.setDropCompleted(true);
                event.consume();
            });
            
            root.getChildren().add(card);
            cardViews[i] = card;
        }
        
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Solitario JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private boolean isValidMove(ImageView draggedCard, int targetIndex) {
        int draggedIndex = -1;
        for (int i = 0; i < cardViews.length; i++) {
            if (cardViews[i] == draggedCard) {
                draggedIndex = i;
                break;
            }
        }
        return draggedIndex != -1 && draggedIndex + 1 == targetIndex; // Solo permite soltar en la siguiente carta
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
