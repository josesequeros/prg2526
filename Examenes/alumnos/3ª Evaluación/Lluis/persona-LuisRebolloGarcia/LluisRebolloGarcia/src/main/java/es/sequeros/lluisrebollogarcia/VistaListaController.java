/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package es.sequeros.lluisrebollogarcia;

import es.sequeros.lluisrebollogarcia.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class VistaListaController implements Initializable {


    @FXML
    private Label selectedItem;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField correo;
    @FXML
    private TextField genero;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField pais;
    @FXML
    private TextField fechaNacimiento;
    @FXML
    private Label etiqueta;
    @FXML
    private ListView<Persona> vistaLista;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCerrar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<Persona> datos = FXCollections.observableArrayList();
        datos.add(new Persona("Pepe", "Gotera"));
        vistaLista.setItems(datos);
        
        
    }    
    
    @FXML
    private void addAccion(ActionEvent event) {
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
    }

    @FXML
    private void modificarAccion(ActionEvent event) {
       
    }

    @FXML
    private void cerrarAccion(ActionEvent event) {
    }

}
