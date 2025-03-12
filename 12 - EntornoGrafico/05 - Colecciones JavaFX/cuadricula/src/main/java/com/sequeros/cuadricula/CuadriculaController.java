/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.cuadricula;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class CuadriculaController implements Initializable {

    @FXML
    private Pane pane;

    private int size = 200;
    private int spots = 25;
    private int lado;// = size / spots;
    private ArrayList<Figura> figuras;
    private Rectangle[][] cuadricula;
    private Boolean[][] ocupadas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int tam = (int) (Math.round(Math.sqrt((spots * 4)) / 5)) * 5;
        System.out.println("Tamaño: " + tam);
        //pane.setPrefSize(spots * 40, spots * 40);
        pane.setPrefSize(tam * 40, tam * 40);
        //size = spots * 40;
        size = tam * 40;
        //lado = size / spots;
        lado = size / tam;
        //pane.setLayoutY(spots * 40);
        //cuadricula = new Rectangle[spots][spots];
        //ocupadas = new Boolean[spots][spots];
        cuadricula = new Rectangle[tam][tam];
        ocupadas = new Boolean[tam][tam];
        for (int i = 0; i < size; i += lado) {
            for (int j = 0; j < size; j += lado) {
                Rectangle r = new Rectangle(i, j, lado, lado);
                cuadricula[i / lado][j / lado] = r;
                ocupadas[i / lado][j / lado] = false;
                r.setFill(Color.WHITE);
                r.setStroke(Color.BLACK);
                pane.getChildren().add(r);
            }
        }
        figuras = new ArrayList<Figura>();
        for (int i = 0; i < spots; i++) {
            int x, y, px, py;
            Circle c = new Circle();
            c.setFill(Color.GREEN);
            c.setStroke(Color.BLACK);
            double radius = lado / 3.0;
            do {
                //x = lado / 2 + lado * (int) (Math.random() * spots);
                //y = lado / 2 + lado * (int) (Math.random() * spots);
                                x = lado / 2 + lado * (int) (Math.random() * tam);
                y = lado / 2 + lado * (int) (Math.random() * tam);
                px = x / 40;
                py = y / 40;
            } while (ocupadas[px][py]);
            ocupadas[px][py] = true;
            Figura p = new Figura(x, y, radius, c);
            figuras.add(p);

            c.setOnMousePressed(event -> pressed(event, p));
            c.setOnMouseDragged(event -> dragged(event, p));
            c.setOnMouseReleased(event -> released(event, p));

            pane.getChildren().add(c);
            p.draw();
        }
    }

    private void pressed(MouseEvent event, Figura p) {
        p.setColor(Color.CORAL);
    }

    private void dragged(MouseEvent event, Figura p) {
        if (p.getX() >= 0) {
            p.setX(p.getX() + event.getX());
        }
        else {
            p.setX(0);
        }
        p.setY(p.getY() + event.getY());
        p.draw();
    }

    private void released(MouseEvent event, Figura p) {
        p.setColor(Color.GREEN);
        int gridx = (int) p.getX() / lado;
        int gridy = (int) p.getY() / lado;
        //cuadricula[gridx][gridy].setFill(Color.CRIMSON);
        p.setX(lado / 2 + lado * gridx);
        p.setY(lado / 2 + lado * gridy);
        p.draw();

    }

}
