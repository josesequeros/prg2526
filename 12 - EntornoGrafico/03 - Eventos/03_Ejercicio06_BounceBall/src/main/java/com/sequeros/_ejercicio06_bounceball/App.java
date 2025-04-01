package com.sequeros._ejercicio06_bounceball;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane(); // Crear objeto ball pane

        // Pausar y reanudar la animación
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        // Increase and decrease animation   
        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                ballPane.aumentarVelocidad();
            } else if (e.getCode() == KeyCode.DOWN) {
                ballPane.disminuirVelocidad();
            }
        });

        // Crear una escena y colocarla en el escenario
        Scene scene = new Scene(ballPane, 250, 150);
        primaryStage.setTitle("Test BounceBall");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Debe solicitar el foco después de que aparezca el escenario principal
        ballPane.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }

}
