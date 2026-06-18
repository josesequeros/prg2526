package com.sequeros.practicaexamenterceraevaluacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Platform;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ControlInicio.fxml"));
        Parent root = loader.load();
        ControlInicioController ctrl = loader.getController();

        Scene scene = new Scene(root, 900, 650);
        stage.setTitle("Personas del Mundo");
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(e -> {
            e.consume();
            if(ctrl.pedirConfirmacionSalir()){Platform.exit();}
        });

    }

    public static void main(String[] args) {
        launch();
    }
}
