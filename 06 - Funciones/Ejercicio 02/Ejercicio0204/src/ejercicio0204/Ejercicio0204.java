/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0204;

/**
 *
 * @author ja.buenoseva
 */
public class Ejercicio0204 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int matriz[][];
        int dimension = 5;
        int valorInferior = 1;
        int valorSuperior = 100;
        matriz = crearMatriz(dimension, valorInferior, valorSuperior);
        imprimirMatriz(matriz);
        primosPorFila(matriz);
        primosPorColumna(matriz);
    }

    public static int[][] crearMatriz(int dimension, int valorInferior, int valorSuperior) {
        int m[][] = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                m[i][j] = (int) (Math.random() * (valorSuperior - valorInferior + 1) + valorInferior);
            }
        }
        return m;
    }

    public static void imprimirMatriz(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println("");
        }
    }

    public static void primosPorFila(int[][] matriz) {
        int total = 0;
        for (int i = 0; i < matriz.length; i++) {
            total = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                if (esPrimo(matriz[i][j])) {
                    total++;
                }
            }
            System.out.println("La fila: " + i + " tiene: " + total + " primos.");
        }
    }

    public static void primosPorColumna(int[][] matriz) {
        int total = 0;
        for (int j = 0; j < matriz[0].length; j++) {
            total = 0;
            for (int i = 0; i < matriz.length; i++) {
                if (esPrimo(matriz[i][j])) {
                    total++;
                }
            }
            System.out.println("La columna: " + j + " tiene: " + total + " primos.");
        }
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
