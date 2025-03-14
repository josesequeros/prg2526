/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testescribirdatostexto;

import java.io.FileNotFoundException;

/**
 *
 * @author jabue
 */
public class TestEscribirDatosTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        java.io.File file = new java.io.File("puntuaciones.txt");
        if (file.exists()) {
            System.out.println("El archivo ya existe");
            System.exit(0);
        }

        /* // Cierre Manual
        // Crear un archivo
        java.io.PrintWriter output = new java.io.PrintWriter(file);

        // Escribir la salida formateada en el archivo
        output.print("Carlos Gala ");
        output.println(50);
        output.print("Eva Planes ");
        output.println(800);

        // Cerrar el fichero
        output.close();
         */
        // cierre automático
        try ( // Crear un archivo
                java.io.PrintWriter output = new java.io.PrintWriter(file);) {
            // Escribir la salida formateada en el archivo
            output.print("Carlos Gala ");
            output.println(50);
            output.print("Eva Planes ");
            output.println(800);
            // no es necesario cerrarlo
            // Cerrar el fichero
            // output.close();
        }
    }

}
