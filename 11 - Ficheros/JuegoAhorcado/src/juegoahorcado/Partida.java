/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoahorcado;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Partida {
    private int numeroPartida;
    private String jugadorAdivina;
    private String jugadorElige;
    private String objetivo;
    private int puntos;
    private String jugadorGanador;

    public Partida(int numeroPartida, String jugadorAdivina, String jugadorElige, String objetivo, String jugadorGanador) {
        this.numeroPartida = numeroPartida;
        this.jugadorAdivina = jugadorAdivina;
        this.jugadorElige = jugadorElige;
        this.objetivo = objetivo;
        this.puntos = 0;
        this.jugadorGanador = jugadorGanador;
    }

    public Partida(int numeroPartida, String jugadorAdivina, String jugadorElige, String objetivo, int puntos, String jugadorGanador) {
        this.numeroPartida = numeroPartida;
        this.jugadorAdivina = jugadorAdivina;
        this.jugadorElige = jugadorElige;
        this.objetivo = objetivo;
        this.puntos = puntos;
        this.jugadorGanador = jugadorGanador;
    }
    
    

    /**
     * @return the numeroPartida
     */
    public int getNumeroPartida() {
        return numeroPartida;
    }

    /**
     * @param numeroPartida the numeroPartida to set
     */
    public void setNumeroPartida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    /**
     * @return the jugadorAdivina
     */
    public String getJugadorAdivina() {
        return jugadorAdivina;
    }

    /**
     * @param jugadorAdivina the jugadorAdivina to set
     */
    public void setJugadorAdivina(String jugadorAdivina) {
        this.jugadorAdivina = jugadorAdivina;
    }

    /**
     * @return the jugadorElige
     */
    public String getJugadorElige() {
        return jugadorElige;
    }

    /**
     * @param jugadorElige the jugadorElige to set
     */
    public void setJugadorElige(String jugadorElige) {
        this.jugadorElige = jugadorElige;
    }

    /**
     * @return the objetivo
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * @param objetivo the objetivo to set
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the jugadorGanador
     */
    public String getJugadorGanador() {
        return jugadorGanador;
    }

    /**
     * @param jugadorGanador the jugadorGanador to set
     */
    public void setJugadorGanador(String jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    @Override
    public String toString() {
        return "Partida{" + "numeroPartida=" + numeroPartida + ", jugadorAdivina=" + jugadorAdivina + ", jugadorElige=" + jugadorElige + ", objetivo=" + objetivo + ", puntos=" + puntos + ", jugadorGanador=" + jugadorGanador + '}';
    }

}
