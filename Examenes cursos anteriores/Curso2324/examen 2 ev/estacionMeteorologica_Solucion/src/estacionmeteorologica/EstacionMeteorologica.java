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
        Scanner tcl = new Scanner(System.in);

        System.out.print("Nombre de fichero: ");
        String nF = tcl.nextLine().trim();

        GestorMeteo gM = new GestorMeteo(nF);

        Momento m = gM.mayorTemp();
        if (m != null) {
            System.out.println("Mes, dia y hora: " + m);
        } else {
            System.out.println("No existen medidas");
        }

        System.out.println("\nArray Leído");
        for (int i = 0; i < gM.getElArray().length; i++) {
            if (gM.getElArray()[i] != null) {
                System.out.println(gM.getElArray()[i]);
            }
        }
        
        gM.ordenarPorMomento();
        
        System.out.println("\nArray Ordenado");
        for (int i = 0; i < gM.getElArray().length; i++) {
            if (gM.getElArray()[i] != null) {
                System.out.println(gM.getElArray()[i]);
            }
        }

    }
}
