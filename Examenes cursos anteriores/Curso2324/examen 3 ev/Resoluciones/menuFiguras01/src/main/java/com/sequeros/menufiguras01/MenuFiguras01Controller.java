/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.menufiguras01;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class MenuFiguras01Controller implements Initializable {

    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem miCuadrado;
    @FXML
    private MenuItem miElipse;
    @FXML
    private MenuItem miCirculo;
    @FXML
    private Button botonCuadrado;
    @FXML
    private Button botonElipse;
    @FXML
    private Button botonCirculo;
    @FXML
    private Button botonSalir;
    @FXML
    private StackPane stackPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        botonCirculo.setOnAction(e -> draw("circulo"));
        botonElipse.setOnAction(e -> draw("elipse"));
        botonCuadrado.setOnAction(e -> draw("cuadrado"));
        miCirculo.setOnAction(botonCirculo.getOnAction());
        miElipse.setOnAction(botonElipse.getOnAction());
        miCuadrado.setOnAction(botonCuadrado.getOnAction());
        botonSalir.setOnAction(e -> Platform.exit());
        exit.setOnAction(botonSalir.getOnAction());
        // Tooltips
        botonCuadrado.setTooltip(new Tooltip("Dibujar un Rectángulo"));
        botonCirculo.setTooltip(new Tooltip("Dibujar un Círculo"));
        botonElipse.setTooltip(new Tooltip("Dibujar una Elipse"));
        botonSalir.setTooltip(new Tooltip("Salir de la Aplicación"));
    }

    private void draw(String id) {
        stackPane.getChildren().clear();
        switch (id) {
            case "cuadrado":
                Rectangle rectangle = new Rectangle(100, 100);
                rectangle.setFill(Color.BLUE);
                stackPane.getChildren().add(rectangle);
                //stackPane.getChildren().add(new Rectangle(100, 100));
                break;
            case "elipse":
                stackPane.getChildren().add(new Ellipse(50, 40));
                break;
            case "circulo":
                stackPane.getChildren().add(new Circle(50));
                break;
            default:
                break;
        }
    }

}
