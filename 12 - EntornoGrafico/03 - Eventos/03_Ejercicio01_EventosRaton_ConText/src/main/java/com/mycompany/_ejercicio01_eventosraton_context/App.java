package com.mycompany._ejercicio01_eventosraton_context;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private double offsetX;
    private double offsetY;

    @Override
    public void start(Stage stage) {

        Pane pane = new Pane();
        pane.setPrefSize(300, 300);
        Scene scene = new Scene(pane, 300, 300);
        
        // Text SIN coordenadas en el constructor
        Text text = new Text("Programar es divertido");

        // Posición inicial usando layoutX / layoutY
        text.setLayoutX(30);
        text.setLayoutY(30);

        pane.getChildren().add(text);

        // Al pulsar el ratón: calcular el offset
        text.setOnMousePressed(e -> {
            offsetX = text.getLayoutX() - e.getSceneX();
            offsetY = text.getLayoutY() - e.getSceneY();
        });

/*
        // Al arrastrar: mover y limitar
        text.setOnMouseDragged(e -> {

            // Convertir coordenadas de escena a coordenadas del pane
            Point2D mouse = pane.sceneToLocal(e.getSceneX(), e.getSceneY());

            double newX = mouse.getX() + offsetX;
            double newY = mouse.getY() + offsetY;

            Bounds bounds = text.getBoundsInParent();

            double maxX = pane.getWidth() - bounds.getWidth();
            double maxY = pane.getHeight() - bounds.getHeight();
            double minX = 0;
            double minY = 10;
            newX = Math.max(minX, Math.min(newX, maxX));
            newY = Math.max(minY, Math.min(newY, maxY));

            text.setLayoutX(newX);
            text.setLayoutY(newY);
        });
*/
        
        text.setOnMouseDragged(e -> {
            double newX = e.getSceneX() + offsetX;
            double newY = e.getSceneY() + offsetY;
        
            // Limitar dentro del ancho/alto de la escena
            double maxX = scene.getWidth() - text.getLayoutBounds().getWidth();
            double maxY = scene.getHeight() - text.getLayoutBounds().getHeight();
        
            // Asegurar que no se salga de los bordes
            newX = Math.max(0, Math.min(newX, maxX));
            newY = Math.max(text.getLayoutBounds().getHeight(), Math.min(newY, maxY));
        
            text.setLayoutX(newX);
            text.setLayoutY(newY);
        });

        text.setOnMousePressed(e -> {
            offsetX = text.getLayoutX() - e.getSceneX();
            offsetY = text.getLayoutY() - e.getSceneY();
        });
        
        

        stage.setScene(scene);
        stage.setTitle("Text arrastrable");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
