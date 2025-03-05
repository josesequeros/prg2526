/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sieteymedia;

import java.util.ArrayList;

/**
 *
 * @author jabue
 */
public class Juego {
    private ArrayList jugadores;
    private int apuesta;
    private Jugador banca;

    public Juego(ArrayList jugadores, int apuesta, Jugador banca) {
        this.jugadores = jugadores;
        this.apuesta = apuesta;
        this.banca = banca;
    }

    public ArrayList getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList jugadores) {
        this.jugadores = jugadores;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public Jugador getBanca() {
        return banca;
    }

    public void setBanca(Jugador banca) {
        this.banca = banca;
    }
    
    
}
