/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ejemplotableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Button votonAdd;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonBorrar;
    @FXML
    private TableView<Persona> vistaTabla;
    @FXML
    private TableColumn<Persona, String> nombreColumna;
    @FXML
    private TableColumn<Persona, String> apellidosColumna;

    private ObservableList<Persona> datos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        datos = FXCollections.observableArrayList();
        datos.add(new Persona("Pepe","Gotera"));
        datos.add(new Persona("Pepe", "García"));
        datos.add(new Persona("María", "Pérez"));
        vistaTabla.setItems(datos);
        //nombreColumna.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        //apellidosColumna.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
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
