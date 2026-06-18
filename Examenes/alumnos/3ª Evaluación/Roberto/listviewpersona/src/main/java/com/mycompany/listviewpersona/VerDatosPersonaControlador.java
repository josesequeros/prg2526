/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.listviewpersona;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class VerDatosPersonaControlador {
@FXML
private TextField textFieldNombrefxID;
@FXML
private TextField textFieldApellidofxID;
    @FXML
    private TextField textFieldCorreo;
    @FXML
    private Button BCerrarfxID;
public void setDatos(String nombre, String apellido,String Correo,String genero) {
textFieldNombrefxID.setText(nombre);
textFieldApellidofxID.setText(apellido);
textFieldApellidofxID.setText(Correo);
textFieldApellidofxID.setText(genero);
textFieldNombrefxID.setEditable(false);
textFieldApellidofxID.setEditable(false);
}
@FXML
private void cerrarPulsado() {
Stage stage = (Stage) textFieldNombrefxID.getScene().getWindow();
stage.close();
}
}
