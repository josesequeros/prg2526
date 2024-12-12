/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema06funcionesejerciciosadicionales01;

import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class Ejercicio03 {

    public static boolean esPrimo(int numero) {
        int divisor;
        boolean puedeSerlo;
        if (numero == 1 || numero == 2) {
            return true;
        } else if (numero < 2 || numero % 2 == 0) {
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

    public static void main(String[] args) {
        int tope = 100000;
        int n, maximo = 0, minimo = tope;
        
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        n = entrada.nextInt();
        for (int i = 0; i < n; i++) {
            int numero = (int) (Math.random() * tope + 1);
            System.out.println(numero);
            if (esPrimo(numero)) {
                if (numero > maximo) {
                    maximo = numero;
                }
                if (numero < minimo) {
                    minimo = numero;
                }
            }
        }
        if (maximo > 0) {
            System.out.println("el menor primo es : " + minimo);
            System.out.println("el mayor primo es : " + maximo);
        }
        else
            System.out.println("No se ha generado nungún número primo");
    }

}
