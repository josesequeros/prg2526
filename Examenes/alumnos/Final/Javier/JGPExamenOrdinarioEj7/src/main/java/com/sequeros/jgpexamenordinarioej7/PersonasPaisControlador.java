/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.jgpexamenordinarioej7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author javgarper6
 */
public class PersonasPaisControlador implements Initializable {
    
    @FXML
    private TableView<Persona> vistaTabla;
    @FXML
    private TableColumn<Persona, String> colGenero;
    @FXML
    private TableColumn<Persona, String> colNombre;
    @FXML
    private TableColumn<Persona, String> colApellidos;
    @FXML
    private TableColumn<Persona, String> colCorreo;
    @FXML
    private TableColumn<Persona, String> colImagen;
    
    private ObservableList<Persona> listaObservable = FXCollections.observableArrayList();
    private ObservableList<Persona> listaObservable2;
    private String pais;
    
    public void setListaObservable(ObservableList<Persona> lista) {
        this.listaObservable = lista;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Pais: " + this.pais);
        System.out.println("-->" + this.listaObservable);
    }    
    
    public void sendValues() {
        System.out.println("Pais: " + this.pais);
        System.out.println("-->" + this.listaObservable);
        vistaTabla.setItems(this.listaObservable);
        
        colGenero.setCellValueFactory(cellData -> cellData.getValue().GeneroProperty());
        
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("Email"));
        
        colImagen.setCellValueFactory(cellData -> cellData.getValue().PaisProperty());
        
    }
}
