package com.sequeros.ejemplocanvas03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int RECT = 100;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFont(Font.font(12));
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setStroke(Color.LIGHTGRAY);
        for (int i = 0; i < WIDTH; i += RECT) {
            for (int j = 0; j < HEIGHT; j += RECT) {
                gc.strokeRect(i, j, RECT, RECT);
                gc.setFill(Color.BLUE);
                gc.fillText("x=" + i + ",y=" + j, i + 2, j + 12);
            }
        }

        canvas.setOnMouseClicked(e -> {
            gc.setFill(Color.BLUEVIOLET);
            gc.fillText("("+e.getX()+","+e.getY()+")", e.getX(), e.getY());
        });

        stage.setScene(new Scene(new StackPane(canvas), WIDTH, HEIGHT));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
