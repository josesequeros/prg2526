/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros._ejercicio_03_relojanalogico;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;

/**
 *
 * @author jabue
 */
public class RelojAnalogico extends Pane {

    private int hora;
    private int minutos;
    private int segundos;

    /**
     * Construir un reloj por defecto con la hora actual
     */
    public RelojAnalogico() {
        setCurrentTime();
    }

    /**
     * Construir un reloj con la hora, los minutos y los segundos especificados.d
     */
    public RelojAnalogico(int hour, int minutos, int segundos) {
        this.hora = hour;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    /**
     * Return hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * Set una nueva hora
     */
    public void setHora(int hora) {
        this.hora = hora;
        pintarReloj();
    }

    /**
     * Return minute
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * Set un nuevo minuto
     */
    public void setMinutos(int minutos) {
        this.minutos = minutos;
        pintarReloj();
    }

    /**
     * Return segundos
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * Establecer un nuevo segundo
     */
    public void setSegundos(int segundos) {
        this.segundos = segundos;
        pintarReloj();
    }

    /* Ajustar la hora actual del reloj */
    public void setCurrentTime() {
        // Construir un calendario para la fecha y hora actuales
        Calendar calendar = new GregorianCalendar();

        // Ajustar la hora, los minutos y los segundos actuales
        this.hora = calendar.get(Calendar.HOUR_OF_DAY);
        this.minutos = calendar.get(Calendar.MINUTE);
        this.segundos = calendar.get(Calendar.SECOND);

        pintarReloj(); // Repintar el reloj
    }

    /**
     * Pintar el reloj
     */
    private void pintarReloj() {
        // Inicializar los parámetros del reloj
        double radioReloj = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        // Dibujar circulo
        Circle circle = new Circle(centerX, centerY, radioReloj);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text t1 = new Text(centerX - 5, centerY - radioReloj + 12, "12");
        Text t2 = new Text(centerX - radioReloj + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + radioReloj - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + radioReloj - 3, "6");

        // radianes = grados × π/180
        // cada segundo son 360/60 = 6 grados
        // radianes = 360/60 × π/180 = 2 x π / 60   
        // siendo 60 la fracción de la circunferencia, una vuelta cada 60 segundos
        // en el minutero igual, una vuelta (360 grados) cada 60 minutos
        // en la hora, una vuelta cada 12 horas

        // Dibujar segundero
        double longitudSegundero = radioReloj * 0.8;
        double segundosX = centerX + longitudSegundero * Math.sin(segundos * (2 * Math.PI / 60));
        double segundosY = centerY - longitudSegundero * Math.cos(segundos * (2 * Math.PI / 60));
        Line segundosLinea = new Line(centerX, centerY, segundosX, segundosY);
        segundosLinea.setStroke(Color.RED);

        // Dibujar el minutero
        double longitudMinutero = radioReloj * 0.65;
        double minutosX = centerX + longitudMinutero * Math.sin(minutos * (2 * Math.PI / 60));
        double minutosY = centerY - longitudMinutero * Math.cos(minutos * (2 * Math.PI / 60));
        Line minutosLinea = new Line(centerX, centerY, minutosX, minutosY);
        minutosLinea.setStroke(Color.BLUE);

        // Dibujar aguja horaria
        double longitudHora = radioReloj * 0.5;
        double horaX = centerX + longitudHora * Math.sin((hora % 12 + minutos / 60.0) * (2 * Math.PI / 12));
        double horaY = centerY - longitudHora * Math.cos((hora % 12 + minutos / 60.0) * (2 * Math.PI / 12));
        Line horaLinea = new Line(centerX, centerY, horaX, horaY);
        horaLinea.setStroke(Color.GREEN);

        getChildren().clear();
        getChildren().addAll(circle, t1, t2, t3, t4, segundosLinea, minutosLinea, horaLinea);
        /*
        for (int i = 0; i < 12; i++) {
            double angulo = 2 * Math.PI * i / 12;  // Convertir a radianes
            double x = centerX + (radioReloj * 0.85) * Math.cos(angulo);
            double y = centerY + (radioReloj * 0.85) * Math.sin(angulo);

            Circle point = new Circle(x, y, 2, Color.BLUE);
            getChildren().add(point);
        }

        for (int i = 0; i < 60; i++) {
            double angulo = 2 * Math.PI * i / 60;  // Convertir a radianes
            double x = centerX + (radioReloj * 0.85) * Math.cos(angulo);
            double y = centerY + (radioReloj * 0.85) * Math.sin(angulo);
            Text punto = new Text(x, y, ".");
            getChildren().add(punto);
        }
        */
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        pintarReloj();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        pintarReloj();
    }
}
