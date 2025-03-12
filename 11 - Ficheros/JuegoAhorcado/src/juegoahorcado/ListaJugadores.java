/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoahorcado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class ListaJugadores {

    private ArrayList<Jugador> listaJugadores;

    public ListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public ListaJugadores(String archivo) {
        this.listaJugadores = leerJugadores(archivo);
    }

    public ArrayList<Jugador> leerJugadores(String archivo) {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        try {
            // Intentamos abrir el fichero
            File f = new File(archivo);
            Scanner lector = new Scanner(f);
            // Si llega aquí es que ha abierto el fichero :)
            while (lector.hasNext()) {
                String linea = lector.nextLine();
                String[] datosJugador = linea.split(";");
                String nombre = datosJugador[0];
                int ganadas = Integer.parseInt(datosJugador[1]);
                int perdidas = Integer.parseInt(datosJugador[2]);
                int puntos = Integer.parseInt(datosJugador[3]);
                listaJugadores.add(new Jugador(nombre, ganadas, perdidas, puntos));
            }
            // ¡Hay que cerrar el fichero!
            lector.close();

        } catch (FileNotFoundException e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return listaJugadores;
    }

    /**
     * Muestra un listado de jugadores
     */
    public void mostrarJugadores() {
        System.out.println("Listado de Jugadores: ");
        if (this.getListaJugadores().isEmpty()) {
            System.out.println("Lista de jugadores vacia");
        } else {
            for (Jugador jugador : this.getListaJugadores()) {
                System.out.println(jugador);
            }
        }
    }

    public Jugador buscarJugador(String nombre) {
        Jugador aux = null;
        for (Jugador jugador : getListaJugadores()) {
            if (nombre.equals(jugador.getNombre())) {
                aux = jugador;
            }
        }
        if (aux == null) {
            aux = new Jugador(nombre);
            this.getListaJugadores().add(aux);
        }
        return aux;
    }

    public void ranking() {
        ArrayList<Jugador> aux = new ArrayList<>();
        for (Jugador jugador : listaJugadores) {
            aux.add(jugador);
        }
        Collections.sort(aux, Comparator.comparing(Jugador::getTotalPuntos).reversed());
        //mostrarJugadores();
        System.out.println("\nRanking de Jugadores");
        for (Jugador jugador : aux) {
            System.out.println("\tNombre Jugador: " + jugador.getNombre()
                    + "\tPuntuacion: " + jugador.getTotalPuntos());
        }
    }

    /**
     * @return the listaJugadores
     */
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    /**
     * @param listaJugadores the listaJugadores to set
     */
    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public void escribirJugadores(String archivo) {
        try {
            File f = new File(archivo);
            FileWriter fw = new FileWriter(f);

            for (Jugador jugador : listaJugadores) {
                fw.write(jugador.getNombre() + ";");
                fw.write(jugador.getPartidasGanadas() + ";");
                fw.write(jugador.getPartidasPerdidas() + ";");
                fw.write(jugador.getTotalPuntos() + "\n");
            }
            fw.close(); // cerramos el FileWriter
            System.out.println("Fichero escrito correctamente");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
