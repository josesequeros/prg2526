/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrizmenorprimo;

/**
 *
 * @author IEUser
 */
public class MatrizMenorPrimo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int filas=5,columnas=4;
        int matriz[][] = new int[filas][columnas];
        int matrizPrimos[][] = new int[filas][columnas];
        // Crear la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) (1+Math.random()*100);
            }
        }
        // Visualizar matriz original
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println("");
        }
        // crear matriz de primos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int numero = matriz[i][j];
                while (!esPrimo(numero)&& numero>1)
                    numero--;
                matrizPrimos[i][j] = numero;
            }
        }
        System.out.println("");
        // Visualizar matriz original
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%4d", matrizPrimos[i][j]);
            }
            System.out.println("");
        }
    }

    public static boolean esPrimo(int numero) {
        int divisor;
        boolean puedeSerlo;
        if (numero == 2) {
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

}
