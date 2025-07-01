/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.autores_sanaekassari;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sankas
 */
public class AddAutorController implements Initializable {

    boolean cancelar = true;

    @FXML
    private TextField dni;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField nacimiento;
    @FXML
    private TextField ruta;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnCerrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void add(ActionEvent event) {
        cancelar = false;
        btnAdd.setOnMouseClicked(MouseEvent -> {
            Stage stage = (Stage) btnAdd.getScene().getWindow();
            stage.close();

        });
    }

    @FXML
    private void cerrar(ActionEvent event) {
        Node n = (Node) event.getSource();
        n.getScene().getWindow().hide();
    }

    void initPersona(Autor autor) {
        dni.setText(autor.getDni());
        nombre.setText(autor.getNombre());
        apellidos.setText(autor.getApellidos());
        nacimiento.setText(autor.getNacimiento());
        ruta.setText(autor.getPathImagen());
    }

    boolean getCancelar() {
        return cancelar;
    }

    Autor getPersona() {
        Autor autor = new Autor(dni.getText(), nombre.getText(), apellidos.getText(), nacimiento.getText(), ruta.getText());
        return autor;
    }

}
