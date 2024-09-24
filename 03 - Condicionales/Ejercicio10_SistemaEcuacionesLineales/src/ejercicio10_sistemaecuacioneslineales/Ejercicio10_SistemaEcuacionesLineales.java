/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio10_sistemaecuacioneslineales;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio10_SistemaEcuacionesLineales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double a, b, c, d, e, f;
        double x, y;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Sistema Lineal formado por las dos ecuaciones siguientes");
        System.out.println("ax+by=c");
        System.out.println("dx+ey=f");
/*
        System.out.print("Introduzca el valor de a: ");
        a = teclado.nextDouble();
        System.out.print("Introduzca el valor de b: ");
        b = teclado.nextDouble();
        System.out.print("Introduzca el valor de c: ");
        c = teclado.nextDouble();
        System.out.print("Introduzca el valor de d: ");
        d = teclado.nextDouble();
        System.out.print("Introduzca el valor de e: ");
        e = teclado.nextDouble();
        System.out.print("Introduzca el valor de f: ");
        f = teclado.nextDouble();
*/
        a=2; b=2; c=3; d=4; e=5; f=8;
        if (a * e - b * d == 0) {
            System.out.println("Error, division por 0");
        } else {
            x = (c * e - b * f) / (a * e - b * d);
            y = (a * f - c * d) / (a * e - b * d);

            System.out.println("Soluciones:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }

    }

}
