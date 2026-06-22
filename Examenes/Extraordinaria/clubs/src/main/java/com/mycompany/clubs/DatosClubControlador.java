/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.clubs;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author ja.buenoseva
 */
public class DatosClubControlador implements Initializable {

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
    private TextField imagen;
    @FXML
    private TextField deportistas;
    @FXML
    private TextField nomina;

    Club clubModificada = null;
    @FXML
    private ImageView escudo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                imagen.textProperty().addListener(
                (o, oldVal, newVal) -> {
                    try {
                        escudo.setImage(new Image(newVal + ""));
                    } catch (IllegalArgumentException e) {
                        escudo.setImage(null);
                    }
                });
    }

    @FXML
    private void salvarPulsado(ActionEvent event) {

        if (nombre.getText().isEmpty()
                || nombre.getText().trim().length() == 0) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos incorrectos");
            alerta.setContentText("El nombre y/o los apellidos no pueden estar vacíos");
            alerta.showAndWait();
        } else {
            if (clubModificada == null) {
                clubModificada = new Club(
                        nombre.getText(),
                        imagen.getText()
                );
            } else {
                clubModificada.setNombre(nombre.getText());
                clubModificada.setImagen(imagen.getText());
            }
            ((Button) event.getSource()).getScene().getWindow().hide();
        }

    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        ((Button) event.getSource()).getScene().getWindow().hide();
    }

    public Club getClub() {
        return clubModificada;
    }

}
