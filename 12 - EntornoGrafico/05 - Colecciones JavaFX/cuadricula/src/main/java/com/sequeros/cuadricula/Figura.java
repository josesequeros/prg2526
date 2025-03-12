/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.cuadricula;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author jabue
 */
public class Figura {

    private double x;
    private double y;
    private double radio;
    private Circle circulo;

    public Figura(double x, double y, double radio, Circle circulo) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.circulo = circulo;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setColor(Color color) {
        circulo.setFill(color);
    }

    public void draw() {
        circulo.setRadius(radio);
        circulo.setTranslateX(x);
        circulo.setTranslateY(y);
    }
}
