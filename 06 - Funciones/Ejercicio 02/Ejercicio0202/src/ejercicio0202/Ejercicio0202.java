/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0202;

import java.util.Scanner;

/**
 *
 * @author ja.buenoseva
 */
public class Ejercicio0202 {

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
            if (esPrimo(i)) {
                total++;
            }
        }
        System.out.println("Hay: " + total + " numeros primos entre " + yearInicial + " y " + yearFinal);
    }

    public static boolean esPrimo1(int numero) {
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean esPrimo2(int numero) {
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }    
    
    public static boolean esPrimo(int numero) {
        int divisor;
        boolean puedeSerlo;
        if (numero == 2) {
            return true;
        } else if (numero % 2 == 0) {
            return false;           // <n> no es primo
        } else {                      // Se buscan posibles divisores impares de <n>
            puedeSerlo = true;      // <n> es candidato a primo
            divisor = 3;            // primer divisor a probar
            while (puedeSerlo && divisor * divisor <= numero) {     // menor que la raíz cuadrada 
                puedeSerlo = numero % divisor > 0;                  // ¿ aún sin divisores?
                divisor = divisor + 2; 			                    // sig. divisor a probar
            }
            return puedeSerlo;
        }
    }

}
