/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.tableviewdemo.Controladores;

import com.sequeros.tableviewdemo.Modelos.Persona;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jabue
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
    private TableColumn<Persona, String> nombreColumna;
    @FXML
    private TableColumn<Persona, String> apellidosColumna;
    @FXML
    private TableView<Persona> vistaTabla;

    private ObservableList<Persona> misPersonas;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Persona> misDatos = new ArrayList<>();
        misDatos.add(new Persona("Pepe","Gotera"));
        misDatos.add(new Persona("Pepe", "García"));
        misDatos.add(new Persona("María", "Pérez"));
        
        misPersonas = FXCollections.observableArrayList(misDatos);
        vistaTabla.setItems(misPersonas);
        //
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        apellidosColumna.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        //nombreColumna.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        //apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
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
