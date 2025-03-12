/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.tableviewimagen.Controladores;

import com.sequeros.tableviewimagen.Modelos.Persona;
import com.sequeros.tableviewimagen.Modelos.Residencia;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IEUser
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

    private boolean pulsadoCancelar = true; // evitar el error al salir por la X
    private Persona personaModificada;
    @FXML
    private TextField tfCiudad;
    @FXML
    private TextField tfProvincia;
    @FXML
    private TextField tfImagen;

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
        personaModificada = new Persona(
                textFieldNombrefxID.getText(),
                textFieldApellidofxID.getText(),
                new Residencia(tfCiudad.getText(),tfProvincia.getText()),
                tfImagen.getText()
        );
        ((Button) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        pulsadoCancelar = true;
        ((Button) event.getSource()).getScene().getWindow().hide();
    }

    public void initPersona(Persona p) {
        textFieldNombrefxID.setText(p.getNombre());
        textFieldApellidofxID.setText(p.getApellidos());
        Residencia residencia = p.getResidencia();
        tfCiudad.setText(residencia.getCiudad());
        tfProvincia.setText(p.getResidencia().getProvincia());
        tfImagen.setText(p.getPathImagen());
    }

    public boolean getCancelar() {
        return pulsadoCancelar;
    }

    public Persona getPersona() {
        return personaModificada;
    }
}
