/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.josemiguelgimenogarcia;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author josgimgar3
 */

public class DatosPersonaControlador implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label encabezado;
    @FXML
    private Button botonSalvar;
    @FXML
    private Button botonCancelar;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField correo;
    @FXML
    private TextField genero;
    @FXML
    private TextField nacimiento;
    @FXML
    private TextField pais;
    @FXML
    private ImageView imagen;
    
    private ObservableList<Persona> listaAutores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void salvarPulsado(ActionEvent event) {
        // Validar antes de nada
        if (!validarCampos()) {
            return;
        }

        String dni = nombre.getText().trim().toUpperCase();

        // EXAMEN – Punto 5: comprobar DNI duplicado recorriendo la lista
       
        try {
            // EXAMEN: LocalDate.parse() con el formatter convierte String → LocalDate
            LocalDate fecha = LocalDate.parse(nacimiento.getText().trim(), FORMATTER);

            Persona nuevo = new Persona(
                    dni,
                    nombre.getText().trim(),
                    apellidos.getText().trim(),
                    fecha,
                    imageField.getText().trim()
            );

            // EXAMEN: añadir a la ObservableList → la TableView del padre se actualiza sola
            listaAutores.add(nuevo);
            cerrarVentana();

        } catch (DateTimeParseException e) {
            mostrarError("Error de fecha", "Error al analizar la fecha",
                    "Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
        }
    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        Stage stage = (Stage) nombre.getScene().getWindow();
        stage.close();
    }
     private void mostrarError(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
     private void cerrarVentana() {
        Stage stage = (Stage) nombre.getScene().getWindow();
        stage.close();
    }
      p
}
 


