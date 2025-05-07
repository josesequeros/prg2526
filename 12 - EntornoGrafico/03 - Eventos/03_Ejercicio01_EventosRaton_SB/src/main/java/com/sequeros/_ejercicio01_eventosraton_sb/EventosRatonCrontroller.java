package com.sequeros._ejercicio01_eventosraton_sb;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class EventosRatonCrontroller implements Initializable {

    @FXML
    private Text texto;
    private double offsetX;
    private double offsetY;

    private boolean arrastrandoMostrado = false;

    @FXML
    private void dragDetectado(MouseEvent event) {
        /*
        double newX = event.getSceneX() + offsetX;
        double newY = event.getSceneY() + offsetY;
        //Coordenadas relativas al contenedor
        texto.setLayoutX(newX);
        texto.setLayoutY(newY);
        System.out.println(texto.getLayoutX() + " - " + texto.getLayoutY());

        // Coordenadas relativas al origen de coordenadas
        //texto.setX(event.getX());
        //texto.setY(event.getY());
        //texto.setX(newX);
        //texto.setY(newY);
         */
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        texto.setOnMouseDragged(e -> {
            double newX = e.getSceneX() + offsetX;
            double newY = e.getSceneY() + offsetY;
            //Coordenadas relativas al contenedor
            texto.setLayoutX(newX);
            texto.setLayoutY(newY);
            if (!arrastrandoMostrado) {
                System.out.println("Arrastrando");
            }
            arrastrandoMostrado = true;
        });

        texto.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                System.out.println("Primario");
            } else if (e.getButton() == MouseButton.SECONDARY) {
                System.out.println("Secundario");
            }
            if (e.getClickCount() == 2) {
                System.out.println("Doble clic");
            }
            arrastrandoMostrado = false;
        });

        texto.setOnMousePressed(e -> {
            offsetX = texto.getLayoutX() - e.getSceneX();
            offsetY = texto.getLayoutY() - e.getSceneY();
        });
    }

    @FXML
    private void handleMousePressed(MouseEvent event) {
        //offsetX = texto.getLayoutX() - event.getSceneX();
        //offsetY = texto.getLayoutY() - event.getSceneY();
    }

}
