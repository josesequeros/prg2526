/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros._ejercicio06_bounceball;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author jabue
 */
public class BallPane extends Pane{

    public final double radio = 20;
    private double x = radio, y = radio;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radio);
    private Timeline animacion;

    public BallPane() {
        circle.setFill(Color.GREEN); // Establecer el color de la bola
        getChildren().add(circle); // Coloque una bola en este panel

        // Crear una animación para mover la pelota
        animacion = new Timeline(
                new KeyFrame(Duration.millis(50), e -> moverBall()));
        animacion.setCycleCount(Timeline.INDEFINITE);
        animacion.play(); // Iniciar animación
    }

    public void play() {
        animacion.play();
    }

    public void pause() {
        animacion.pause();
    }

    public void aumentarVelocidad() {
        animacion.setRate(animacion.getRate() + 0.5);
    }

    public void disminuirVelocidad() {
        animacion.setRate(
                animacion.getRate() > 0 ? animacion.getRate() - 0.5 : 0);
    }

    protected void moverBall() {
        // Comprobar límites
        if (x < radio || x > getWidth() - radio) {
            dx *= -1; // Cambiar la dirección de movimiento de la pelota
        }
        if (y < radio || y > getHeight() - radio) {
            dy *= -1; // Cambiar la dirección de movimiento de la pelota
        }

        // Adjust ball position
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }   
}
