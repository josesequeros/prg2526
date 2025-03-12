package com.sequeros._ejercicio01_eventosraton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * JavaFX App
 */
public class App extends Application {

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
            text.setY(e.getY());
        });

        

        stage.setTitle("Eventos de Ratón");
        stage.setScene(scene);
        stage.show();
    }

}
