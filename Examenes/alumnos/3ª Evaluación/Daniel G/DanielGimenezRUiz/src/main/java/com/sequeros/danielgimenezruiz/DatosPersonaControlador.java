/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.danielgimenezruiz;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dangimrui
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
    
    private ObservableList<Persona> listaPersona;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void salvarPulsado(ActionEvent event) {
        
        try {
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
            LocalDate fecha = LocalDate.parse(nacimiento.getText().trim(), formatter);

            Persona nuevo = new Persona(
                nombre.getText().trim(),
                apellidos.getText().trim(),
                correo.getText().trim(),
                genero.getText().trim(),
                fecha,
                pais.getText().trim()
            );

            // EXAMEN: añadir a la ObservableList → la TableView del padre se actualiza sola
            listaPersona.add(nuevo);
            cerrarVentana();

        } catch (DateTimeParseException e) {
            mostrarError("Error de fecha", "Error al analizar la fecha",
                "Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
        }
    }

    @FXML
    private void cancelarPulsado(ActionEvent event){
        cerrarVentana();
    }
    
    public void setListaPersona(ObservableList<Persona> lista) {
        this.listaPersona = lista;
    }
    
    private void cerrarVentana() {
        Stage stage = (Stage) nacimiento.getScene().getWindow();
        stage.close();
    }
    
    private void mostrarError(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    
}
