package com.biblioteca.antonherneha;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.io.*;
import java.util.*;

public class PrimaryController {


    @FXML private ListView<LibroFiccion> lista;
    ObservableList<LibroFiccion> libros = FXCollections.observableArrayList();
    String archivo = "libros.txt";

    @FXML
    public void initialize() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String l;
        while ((l = br.readLine()) != null)
        br.close();
        lista.setItems(libros);
    }

    @FXML
    void añadir() {
    TextInputDialog d = new TextInputDialog();
    d.setHeaderText("Título"); String titulo = d.showAndWait().get();
    d.setHeaderText("Autor"); String autor = d.showAndWait().get();
    d.setHeaderText("Año"); int anyo = Integer.parseInt(d.showAndWait().get());
    d.setHeaderText("Editorial"); String editorial = d.showAndWait().get();
    libros.add(new LibroFiccion(titulo, autor, anyo, editorial));
}


    @FXML
    void borrar() {
        int i = lista.getSelectionModel().getSelectedIndex();
        if (i >= 0) libros.remove(i);
    }

    @FXML
    void salir() throws IOException {
        PrintWriter pw = new PrintWriter(archivo);
        for (LibroFiccion l : libros)
            pw.println(l.aTexto());
        pw.close();
        System.exit(0);
    }
}

  