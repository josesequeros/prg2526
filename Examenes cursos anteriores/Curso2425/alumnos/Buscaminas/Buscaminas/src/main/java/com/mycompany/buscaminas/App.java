package com.mycompany.buscaminas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    //Inicializamos la escena
    private static Scene scene;

    //Al iniciar la aplicacion, cargamos la escena que hemos inicializado con el fxml que queremos que aparezca el primero, en mi caso, inicio.
    //Como se pide en la práctica, la ventana no se puede redimensionar y el nombre de la ventana es "Buscaminas de Cristina Murcia".
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("inicio"));
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("Buscaminas de Cristina Murcia");
        stage.show();
    }

    //Este método nos permite cambiar de escena desde cualquier parte del código, simplemente llamando a este método y pasándole el nombre del fxml al que queremos cambiar.
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    //Este metodo nos muestra el fxml que le pasamos como parámetro sin cambiar la escena en la que estamos.
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    //Método main que lanza la aplicación
    public static void main(String[] args) {
        launch();
    }

}