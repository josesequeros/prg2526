/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.autoresexamen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author jabue
 */
public class AutoresController implements Initializable {


    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonSalirGrabando;
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
    private Button botonModificarAutor;
    @FXML
    private Button botonAplicar;
    @FXML
    private Button botonCancelar;
    @FXML
    private TableView<?> vistaTabla;
    @FXML
    private TableColumn<?, ?> dniColumna;
    @FXML
    private TableColumn<?, ?> nombreColumna;
    @FXML
    private TableColumn<?, ?> apellidosColumna;
    @FXML
    private TableColumn<?, ?> nacimientoColumna;
    @FXML
    private TableColumn<?, ?> imagenColumna;
    @FXML
    private MenuItem miSalir;
    @FXML
    private MenuItem miSalir1;
    @FXML
    private MenuItem miAdd;
    @FXML
    private MenuItem miModificar;
    @FXML
    private MenuItem miBorrar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void addAccion(ActionEvent event) {
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
    }

    @FXML
    private void salirGrabando(ActionEvent event) {
    }

    @FXML
    private void modificarAutor(ActionEvent event) {
    }

    @FXML
    private void aplicar(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }

    @FXML
    private void salirPulsado(ActionEvent event) {
    }

}
