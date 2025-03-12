package com.sequeros.ejemplo01ejemplofxcollections;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();
        // Creamos el ArrayList
        List<String> lista = new ArrayList<>();
        // Creamos un AobservableList envolviendo el ArrayList
        ObservableList<String> listaObservable = FXCollections.observableList(lista);
        listaObservable.add("item uno");    // Añadimos un elemento a la lista observable
        lista.add("item dos");              // Añadimos un elemento al ArrayList
        // Comprobamos los tammaños de ambos: ambos tienen los mismos elementos
        System.out.println("Tamaño FXCollections: " + listaObservable.size());
        System.out.println("Tamaño lista: " + lista.size());
        
        // Añadimos un listener a la ObservableList
        listaObservable.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> arg0) {
                System.out.println("Cambio detectado");
            }
        });
        System.out.println("Añadido un listener");
        System.out.println("Añadimos elemento a ObservableList");
        listaObservable.add("item tres");
        System.out.println("Añadimos elemento a ArrayList");
        lista.add("item tres");
        System.out.println("Comprobamos el tamaño de ambos");
        System.out.println("Tamaño FXCollections: " + listaObservable.size());
        System.out.println("Tamaño lista: " + lista.size());
    }

}
