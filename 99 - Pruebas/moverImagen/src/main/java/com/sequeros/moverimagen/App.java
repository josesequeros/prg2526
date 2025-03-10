package com.sequeros.moverimagen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private double mouseX;
    private double mouseY;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Cargar la imagen
        Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png");
        ImageView imageView = new ImageView(image);

        // Establecer tamaño inicial de la imagen
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setX(100);
        imageView.setY(100);

        // Manejar eventos de arrastre
        imageView.setOnMousePressed(event -> {
            mouseX = event.getSceneX() - imageView.getX();
            mouseY = event.getSceneY() - imageView.getY();
        });

        imageView.setOnMouseDragged(event -> {

            // Asegurar que la imagen no salga de la ventana
            double maxX = root.getWidth() - imageView.getFitWidth();
            double maxY = root.getHeight() - imageView.getFitHeight();
            double newX = event.getSceneX() - mouseX;
            double newY = event.getSceneY() - mouseY;
            if (newX < 0) {
                newX = 0;
            }
            if (newY < 0) {
                newY = 0;
            }
            if (newX > maxX) {
                newX = maxX;
            }
            if (newY > maxY) {
                newY = maxY;
            }
            //imageView.setX(event.getSceneX() - mouseX);
            //imageView.setY(event.getSceneY() - mouseY);            
            imageView.setX(newX);
            imageView.setY(newY);
        });

        root.getChildren().add(imageView);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Arrastrar Imagen JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
