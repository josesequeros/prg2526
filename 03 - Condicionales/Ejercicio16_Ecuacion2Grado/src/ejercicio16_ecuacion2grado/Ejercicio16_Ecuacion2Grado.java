/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio16_ecuacion2grado;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio16_Ecuacion2Grado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int a, b, c;
        double sol1, sol2;
        double discriminante;

        System.out.println("Introduzca el valor de a: ");
        a = teclado.nextInt();
        System.out.println("Introduzca el valor de b: ");
        b = teclado.nextInt();
        System.out.println("Introduzca el valor de c: ");
        c = teclado.nextInt();

        /*
        // Primera aproximación, no distinguimos casos, implementamos la fórmula directamente
        sol1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        sol2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        System.out.println("Las soluciones son: " + sol1 + " y " + sol2);
         */
        // Comprobamos el valor de a
        if (a == 0) {  // ya no tenemos una ecuación de 2º grado
            // Comprobamos el valor de b
            if (b == 0) { // ya no tenemos una ecuación de primer grado, sino una icualdad, c=0;
                // Comprobamos el valor de c
                if (c == 0) {
                    System.out.println("Tenemos infinitas soluciones");
                } else {
                    System.out.println("Imposible. Sin solucion");
                }
            } else {    // Tenemos una ecuacion de primer grado
                sol1 = (double) -c / b;
                System.out.println("Una solucion: " + sol1);
            }
        } else {
            discriminante = Math.sqrt(b * b - 4 * a * c);
            if (discriminante == 0) {
                sol1 = (double) -b / (2 * a);
                System.out.println("Una solucion: " + sol1);
            } else if (discriminante > 0) {
                sol1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                sol2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                System.out.println("Dos soluciones: " + sol1 + " y " + sol2);
            } else {
                System.out.println("Sin solucion real");
            }
        }
    }
}
