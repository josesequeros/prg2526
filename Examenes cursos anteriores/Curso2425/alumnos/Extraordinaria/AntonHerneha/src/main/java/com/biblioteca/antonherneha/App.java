package com.biblioteca.antonherneha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 * JavaFX App
 */

public class App extends Application {

    @Override
    public void start(Stage ventana) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("primary.fxml"));
        Scene escena = new Scene(fxml.load());
        ventana.setTitle("Biblioteca - Anton Herneha");
        ventana.setScene(escena);
        ventana.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
