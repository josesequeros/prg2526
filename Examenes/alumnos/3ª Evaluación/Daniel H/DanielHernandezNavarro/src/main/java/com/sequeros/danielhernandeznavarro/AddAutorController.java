/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.danielhernandeznavarro;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAutorController implements Initializable {

    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @FXML private TextField nameField;
    @FXML private TextField subField;
    @FXML private TextField dateField;
    @FXML private TextField imageField;
    @FXML private Button salvarButton;
    @FXML private Button cancelarButton;

    private ObservableList<Autor> listaAutores;


    public void setListaAutores(ObservableList<Autor> lista) {
        this.listaAutores = lista;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    private boolean validarCampos() {
       
        try {
            LocalDate.parse(dateField.getText().trim(), FORMATTER);
        } catch (DateTimeParseException e) {
            mostrarError("Error de fecha", "Error al analizar la fecha",
                "Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
            return false;
        }
        return true;
    }

    /**
     * EXAMEN: para cerrar una ventana secundaria se obtiene el Stage desde
     * cualquier nodo de la escena y se llama a close().
     */

    private void mostrarError(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
