/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio02_contenidodirectorioysubdirectorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio02_ContenidoDirectorioYSubdirectorios {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File origen = new File("./");
        int nivel = 0;
        mostrarArchivos(origen, nivel);
        System.out.println("");
        origen = new File("directorio");
        reemplazarEnDirectorio(origen);
    }

    private static void mostrarArchivos(File origen, int nivel) {
        if (origen.isDirectory()) {
            for (int i = 0; i < nivel; i++) {
                System.out.print("\t");
            }
            System.out.println("Directorio: " + origen.getName());
            String[] lista = origen.list();
            for (String nombre : lista) {
                File ruta = new File(origen, nombre);
                mostrarArchivos(ruta, nivel + 1);
            }
        } else {
            for (int i = 0; i < nivel + 1; i++) {
                System.out.print("\t");
            }
            System.out.println("[ A ]: " + origen.getName());
        }
    }

    public static void reemplazarEnDirectorio(File directorio) throws FileNotFoundException {

        String oldStr = "en";
        String newStr = "EN";

        if (directorio.isDirectory()) {
            System.out.println("Directorio: " + directorio.getName());
            String[] lista = directorio.list();
            for (String nombre : lista) {
                File ruta = new File(directorio.getName() + "/" + nombre);
                if (ruta.isFile()) {
                    System.out.println("[ A ]: " + ruta.getName() + " --> Reemplazando texto");
                    File sourceFile = ruta;
                    File targetFile = new File(directorio.getName() + "/" + ruta.getName() + ".bak");
                    try (
                            // Crear archivos de entrada y salida
                            Scanner input = new Scanner(sourceFile); PrintWriter output = new PrintWriter(targetFile);) {
                        while (input.hasNext()) {
                            String s1 = input.nextLine();
                            String s2 = s1.replaceAll(oldStr, newStr);
                            output.println(s2);
                        }
                    }
                }
            }
        }
    }
}
