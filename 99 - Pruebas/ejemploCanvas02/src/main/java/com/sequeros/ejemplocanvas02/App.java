package com.sequeros.ejemplocanvas02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(10);
        canvas.setOnMousePressed(e -> gc.beginPath());
        canvas.setOnMouseDragged(e -> {
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
        });
        canvas.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                clear(gc);
            }
        });
        stage.setTitle("Dibujando en un Canvas");
        stage.setScene(new Scene(new StackPane(canvas), WIDTH, HEIGHT));
        stage.show();
        clear(gc);
    }

    public static void main(String[] args) {
        launch();
    }

    private void clear(GraphicsContext gc) {
        gc.setFill(Color.DARKBLUE);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setStroke(Color.ALICEBLUE);
    }

}
