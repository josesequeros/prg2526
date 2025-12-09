/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ejemplo.prueba2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PrimaryController implements Initializable {

    @FXML
    private Button BTanyadir;
    @FXML
    private TableView<ObservableList<String>> modelo;

    @FXML
    private TableColumn<ObservableList<String>, String> TVtitulo;
    @FXML
    private TableColumn<ObservableList<String>, String> TVautor;
    @FXML
    private TableColumn<ObservableList<String>, String> TVpublicacion;
    @FXML
    private TableColumn<ObservableList<String>, String> TVisbn;
    @FXML
    private TableColumn<ObservableList<String>, ImageView> TVimg;

    @FXML
    private Button BTborrar;
    @FXML
    private Button BTmodificar;
    @FXML
    private TextField TFtitulo;
    @FXML
    private TextField TFautor;
    @FXML
    private TextField TFimg;
    @FXML
    private TextField TFpublicacion;
@FXML
    private TextField TFISBN;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelo.setEditable(true);

        TVtitulo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(0)));
        TVautor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(1)));
        TVpublicacion.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(2)));
        TVisbn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(4)));

        TVimg.setCellValueFactory(data -> {
            String urlImg = data.getValue().size() > 3 ? data.getValue().get(3) : "";
            ImageView imgView = new ImageView();
            try {
                Image img = new Image(urlImg, 300, 300, true, true);
                imgView.setImage(img);
            } catch (Exception e) {
                System.out.println("Error cargando imagen: " + urlImg);
            }
            return new SimpleObjectProperty<>(imgView);
        });
        cargarDesdeArchivo();
    }

    @FXML
    private void anyadir(ActionEvent event) {
        String titulo = TFtitulo.getText();
        String autor = TFautor.getText();
        String publicacion = TFpublicacion.getText();
        String ISBN = TFISBN.getText();
        String img = TFimg.getText();

        ObservableList<String> fila = FXCollections.observableArrayList(titulo, autor, publicacion,ISBN, img);
        modelo.getItems().add(fila);

        limpiarcampos();
        guardarEnArchivo();
    }

    @FXML
    private void borrar(ActionEvent event) {
    ObservableList<ObservableList<String>> seleccionadas = modelo.getSelectionModel().getSelectedItems();

    if (!seleccionadas.isEmpty()) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(" eliminación");
        alerta.setHeaderText("¿Estás seguro de borrar la persona seleccionada?");
        ButtonType botonSi = new ButtonType("Sí");
        ButtonType botonNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alerta.getButtonTypes().setAll(botonSi, botonNo);

        alerta.showAndWait().ifPresent(respuesta -> {
            if (respuesta == botonSi) {
                modelo.getItems().removeAll(seleccionadas);
                guardarEnArchivo();
            }
        });
    } else {
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Aviso");
        info.setHeaderText(null);
        info.setContentText("No hay filas seleccionadas para borrar.");
        info.showAndWait();
    }
}

    @FXML
    private void modificar(ActionEvent event) {
        ObservableList<ObservableList<String>> seleccionadas = modelo.getSelectionModel().getSelectedItems();
        int selectedIndex = modelo.getSelectionModel().getSelectedIndex();
        if (!seleccionadas.isEmpty()) {
   
            String titulo = TFtitulo.getText();
        String autor = TFautor.getText();
        String publicacion = TFpublicacion.getText();
        String ISBN = TFISBN.getText();
        String img = TFimg.getText();

            ObservableList<String> filaModificada = FXCollections.observableArrayList(titulo, autor, publicacion,ISBN, img);
            modelo.getItems().set(selectedIndex, filaModificada);
            limpiarcampos();
            guardarEnArchivo();
        }
        else{
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Aviso");
        info.setHeaderText(null);
        info.setContentText("No hay filas seleccionadas para modificar.");
        info.showAndWait();
        }
    }

    private void limpiarcampos() {
        TFtitulo.clear();
        TFautor.clear();
        TFpublicacion.clear();
        TFISBN.clear();
        TFimg.clear();
    }
    private void guardarEnArchivo() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("personas.txt"))) {
        for (ObservableList<String> fila : modelo.getItems()) {
            String linea = String.join(",", fila);
            writer.write(linea);
            writer.newLine();
        }
        System.out.println("Datos guardados correctamente en personas.txt");
    } catch (IOException e) {
        e.printStackTrace();
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText("No se pudo guardar el archivo");
        alerta.setContentText(e.getMessage());
        alerta.showAndWait();
    }
}
private void cargarDesdeArchivo() {
    try {
        java.nio.file.Path path = java.nio.file.Paths.get("personas.txt");
        if (!java.nio.file.Files.exists(path)) {
            return; // Si no existe el archivo, no hacemos nada
        }

        java.util.List<String> lineas = java.nio.file.Files.readAllLines(path);
        modelo.getItems().clear(); // Limpiar la tabla antes de cargar

        for (String linea : lineas) {
            String[] partes = linea.split(",", -1); // "-1" para incluir campos vacíos
            if (partes.length >= 5) {
                ObservableList<String> fila = FXCollections.observableArrayList(partes[0], partes[1], partes[2], partes[3],partes[4]);
                modelo.getItems().add(fila);
            }
        }

        System.out.println("Datos cargados desde personas.txt");

    } catch (IOException e) {
        e.printStackTrace();
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText("No se pudo leer el archivo");
        alerta.setContentText(e.getMessage());
        alerta.showAndWait();
    }
}

}

