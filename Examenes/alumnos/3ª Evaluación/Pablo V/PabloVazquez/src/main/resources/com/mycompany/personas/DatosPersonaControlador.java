/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.personas;

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
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author pabvazrui
 */
public class DatosPersonaControlador {


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
    
    private String nombre;
    private String apellido;
    private String correo;
    private String genero;
    private String nacimiento;
    private String pais;
    private boolean guardar = false;
    /**
     * Initializes the controller class.
     */
    
    
    
    @FXML
    private TextField textFieldNombrefxID;
    @FXML
    private TextField textFieldApellidofxID;
    @FXML
    private TextField textFieldCorreofxID;
    @FXML
    private TextField textFieldGenerofxID;
    @FXML
    private TextField textFieldNacimientofxID;
    @FXML
    private TextField textFieldPaisfxID;
    
    

    @FXML
    private void salvarPulsado() {
        nombre = textFieldNombrefxID.getText();
        apellido = textFieldApellidofxID.getText();
        correo = textFieldCorreofxID.getText();
        genero = textFieldGenerofxID.getText();
        nacimiento = textFieldNacimientofxID.getText();
        pais = textFieldPaisfxID.getText();
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

    public String getCorreo() {
        return correo;
    }

    public String getGenero() {
        return genero;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getPais() {
        return pais;
    }
    
    

    public void setDatos(String nombre, String apellido, String correo, String genero, String nacimiento,
            String pais) {
        textFieldNombrefxID.setText(nombre);
        textFieldApellidofxID.setText(apellido);
        textFieldCorreofxID.setText(correo);
        textFieldGenerofxID.setText(genero);
        textFieldNacimientofxID.setText(nacimiento);
        textFieldPaisfxID.setText(pais);
        
    }

}
