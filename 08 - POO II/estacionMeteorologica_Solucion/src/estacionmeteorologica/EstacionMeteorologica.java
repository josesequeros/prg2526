/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionmeteorologica;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class EstacionMeteorologica {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        // A COMPLETAR POR EL ALUMNO ...
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre de fichero: ");
        String nombreFichero = teclado.nextLine().trim();

        GestorMeteo gestorMeteo = new GestorMeteo(nombreFichero);

        Momento momento = gestorMeteo.mayorTemp();
        if (momento != null) {
            System.out.println("Mes, dia y hora: " + momento);
        } else {
            System.out.println("No existen medidas");
        }

        System.out.println("\nArray Leído");
        for (int i = 0; i < gestorMeteo.getMedidasArray().length; i++) {
            if (gestorMeteo.getMedidasArray()[i] != null) {
                System.out.println(gestorMeteo.getMedidasArray()[i]);
            }
        }
        
        gestorMeteo.ordenarPorMomento();
        
        System.out.println("\nArray Ordenado");
        for (int i = 0; i < gestorMeteo.getMedidasArray().length; i++) {
            if (gestorMeteo.getMedidasArray()[i] != null) {
                System.out.println(gestorMeteo.getMedidasArray()[i]);
            }
        }

    }
}
