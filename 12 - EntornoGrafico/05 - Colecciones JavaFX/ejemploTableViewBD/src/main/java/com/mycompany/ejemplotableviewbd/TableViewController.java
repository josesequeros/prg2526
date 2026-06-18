/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ejemplotableviewbd;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author ja.buenoseva
 */
public class TableViewController implements Initializable {

    @FXML
    private Button botonVer;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonBorrar;
    @FXML
    private TableView<?> vistaTabla;
    @FXML
    private TableColumn<?, ?> nombreColumna;
    @FXML
    private TableColumn<?, ?> apellidosColumna;
    @FXML
    private TableColumn<?, ?> imagenColumna;
    @FXML
    private TableColumn<?, ?> correoColumna;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Db.crearTablaSiNoExiste();
        System.out.println(Db.cargarDatos().size());
    }    

    @FXML
    private void verAccion(ActionEvent event) {
    }

    @FXML
    private void addAccion(ActionEvent event) {
    }

    @FXML
    private void modificarAccion(ActionEvent event) {
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
    }
    
}
