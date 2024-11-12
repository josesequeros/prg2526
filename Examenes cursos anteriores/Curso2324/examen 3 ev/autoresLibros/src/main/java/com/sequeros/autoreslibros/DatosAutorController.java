/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.autoreslibros;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IEUser
 */
public class DatosAutorController implements Initializable {

    private boolean pulsadoCancelar = true; 
    private Autor autorModificada;

    @FXML
    private TextField dni;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField nacimiento;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField rutaImagen;
    @FXML
    private Button botonSalvar;
    @FXML
    private Button botonCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void salvarPulsado(ActionEvent event) {
        pulsadoCancelar = false;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(nacimiento.getText(), formatter);
            autorModificada = new Autor(
                    dni.getText(),
                    nombre.getText(),
                    apellidos.getText(),
                    date,
                    rutaImagen.getText());

            ((Button) event.getSource()).getScene().getWindow().hide();
        } catch (DateTimeParseException e) {
            // Manejar la excepción
            System.err.println("Error al analizar la fecha: " + e.getMessage());
            // Mostrar un diálogo de información al usuario
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error al analizar la fecha");
            alert.setContentText("Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
            Optional<ButtonType> result = alert.showAndWait();
            // Puedes realizar acciones adicionales según la respuesta del usuario si lo deseas
            pulsadoCancelar = true;
        }

    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        pulsadoCancelar = true;
        ((Button) event.getSource()).getScene().getWindow().hide();
    }

    public void initAutor(Autor autor) {
        dni.setText(autor.getDni());
        nombre.setText(autor.getNombre());
        apellidos.setText(autor.getApellidos());
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //nacimiento.setText(autor.getNacimiento().get().format(formatter));
        rutaImagen.setText(autor.getPathImagen());
        //ImageView view = new ImageView();
        //imagen.setImage(new Image("" + autor.getPathImagen()));
    }

    public boolean getCancelar() {
        return pulsadoCancelar;
    }

    public Autor getAutor() {
        return autorModificada;
    }
}
