/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros._ejercicio_03_relojanalogicofxml;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;

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
    }

    /* Ajustar la hora actual del reloj */
    public void setCurrentTime() {
        // Construir un calendario para la fecha y hora actuales
        LocalTime now = LocalTime.now();
        // Ajustar la hora, los minutos y los segundos actuales
        this.hora = now.getHour() % 12;  // 12 horas
        this.minutos = now.getMinute();
        this.segundos = now.getSecond();

    }

}
