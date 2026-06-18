/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.practicaexamenterceraevaluacion;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class AddAutorController implements Initializable {


    @FXML
    private TextField emailField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField subField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField generoField;
    @FXML
    private TextField paisField;
    @FXML
    private Button salvarButton;
    @FXML
    private Button cancelarButton;
   
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private ObservableList<Persona> listaPersonas;
    
     public void setListaPersonas(ObservableList<Persona> lista) {
        this.listaPersonas = lista;
    }
            
            
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleSalvar(ActionEvent event) {
                if (!validarCampos()) return;


        for (Persona a : listaPersonas) {
            if (a.getEmail().equalsIgnoreCase(emailField.getText().trim().toUpperCase())) {
                mostrarError("DNI duplicado", "Ya existe ese DNI",
                        "Ya hay un autor con el DNI " + emailField.getText().trim().toUpperCase() + ". Introduce otro.");
                return;
            }
        }

        try {
            LocalDate fecha = LocalDate.parse(dateField.getText().trim(), FORMATTER);
            String genero = generoField != null ? generoField.getText().trim().toUpperCase() : "";

            // → constructor en Persona.java
            Persona nuevo = new Persona(
                    
                    nameField.getText().trim(),
                    subField.getText().trim(),
                    emailField.getText().trim(),
                    genero,
                    fecha, 
                    paisField != null ? paisField.getText().trim() : ""
            );

            listaPersonas.add(nuevo); // ObservableList → la tabla del padre se refresca sola
            cerrarVentana();

        } catch (DateTimeParseException e) {
            mostrarError("Error de fecha", "Error al analizar la fecha",
                    "Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
        }
    }

    @FXML
    private void handleCancelar(ActionEvent event) {
        cerrarVentana();
    }
private boolean validarCampos() {
        if (emailField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty()
                || subField.getText().trim().isEmpty() || dateField.getText().trim().isEmpty()) {
            mostrarError("Campos vacíos", "Error de validación", "No puede haber campos vacíos.");
            return false;
        }
        try {
            LocalDate.parse(dateField.getText().trim(), FORMATTER);
        } catch (DateTimeParseException e) {
            mostrarError("Error de fecha", "Error al analizar la fecha",
                    "Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
            return false;
        }
        return true;
    }
 private void cerrarVentana() {
        ((Stage) emailField.getScene().getWindow()).close();
    }
private void mostrarError(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
