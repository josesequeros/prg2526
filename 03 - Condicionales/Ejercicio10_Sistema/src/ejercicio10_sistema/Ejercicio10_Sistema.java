/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio10_sistema;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio10_Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int a, b, c, d, e, f;
        int x, y;

        System.out.println("Introduzca el valor de a: ");
        a = teclado.nextInt();
        System.out.println("Introduzca el valor de b: ");
        b = teclado.nextInt();
        System.out.println("Introduzca el valor de c: ");
        c = teclado.nextInt();
        System.out.println("Introduzca el valor de d: ");
        d = teclado.nextInt();
        System.out.println("Introduzca el valor de e: ");
        e = teclado.nextInt();
        System.out.println("Introduzca el valor de f: ");
        f = teclado.nextInt();
        if (a * e - b * d == 0) {
            System.out.println("ae-bd no puede ser 0");
        } else {
            x = (c * e - b * f) / (a * e - b * d);
            y = (a * f - c * d) / (a * e - b * d);
            System.out.println("Las soluciones son: x = " + x + " | y = " + y);
        }
    }
}
