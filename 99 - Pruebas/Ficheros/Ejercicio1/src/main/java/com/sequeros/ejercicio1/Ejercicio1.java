/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sequeros.ejercicio1;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        File origen = new File("../");
        mostrarArchivosporA(origen);
    }

    private static void mostrarArchivos(File origen) {
        if (origen.isDirectory()) {
            System.out.println("Directorio: ");
            System.out.println("\t" + origen.getName());
            String[] lista = origen.list();
            for (String nombre : lista) {
                File ruta = new File(origen, nombre);
                mostrarArchivos(ruta);
            }
        } else {
            System.out.println("\tArchivo: ");
            System.out.println("\t\t    " + origen.getName());
        }
    }

    private static void mostrarArchivosporA(File origen) {
        if (origen.isDirectory()) {
            String[] lista = origen.list();
            for (String nombre : lista) {
                //System.out.println(nombre);
                if (nombre.startsWith("A")) {
                    //System.out.println(nombre);
                    File ruta = new File(origen, nombre);
                    System.out.println(ruta.getAbsoluteFile());
                }
            }
        } else {
            System.out.println("No existe el directorio");
        }
    }
}
