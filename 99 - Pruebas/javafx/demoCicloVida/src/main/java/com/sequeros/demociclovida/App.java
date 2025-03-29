package com.sequeros.demociclovida;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        System.out.println("En el método init()");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Demo Ciclo de Vida");
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
        System.out.println("En el método start()");
    }

    @Override
    public void stop() {
        System.out.println("En el método stop()");
    }
}
