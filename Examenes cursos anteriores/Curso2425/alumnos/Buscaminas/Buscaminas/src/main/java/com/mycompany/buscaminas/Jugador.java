package com.mycompany.buscaminas;

import java.util.ArrayList;

//Clase Jugador. 
//Cada jugador tiene asignado un nombre y una imagen como pedía la práctica.
public class Jugador {
    private String nombre;
    private String imgpath;
    public static ArrayList<Jugador> jugadores = new ArrayList<>();

    public void jugador(String nombre) {
        this.nombre = nombre;
        Jugador.jugadores.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
