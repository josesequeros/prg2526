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
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ja.buenoseva
 */
public class DatosPersonaControlador implements Initializable {

    @FXML
    private TextField textFieldNombrefxID;
    @FXML
    private TextField textFieldApellidofxID;
    @FXML
    private Button BSalvarfxID;
    @FXML
    private Button BCancelarfxID;

    private boolean pulsadoCancelar = true;
    private Persona personaModificada = null;

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

        if (textFieldNombrefxID.getText().isEmpty()
                || textFieldNombrefxID.getText().trim().length() == 0
                || textFieldApellidofxID.getText().isEmpty()
                || textFieldApellidofxID.getText().trim().length() == 0) {
            // no grabar

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos incorrectos");
            alerta.setContentText("El nombre y/o los apellidos no pueden estar vacíos");
            alerta.showAndWait();
        } else {
            //personaModificada = new Persona(textFieldNombrefxID.getText(),textFieldApellidofxID.getText());
            if (personaModificada == null) {
                personaModificada = new Persona(textFieldNombrefxID.getText(), textFieldApellidofxID.getText());
            } else {
                personaModificada.setNombre(textFieldNombrefxID.getText());
                personaModificada.setApellidos(textFieldApellidofxID.getText());
            }
            ((Button) event.getSource()).getScene().getWindow().hide();
        }
    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        pulsadoCancelar = true;
        ((Button) event.getSource()).getScene().getWindow().hide();
    }

    public void initPersona(Persona p) {
        textFieldNombrefxID.setText(p.getNombre());
        textFieldApellidofxID.setText(p.getApellidos());
        personaModificada = p;
    }

    public Persona getPersona() {
        return personaModificada;
    }

    public boolean getCancelar() {
        return pulsadoCancelar;
    }
}
