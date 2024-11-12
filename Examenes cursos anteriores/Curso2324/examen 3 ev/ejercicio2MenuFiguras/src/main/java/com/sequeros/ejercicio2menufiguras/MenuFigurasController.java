/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.ejercicio2menufiguras;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class MenuFigurasController implements Initializable {

    @FXML
    private Button botonCuadrado;
    @FXML
    private Button botonElipse;
    @FXML
    private Button botonCirculo;
    @FXML
    private Circle circulo;
    @FXML
    private Ellipse elipse;
    @FXML
    private Rectangle cuadrado;
    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem miCuadrado;
    @FXML
    private MenuItem miElipse;
    @FXML
    private MenuItem miCirculo;
    @FXML
    private Button botonSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cuadrado.setVisible(false);
        elipse.setVisible(false);
        circulo.setVisible(false);
        botonCuadrado.setOnAction(eh -> dibujar(eh));
        botonElipse.setOnAction(eh -> dibujar(eh));
        botonCirculo.setOnAction(eh -> dibujar(eh));
        botonSalir.setOnAction(e -> Platform.exit());
        exit.setOnAction(e -> Platform.exit());
        miCuadrado.setOnAction(e -> draw("cuadrado"));
        miElipse.setOnAction(e -> draw("elipse"));
        miCirculo.setOnAction(e -> draw("circulo"));

    }

    private void dibujar(ActionEvent eh) {
        Button boton = (Button) eh.getSource();
        String id = boton.getId();
        switch (id) {
            case "botonCuadrado":
                cuadrado.setVisible(true);
                elipse.setVisible(false);
                circulo.setVisible(false);
                break;
            case "botonElipse":
                cuadrado.setVisible(false);
                elipse.setVisible(true);
                circulo.setVisible(false);
                break;
            case "botonCirculo":
                cuadrado.setVisible(false);
                elipse.setVisible(false);
                circulo.setVisible(true);
                break;
            default:
                break;
        }
    }

    private void draw(String id) {
        switch (id) {
            case "cuadrado":
                cuadrado.setVisible(true);
                elipse.setVisible(false);
                circulo.setVisible(false);
                break;
            case "elipse":
                cuadrado.setVisible(false);
                elipse.setVisible(true);
                circulo.setVisible(false);
                break;
            case "circulo":
                cuadrado.setVisible(false);
                elipse.setVisible(false);
                circulo.setVisible(true);
                break;
            default:
                break;
        }
    }

}
