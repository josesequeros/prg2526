package com.sequeros.pruebasolitario02;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
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
        Canvas canvas = new Canvas(900, 800);

        Pane root = new Pane(canvas);

        Scene scene = new Scene(root, Color.DARKGREEN);

        //Game game = new Game(canvas.getGraphicsContext2D());
        //canvas.setOnMouseClicked(game::handleMouseClicked);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Solitario");
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
