/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros._ejercicio06_bounceball;

import java.util.Random;

import javafx.scene.paint.Color;

/**
 *
 * @author jabue
 */
public class BallPaneColor extends BallPane {

    private Color color;

    public BallPaneColor() {
        super();
        Random random = new Random();
        color = new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1.0);
        this.establecerColor(color);
    }

    @Override
    protected void moverBall() {
        // Comprobar límites
        Random random = new Random();
        if (getX() < radio || getX() > getWidth() - radio) {
            setDx(getDx() * -1); // Cambiar la dirección de movimiento de la pelota
            color = new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1.0);
            this.establecerColor(color);
        }
        if (getY() < radio || getY() > getHeight() - radio) {
            setDy(getDy() * -1); // Cambiar la dirección de movimiento de la pelota
            color = new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1.0);
            this.establecerColor(color);
        }

        // Adjust ball position
        setX(getX() + getDx());
        setY(getY() + getDy());
        getCircle().setCenterX(getX());
        getCircle().setCenterY(getY());

    }
}
