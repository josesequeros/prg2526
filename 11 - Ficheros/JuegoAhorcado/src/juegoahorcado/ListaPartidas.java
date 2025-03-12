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
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class ListaPartidas {

    private ArrayList<Partida> listaPartidas;

    public ListaPartidas(ArrayList<Partida> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }

    public ListaPartidas(String archivo) {
        this.listaPartidas = leerPartidas(archivo);
    }

    public ArrayList<Partida> leerPartidas(String archivo) {
        ArrayList<Partida> listaPartidas = new ArrayList<>();
        try {
            // Intentamos abrir el fichero
            File f = new File(archivo);
            Scanner lector = new Scanner(f);
            // Si llega aquí es que ha abierto el fichero :)
            while (lector.hasNext()) {
                String linea = lector.nextLine();
                String[] datosPartida = linea.split(";");
                int numeroPartida = Integer.parseInt(datosPartida[0]);
                String jugadorPonePalabra = datosPartida[1];
                String jugadorAdivinaPalabra = datosPartida[2];
                String palabra = datosPartida[3];
                int puntos = Integer.parseInt(datosPartida[4]);
                String jugadorGanador = datosPartida[5];
                listaPartidas.add(new Partida(numeroPartida, jugadorAdivinaPalabra, jugadorPonePalabra, palabra, puntos, jugadorGanador));
            }
            // ¡Hay que cerrar el fichero!
            lector.close();
        } catch (FileNotFoundException e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return listaPartidas;
    }

    /**
     * Muestra un listado de partidas
     */
    public void mostrarPartidas() {
        System.out.println("Listado de Partidas: ");
        if (this.getListaPartidas().size() == 0) {
            System.out.println("Lista de partidas vacia");
        } else {
            for (Partida partida : this.getListaPartidas()) {
                System.out.println(partida);
            }
        }
    }

    /**
     * @return the listaPartidas
     */
    public ArrayList<Partida> getListaPartidas() {
        return listaPartidas;
    }

    /**
     * @param listaPartidas the listaPartidas to set
     */
    public void setListaPartidas(ArrayList<Partida> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }
    
    public void escribirPartidas(String archivo) {
        try {
            File f = new File(archivo);
            FileWriter fw = new FileWriter(f);

            for (Partida partida : listaPartidas) {
                fw.write(partida.getNumeroPartida() + ";");
                fw.write(partida.getJugadorElige()+ ";");
                fw.write(partida.getJugadorAdivina() + ";");
                fw.write(partida.getObjetivo() + ";");
                fw.write(partida.getPuntos() + ";");
                fw.write(partida.getJugadorGanador() + "\n");
            }
            fw.close(); // cerramos el FileWriter
            System.out.println("Fichero escrito correctamente");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
