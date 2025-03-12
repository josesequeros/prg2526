/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.movercirculo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IEUser
 */
public class MoverCirculoController implements Initializable {

    @FXML
    private GridPane miGridPane;
    @FXML
    private Circle circulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void moverCirculo(KeyEvent event) {
        int fila = miGridPane.getRowIndex(circulo);
        int columna = miGridPane.getColumnIndex(circulo);
        if (event.getCode() == KeyCode.DOWN) {
            if (fila < miGridPane.getRowCount()-1) {
                fila++;
            }
        }
        if (event.getCode() == KeyCode.UP) {
            if (fila > 0) {
                fila--;
            }
        }
        if (event.getCode() == KeyCode.RIGHT) {
            if (columna < miGridPane.getColumnCount()-1) {
                columna++;
            }
        }
        if (event.getCode() == KeyCode.LEFT) {
            if (columna > 0) {
                columna--;
            }
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
        
        //así lo pone en los apuntes, para mi es correcto aunque de el aviso
        miGridPane.setRowIndex(circulo, fila);
        GridPane.setColumnIndex(circulo, columna); // así no da el aviso ¿?        
    }

}
