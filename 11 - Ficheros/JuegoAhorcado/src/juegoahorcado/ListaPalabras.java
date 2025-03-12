/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoahorcado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author jabue
 */
public class ListaPalabras {

    private ArrayList<String> listaPalabras;

    public ListaPalabras(ArrayList<String> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    public ListaPalabras(String archivo) {
        this.listaPalabras = leerPalabras(archivo);
    }

    
    
    /**
     * Dado un archivo de palabras devuelve una lista con esas palabras
     *
     * @param archivo Pasamos el path del archivo
     * @return
     */
    public static ArrayList<String> leerPalabras(String archivo) {
        ArrayList<String> listaPalabras = new ArrayList<>();
        File f = new File(archivo);
        try {
            // Intentamos abrir el fichero
            Scanner lector = new Scanner(f);
            // Si llega aquí es que ha abierto el fichero :)
            while (lector.hasNext()) {
                String palabra = lector.nextLine();
                listaPalabras.add(palabra);
            }
            // ¡Hay que cerrar el fichero!
            lector.close();

        } catch (FileNotFoundException e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            try {
                //e.printStackTrace();
                if (f.createNewFile()) {
                    System.out.println("Archivo creado: " + f.getName());
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return listaPalabras;
    }

    public ArrayList<String> leerPalabras2(String archivo) {
        ArrayList<String> listaPalabras = new ArrayList<>();
        try {
            // Intentamos abrir el fichero
            File f = new File(archivo);
            // Si llega aquí es que ha abierto el fichero :)
            try (Scanner lector = new Scanner(f)) { // Aquí no hay que cerrar el fichero
                // Si llega aquí es que ha abierto el fichero :)
                while (lector.hasNext()) {
                    String palabra = lector.nextLine();
                    listaPalabras.add(palabra);
                }
                // ¡No hay que cerrar el fichero!
            }
        } catch (FileNotFoundException e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return listaPalabras;
    }

    public String obtenerObjetivo() {
        String objetivo = "";
        int posicion;
        do {
            posicion = (int) (Math.random() * getListaPalabras().size());
            objetivo = getListaPalabras().get(posicion);
        } while (objetivo.length() < 4);
        return normalizar(objetivo);
    }

    public String normalizar(String palabraSeleccionada) {
        //palabraSeleccionada = "cafémañana";
        palabraSeleccionada = palabraSeleccionada.replace("ñ", "~");
        palabraSeleccionada = Normalizer.normalize(palabraSeleccionada, Normalizer.Form.NFD);
        //palabraSeleccionada = palabraSeleccionada.replaceAll("[\u0300-\u0301]", "");
        palabraSeleccionada = palabraSeleccionada.replaceAll("[\\p{InCombiningDiacriticalMarks}&&[^ñ]]", "");
        palabraSeleccionada = palabraSeleccionada.replace("~", "ñ");
        return palabraSeleccionada;
    }

    /**
     * @return the listaPalabras
     */
    public ArrayList<String> getListaPalabras() {
        return listaPalabras;
    }

    /**
     * @param listaPalabras the listaPalabras to set
     */
    public void setListaPalabras(ArrayList<String> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }
}
