/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica_01_07_bisiesto;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Practica_01_07_Bisiesto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int anyo;
        boolean esABisiesto;

        System.out.print("Introduce el año: ");
        anyo = entrada.nextInt();
        
        esABisiesto = anyo % 4 == 0 && anyo % 100 != 0 || anyo % 400 == 0;
        
        if (esABisiesto) {
            System.out.println(anyo + " Es bisiesto.");
        } else {
            System.out.println(anyo + " No es bisiesto.");
        }
    }

}
