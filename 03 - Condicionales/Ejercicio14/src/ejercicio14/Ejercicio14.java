/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio14;

import java.util.Scanner;

/**
 *
 * @author ja.buenoseva
 */
public class Ejercicio14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a, b, c;
        Scanner teclado = new Scanner(System.in);

        a = 2;
        b = 2;
        c = 2;

        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("Forman un triangulo");
            if (a != b && b != c && a != c) {
                System.out.println("Es escaleno");
            } else if (a == b && b == c) {
                System.out.println("Es Equilatero");
            } else {
                System.out.println("Es isosceles");
            }
        } else {
            System.out.println("No forman un triangulo");
        }
    }

}
