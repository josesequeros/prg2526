/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.listviewpersona;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class DatosPersonaControlador {
@FXML
private TextField textFieldNombrefxID;
@FXML
private TextField textFieldApellidofxID;
private String nombre;
private String apellido;
private String correo;
private String genero;
private boolean guardar = false;
    @FXML
    private TextField correotextfield;
    @FXML
    private Button BSalvarfxID;
    @FXML
    private Button BCancelarfxID;
    @FXML
    private TextField generotextfield;
@FXML
private void salvarPulsado() {
nombre = textFieldNombrefxID.getText();
apellido = textFieldApellidofxID.getText();
correo=correotextfield.getText();
genero=generotextfield.getText();
guardar = true;
cerrarVentana();
}
@FXML
private void cancelarPulsado() {
guardar = false;
cerrarVentana();
}
private void cerrarVentana() {
Stage stage = (Stage) textFieldNombrefxID.getScene().getWindow();
stage.close();
}
public boolean isGuardar() {
return guardar;
}
public String getNombre() {
return nombre;
}
public String getApellido() {
return apellido;

}
public void setDatos(String nombre, String apellido,String correo,String genero) {
textFieldNombrefxID.setText(nombre);
textFieldApellidofxID.setText(apellido);
correotextfield.setText(correo);
generotextfield.setText(genero);
}

    public String getCorreo() {
        return correo;
    }
}
