package com.mycompany.buscaminas;

import java.util.ArrayList;

//Creamos clase partida, esta clase sirve más que nada para utilizarla luego para hacer el ranking de partidas.
//Al principio había extendido la clase Jugador, pero luego me di cuenta que si quería pasar el dato del nombre del jugador desde la ventana de inicio a la ventana de partida,
//no iba a poder hacerlo, así que creé una String nombreJugador a la que le asigno el nombre del jugador que se ha seleccionado en la ventana de inicio, 
//pero aquí no, en el primaryController.

public class Partida {
    private String nombreJugador;
    private int tiempoJuego;

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getTiempoJuego() {
        return tiempoJuego;
    }

    public void setTiempoJuego(int tiempoJuego) {
        this.tiempoJuego = tiempoJuego;
    }

    @Override
    public String toString() {
        return nombreJugador + " - " + tiempoJuego + " segundos";
    }
}
