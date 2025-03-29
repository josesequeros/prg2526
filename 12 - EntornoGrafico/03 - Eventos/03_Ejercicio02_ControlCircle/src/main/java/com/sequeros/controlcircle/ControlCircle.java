package com.sequeros.controlcircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {

    private CirclePane circlePane = new CirclePane();

    @Override // Override el método start en la cñase Application
    public void start(Stage primaryStage) {
        // Colocar dos botones en un HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btAumentar = new Button("Aumentar");
        Button btDisminuir = new Button("Disminuir");
        hBox.getChildren().add(btAumentar);
        hBox.getChildren().add(btDisminuir);
        btAumentar.setFocusTraversable(false);
        btDisminuir.setFocusTraversable(false);

        // Crear y registrar el manejador (handler)
        btAumentar.setOnAction(new AumentarHandler());
        btDisminuir.setOnAction(new DisminuirHandler());
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Crear una scene y la colocamos en el stage
        Scene scene = new Scene(borderPane, 300, 200);
        primaryStage.setTitle("Control de Circulo"); // Establecemos el título de la ventana (stage)
        primaryStage.setScene(scene); // Situamos la escena (scene) en la ventana (stage)
        primaryStage.show(); // Display the stage
        circlePane.requestFocus();

        circlePane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                circlePane.aumentar();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                circlePane.disminuir();
            }
        });

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                circlePane.aumentar();
                circlePane.requestFocus();
                System.out.println("up");
            } else if (e.getCode() == KeyCode.DOWN) {
                circlePane.disminuir();
                circlePane.requestFocus();
                System.out.println("down");
            }
        });

    }

    class AumentarHandler implements EventHandler<ActionEvent> {

        @Override // Sobreescribimos el método handle (manejador)
        public void handle(ActionEvent e) {
            circlePane.aumentar();
        }
    }

    class DisminuirHandler implements EventHandler<ActionEvent> {

        @Override // Sobreescribimos el método handle (manejador)
        public void handle(ActionEvent e) {
            circlePane.disminuir();
        }
    }

    /**
     * El método main sólo es necesario para el IDE con soporte limitado de JavaFX.
     * No es necesario para ejecutar desde la línea de comandos.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

class CirclePane extends StackPane {

    private Circle circle = new Circle(50);

    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }

    public void aumentar() {
        circle.setRadius(circle.getRadius() + 2);
    }

    public void disminuir() {
        circle.setRadius(circle.getRadius() > 2
                ? circle.getRadius() - 2 : circle.getRadius() - 1);
    }
}
