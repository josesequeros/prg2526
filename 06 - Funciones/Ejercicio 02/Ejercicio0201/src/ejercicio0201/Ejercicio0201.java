/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0201;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio0201 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca año inicial: ");
        int yearInicial = teclado.nextInt();
        System.out.print("Introduzca año final: ");
        int yearFinal = teclado.nextInt();
        int total = 0;
        for (int i = yearInicial; i <= yearFinal; i++) {
            if (esBisiesto(i)) {
                total++;
            }
        }
        System.out.println("Hay: " + total + " Años Bisiestos entre " + yearInicial + " y " + yearFinal);

    }

    public static boolean esBisiesto(int anio) {
        return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0;
    }

}
