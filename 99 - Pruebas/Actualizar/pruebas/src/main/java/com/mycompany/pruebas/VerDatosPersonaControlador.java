/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.pruebas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ja.buenoseva
 */
public class VerDatosPersonaControlador implements Initializable {

    @FXML
    private TextField textFieldNombrefxID;
    @FXML
    private TextField textFieldApellidofxID;
    @FXML
    private Button BCerrarfxID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cerrarPulsado(ActionEvent event) {
    }

    public void initPersona(Persona p) {
        textFieldNombrefxID.setText(p.getNombre());
        textFieldApellidofxID.setText(p.getApellidos());
    }
}
