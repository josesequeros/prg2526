/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros._ejercicio_03_relojanalogicofxml;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class RelojAnalogicoController implements Initializable {

    private RelojAnalogico clock = new RelojAnalogico();
    private double radio = 90;
    private  double centerX = 0;
    private  double centerY = 0;

    @FXML
    private Line segundos;
    @FXML
    private Line hora;
    @FXML
    private Line minutos;
    @FXML
    private Pane pane;
    @FXML
    private Circle circulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Crear una animación que actualiza el reloj cada segundo
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> actualizarReloj()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        actualizarReloj(); // Para actualizar el reloj de inmediato
    }

    private void actualizarReloj() {

        clock.setCurrentTime();
        
        
        
        double anguloSegundero = clock.getSegundos() * 6; // Cada segundo = 6°
        double anguloMinutero = clock.getMinutos() * 6 + clock.getSegundos() * 0.1; // Cada minuto = 6°, cada segundo = 0.1°
        double anguloHora = clock.getHora() * 30 + clock.getMinutos() * 0.5; // Cada hora = 30°, cada minuto = 0.5°

        actualizarManilla(segundos, anguloSegundero, radio * 0.8);
        actualizarManilla(minutos, anguloMinutero, radio * 0.65);
        actualizarManilla(hora, anguloHora, radio * 0.5);
        
        //dibujarReloj();
    }
/*
    private void actualizarManilla(Line hand, double angle, double length) {
        double radianes = Math.toRadians(angle - 90); // Ajuste para iniciar en la posición correcta
        double endX = centerX + length * Math.cos(radianes);
        double endY = centerY + length * Math.sin(radianes);
        hand.setEndX(endX);
        hand.setEndY(endY);
    }
*/
    private void actualizarManilla(Line hand, double angle, double length) {
        double radianes = Math.toRadians(angle); // Ángulo en radianes
        double endX = centerX + length * Math.sin(radianes); // X = centro + sin(θ)
        double endY = centerY - length * Math.cos(radianes); // Y = centro - cos(θ)
        hand.setEndX(endX);
        hand.setEndY(endY);
    }
    
    private void dibujarReloj(){
        radio=0.8 * Math.min(pane.getWidth()/2,pane.getHeight()/2);
        circulo.setRadius(radio);
        circulo.setLayoutX(0/2);
        circulo.setLayoutY(0/2);
        hora.setLayoutX(0);
        hora.setLayoutY(0);
        minutos.setLayoutX(0);
        minutos.setLayoutY(0);
        segundos.setLayoutX(0);
        segundos.setLayoutY(0);
        centerX=Math.min(pane.getWidth()/2,pane.getHeight()/2);
        centerY=Math.min(pane.getWidth()/2,pane.getHeight()/2);
        circulo.setCenterX(pane.getWidth()/2);
        circulo.setCenterY(pane.getHeight()/2);
        hora.setStartX(circulo.getCenterX());
        hora.setStartY(circulo.getCenterY());
        minutos.setStartX(circulo.getCenterX());
        minutos.setStartY(circulo.getCenterY());
        segundos.setStartX(circulo.getCenterX());
        segundos.setStartY(circulo.getCenterY());
    }

}
