/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.menudialogoejemplo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class MenuDialogoController implements Initializable {

    @FXML
    private MenuItem miSalir;
    @FXML
    private MenuItem lanzarAmazon;
    @FXML
    private MenuItem lanzarBlogger;
    @FXML
    private MenuItem lanzarEbay;
    @FXML
    private MenuItem lanzarFacebook;
    @FXML
    private MenuItem lanzarGoogle;
    @FXML
    private RadioMenuItem RadioMenuAmazon;
    @FXML
    private ToggleGroup comprarEn;
    @FXML
    private RadioMenuItem RadioMenuEbay;
    @FXML
    private Label labelEstado;
    @FXML
    private Button botonAmazon;
    @FXML
    private Button botonBlogger;
    @FXML
    private Button botonEbay;
    @FXML
    private Button botonFacebook;
    @FXML
    private Button botonGoogle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //lanzarFacebook.setOnAction((ActionEvent e) -> usarFacebook());
        lanzarAmazon.setOnAction((ActionEvent e) -> comprarAmazon(e));
        lanzarBlogger.setOnAction((ActionEvent e) -> elegirBlog(e));
        lanzarEbay.setOnAction((ActionEvent e) -> comprarEbay(e));        
        lanzarGoogle.setOnAction((ActionEvent e) -> usarGooglePlus(e));
    }    

    @FXML
    private void salirPulsado(ActionEvent event) {
    }

    @FXML
    private void comprarAmazon(ActionEvent event) {
        if (RadioMenuAmazon.isSelected()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("Compra realizada correctamente");
            alert.setContentText("Has comprado en Amazon");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error en la selección");
            alert.setHeaderText("No puede comprar en Amazon");
            alert.setContentText("Por favor, cambie la selección actual en el menú de Opciones");
            alert.showAndWait();
        }        
    }

    @FXML
    private void elegirBlog(ActionEvent event) {
        List<String> choices = new ArrayList<>();
        choices.add("El blog de Athos");
        choices.add("El blog de Porthos");
        choices.add("El blog de Aramis");
        
        ChoiceDialog<String> dialog = new ChoiceDialog<>("El blog de Porthos", choices);
        dialog.setTitle("Seleccionar un blog");
        dialog.setHeaderText("¿Qué blog quieres visitar?");
        dialog.setContentText("Elige:");
        
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            labelEstado.setText("Visitando " + result.get());
        }        
    }

    @FXML
    private void comprarEbay(ActionEvent event) {
        if (RadioMenuEbay.isSelected()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("Compra realizada correctamente");
            alert.setContentText("Has comprado en Ebay");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error en la selección");
            alert.setHeaderText("No puede comprar en Ebay");
            alert.setContentText("Por favor, cambie la selección actual en el menú de Opciones");
            alert.showAndWait();
        }        
    }

    @FXML
    private void usarFacebook(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("Carmen");
        dialog.setTitle("Introduce tu nombre");
        dialog.setHeaderText("¿Con qué usuario quieres escribir en Facebook?");
        dialog.setContentText("Introduce tu nombre:");
        
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            labelEstado.setText("Mensaje enviado como " + result.get());
        }        
    }

    @FXML
    private void usarGooglePlus(ActionEvent event) {
    }
    
}
