package com.mycompany.ejemplostackpane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        StackPane root = new StackPane();
        for (int i = 0; i < 4; i++) {
            Button btn = new Button(Integer.toString(i));
            btn.setPrefSize(100, 30);
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    ((Node) event.getSource()).toBack(); // getSource devuelve la fuente del evento
                } // toBack envía al nodo al final de
            }); // la lista de hijos del contenedor
            root.getChildren().add(btn);
        }

        var scene = new Scene(new StackPane(root), 200, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
