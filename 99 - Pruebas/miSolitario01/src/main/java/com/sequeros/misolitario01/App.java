package com.sequeros.misolitario01;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        Canvas canvas = new Canvas(900, 600);

        Pane root = new Pane(canvas);

        Scene scene = new Scene(root, Color.DARKGREEN);

        //Game game = new Game(canvas.getGraphicsContext2D());
        //canvas.setOnMouseClicked(game::handleMouseClicked);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Solitario 0.1");
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.show();

        Image image = new Image(getClass().getResource("/cartas/corazones1.png").toString());
        ImageView card = new ImageView(image);

        card.setFitWidth(100);
        card.setFitHeight(150);
        card.setX(100);
        card.setY(100); // 

        //setupDragAndDrop(card, pile);
        root.getChildren().add(card);

        card.setOnDragDetected(event -> {
            Dragboard db = card.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(card.getImage());
            db.setContent(content);
            event.consume();
        });


        card.setOnDragDetected(event -> {
            Dragboard db = card.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
        
            // Crear una imagen redimensionada con el mismo tamaño que la carta
            WritableImage snapshot = new WritableImage((int) card.getFitWidth(), (int) card.getFitHeight());
            
            Canvas canvas2 = new Canvas(card.getFitWidth(), card.getFitHeight());
            GraphicsContext gc = canvas2.getGraphicsContext2D();
            gc.drawImage(card.getImage(), 0, 0, card.getFitWidth(), card.getFitHeight());
            canvas2.snapshot(null, snapshot);
        


            content.putImage(snapshot);
            db.setContent(content);
        
            event.consume();
        });

        card.setOnDragOver(event -> {
            if (event.getGestureSource() != card && isValidMove((ImageView) event.getGestureSource(), 1)) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        card.setOnDragDropped(event -> {
            ImageView draggedCard = (ImageView) event.getGestureSource();
            if (isValidMove(draggedCard, 1)) {
                draggedCard.setX(card.getX());
                draggedCard.setY(card.getY() + 30); // Apilar cartas visualmente
            }
            event.setDropCompleted(true);
            event.consume();
        });
    }

    public static void main(String[] args) {
        launch();
    }

    private boolean isValidMove(ImageView draggedCard, int targetIndex) {
        int draggedIndex = -1;

        return draggedIndex != -1 && draggedIndex - 1 == targetIndex; // Solo permite soltar en la siguiente carta
    }

}
