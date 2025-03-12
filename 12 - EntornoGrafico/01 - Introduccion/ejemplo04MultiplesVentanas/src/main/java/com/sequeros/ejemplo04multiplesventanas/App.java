package com.sequeros.ejemplo04multiplesventanas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override // Sobrescribimos el método start de la clase Application
    public void start(Stage primaryStage) {
        // Crear una scene colocando un botón en la ella
        Scene scene = new Scene(new Button("En el Stage Primary"), 200, 250);
        primaryStage.setTitle("MiJavaFX"); // Definimos el título del stage
        primaryStage.setScene(scene); // colocamos la scene en el stage
        primaryStage.show(); // Display el stage

        Stage stage = new Stage(); // Crea un nuevo stage
        stage.setTitle("Segundo Stage"); // Definimos el título del stage
        // Actualiza una scene con un botón (button) en el stage (ventana)
        stage.setScene(new Scene(new Button("Segundo Stage"), 100, 100));
        stage.show(); // Display el stage

    }

    /**
     * El método main solo es necesario para el IDE con soporte limitado de JavaFX. No es necesario para su ejecución desde la línea
     * de comando.
     */
    public static void main(String[] args) {
        launch();
    }

}
