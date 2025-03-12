package com.sequeros.ejemplo02rectangulo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Rectangle r = new Rectangle(100, 100);
        StackPane p = new StackPane();
        p.setPrefWidth(200);
        p.setPrefHeight(200);
        p.getChildren().add(r);
        p.widthProperty().addListener(
                (observable, oldvalue, newvalue)
                -> r.setWidth((Double) newvalue / 2)
        );
        p.heightProperty().addListener(
                (observable, oldvalue, newvalue)
                -> r.setHeight((Double) newvalue / 2)
        );

        Scene scene = new Scene(p);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Auto Rectangle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
