/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio15_funciontrozos;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio15_FuncionTrozos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int x;
        double fx;

        System.out.println("Introduzca el valor de x: ");
        x = teclado.nextInt();

        if (x > 0) {
            fx = Math.pow(x, 3) - x * x + 6;
        } else if (x == 0) {
            fx = -5;
        } else {
            fx = Math.sqrt(Math.abs(Math.pow(x, 3) - x));
        }

        System.out.println("f(x) = " + fx);
    }

}
