package com.sequeros._ejercicio01_eventosraton;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * JavaFX App
 */
public class App extends Application {

    private double offsetX;
    private double offsetY;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Text text = new Text(30, 30, "Programar es divertido");

        pane.getChildren().addAll(text);

        Scene scene = new Scene(pane, 300, 300);

        text.setOnMouseDragged(e -> {
            if (e.getX() < scene.getWidth() && e.getX() > 0) {
                text.setX(e.getX());
            }
            if (e.getY() < scene.getHeight() && e.getY() > 0) {
                text.setY(e.getY());
            }
        });
/*
        text.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                if (e.getX() < scene.getWidth() && e.getX() > 0) {
                text.setX(e.getX());
            }
            if (e.getY() < scene.getHeight() && e.getY() > 0) {
                text.setY(e.getY());
            }
            }
        });
*/
        /*
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
         */
        stage.setTitle("Eventos de Ratón");
        stage.setScene(scene);
        stage.show();
    }

}
