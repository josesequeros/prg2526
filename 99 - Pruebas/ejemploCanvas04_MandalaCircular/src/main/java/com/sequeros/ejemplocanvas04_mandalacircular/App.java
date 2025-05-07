package com.sequeros.ejemplocanvas04_mandalacircular;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        int ancho = 600;
        int alto = 600;
        int radio = 200;

        Canvas canvas = new Canvas(ancho, alto);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Dibujar mandala
        dibujarMandala(gc, ancho / 2, alto / 2, radio, 60); // centro, radio, repeticiones

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, ancho, alto);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void dibujarMandala(GraphicsContext gc, int cx, int cy, int radio, int repeticiones) {
        double anguloPaso = 360.0 / repeticiones;
        double divisiones = 20;

        for (int i = 0; i < repeticiones; i++) {
            double angulo = Math.toRadians(i * anguloPaso);

            // Coordenadas en círculo
            double x = cx + Math.cos(angulo) * radio;
            double y = cy + Math.sin(angulo) * radio;

            // Línea desde el centro
            gc.setStroke(Color.hsb(i * (360.0 / repeticiones), 1, 1));
            //gc.strokeLine(cx, cy, x, y);

            // Círculo en el extremo
            gc.setFill(Color.hsb(i * (360.0 / repeticiones), 0.7, 0.9));
            //gc.fillOval(x - 10, y - 10, 20, 20);
            gc.strokeOval(x - 10, y - 10, 20, 20);
            for (int j = 0; j < divisiones; j++) {
                double xx = cx + Math.cos(angulo) * radio * (j + 1) / divisiones;
                double yy = cy + Math.sin(angulo) * radio * (j + 1) / divisiones;
                gc.strokeOval(xx - 10, yy - 10, 20, 20);
            }

        }
    }

}
