/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array_matricesverdadero;

import java.util.Scanner;

/**
 *
 * @author pabvazrui
 */
public class Array_MatricesVERDADERO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el tamaño de la matriz: ");
        int n = sc.nextInt();

        int[][] matriz = new int[n][n];
        System.out.println("Introduce los valores de la matriz:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        mostrarMatriz(matriz);
        System.out.println("\nSuma diagonal principal: "
                + sumaDiagonalPrincipal(matriz));
        System.out.println("Suma diagonal secundaria: "
                + sumaDiagonalSecundaria(matriz));
        if (esSimetrica(matriz)) {
            System.out.println("La matriz es simetrica.");
        } else {
            System.out.println("La matriz no es simetrica.");
        }
        sc.close();
    }

    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("\nMatriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int sumaDiagonalPrincipal(int[][] matriz) {
        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][i];
        }
        return suma;
    }

    public static int sumaDiagonalSecundaria(int[][] matriz) {
        int suma = 0;
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            suma += matriz[i][n - 1 - i];
        }
        return suma;
    }

    public static boolean esSimetrica(int[][] matriz) {
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}