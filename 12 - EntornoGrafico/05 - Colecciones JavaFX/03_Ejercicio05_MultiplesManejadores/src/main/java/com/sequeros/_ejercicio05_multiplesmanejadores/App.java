package com.sequeros._ejercicio05_multiplesmanejadores;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private final Random random = new Random(); // Para generar colores aleatorios

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Crear un círculo en el centro de la ventana
        Circle circle = new Circle(200, 150, 50, Color.BLUE);

        // Primer manejador: Cambia el color del círculo a un color aleatorio
        //circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
        // 🔹 Manejador en la fase de "Captura": Cambia el color y DETIENE la propagación
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            circle.setFill(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            System.out.println("Color cambiado");
            //event.consume();
        });

        // Segundo manejador: Imprime la posición del clic en la consola
        // 🔹 Manejador en la fase de "Burbuja" (Propagación): Muestra la posición del clic (NO se ejecutará si event.consume())
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("Círculo en posición: X = " + event.getSceneX() + ", Y = " + event.getSceneY());
        });

        // Tercer manejador (opcional): Aumenta el tamaño del círculo con cada clic
        // 🔹 Manejador en la fase de "Burbuja" (Propagación): Muestra la posición del clic (NO se ejecutará si event.consume())
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            int valor=0;
            if (event.getButton() == MouseButton.SECONDARY) {
                valor = -5;
            } else {
                valor = 5;
            }
            circle.setRadius(circle.getRadius() + valor);
            System.out.println("Tamaño aumentado: Radio = " + circle.getRadius());
        });


        root.getChildren().add(circle);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Múltiples Manejadores de Eventos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
