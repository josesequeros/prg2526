/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.joseluismontesinosboyer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
/**
 * FXML Controller class
 *
 * @author Joselu
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void salvarPulsado(ActionEvent event) {
    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
    }

    @FXML
    private void actionNombre(ActionEvent event) {
    }

    @FXML
    private void actionApellidos(ActionEvent event) {
    }

    @FXML
    private void actionCorreo(ActionEvent event) {
    }

    @FXML
    private void actionGenero(ActionEvent event) {
    }

    @FXML
    private void actionNacimiento(ActionEvent event) {
    }

    @FXML
    private void actionPais(ActionEvent event) {
    }

}
