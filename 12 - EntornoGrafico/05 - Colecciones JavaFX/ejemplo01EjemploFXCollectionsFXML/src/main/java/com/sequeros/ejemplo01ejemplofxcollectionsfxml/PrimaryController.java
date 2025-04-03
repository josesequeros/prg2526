package com.sequeros.ejemplo01ejemplofxcollectionsfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PrimaryController implements Initializable {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> lista = new ArrayList<>();
        // Creamos un AobservableList envolviendo el ArrayList
        ObservableList<String> listaObservable = FXCollections.observableList(lista);
        listaObservable.add("item uno");    // Añadimos un elemento a la lista observable
        lista.add("item dos");              // Añadimos un elemento al ArrayList
        // Comprobamos los tammaños de ambos: ambos tienen los mismos elementos
        System.out.println("Tamaño FXCollections: " + listaObservable.size());
        System.out.println("Tamaño lista: " + lista.size());

        // Añadimos un listener a la ObservableList
        // a) con un Listener
        listaObservable.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> arg0) {
                System.out.println("Cambio detectado");
            }
        });

        // b) con expresión lambda
        listaObservable.addListener((ListChangeListener.Change<? extends String> arg0) -> {
            System.out.println("Cambio detectado 1");
        });

        listaObservable.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> arg0) {
                System.out.println("Cambio detectado 2!");
                while (arg0.next()) {
                    System.out.println("Añadido? " + arg0.wasAdded());
                    System.out.println("Eliminado? " + arg0.wasRemoved());
                    System.out.println("Permutado? " + arg0.wasPermutated());
                    System.out.println("Reemplazado? " + arg0.wasReplaced());
                }
            }
        });

        System.out.println("Añadido un listener");
        System.out.println("Añadimos elemento a ObservableList");
        listaObservable.add("item tres");
        System.out.println("Añadimos elemento a ArrayList");
        lista.add("item cuatro");
        System.out.println("Comprobamos el tamaño de ambos");
        System.out.println("Tamaño FXCollections: " + listaObservable.size());
        System.out.println("Tamaño lista: " + lista.size());
        for (String string : listaObservable) {
            System.out.println(string);
        }
    }

}
