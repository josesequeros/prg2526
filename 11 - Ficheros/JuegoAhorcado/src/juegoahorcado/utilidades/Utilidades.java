/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoahorcado.utilidades;

import java.io.File;

/**
 *
 * @author jabue
 */
public class Utilidades {

    public static void mostrarArchivosEnDirectorio(String directorio) {
        File origen = new File(directorio);
        if (origen.isDirectory()) {
            System.out.println("Directorio: " + origen.getName());
            String[] lista = origen.list();
            for (String nombre : lista) {
                File ruta = new File(origen, nombre);
                System.out.println("[ A ]: " + ruta.getName());
            }
        }
    }
}
