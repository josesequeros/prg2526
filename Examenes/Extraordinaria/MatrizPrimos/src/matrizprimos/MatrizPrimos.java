/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrizprimos;

/**
 *
 * @author ja.buenoseva
 */
public class MatrizPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int matriz[][];
        int n = 7;
        System.out.println("Dimension de la matriz: " + n);
        matriz = obtenerMatriz(n);
        visualizarMatriz(matriz);
        int diagonal = obtenerDiagonal(matriz,0);
        System.out.println("La diagonal principal suma: " + diagonal);
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

    private static int[][] obtenerMatriz(int n) {
        int[][] matriz = new int[n][n];
        int numero = 2;
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                while (!esPrimo(numero)) {
                    numero++;
                }
                matriz[fila][columna] = numero;
                numero++;
            }
        }
        return matriz;
    }

    private static void visualizarMatriz(int[][] matriz) {
        int n = matriz.length;
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                System.out.printf("%4d", matriz[fila][columna]);
            }
            System.out.println("");
        }
    }

    private static int obtenerDiagonal(int[][] matriz,int elemento) {
        //int suma = 0;
        if (elemento == matriz.length) {
            return 0;
        } else {
            return matriz[elemento][elemento] + obtenerDiagonal(matriz, elemento+1);
        }
        
    }
}
