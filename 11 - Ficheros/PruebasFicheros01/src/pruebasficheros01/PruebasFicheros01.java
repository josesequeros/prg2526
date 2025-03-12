/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasficheros01;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class PruebasFicheros01 {

    public static final int NUM_VALORES = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here       
        try {
            // Intentamos abrir el fichero
            File f = new File("Enteros.txt");
            Scanner lector = new Scanner(f);

            // Si llega aquí es que ha abierto el fichero :)
            for (int i = 0; i < NUM_VALORES; i++) {
                int valor = lector.nextInt();
                System.out.println("El valor leido es: " + valor);
            }

            // ¡Hay que cerrar el fichero!
            lector.close();

        } catch (Exception e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

}
