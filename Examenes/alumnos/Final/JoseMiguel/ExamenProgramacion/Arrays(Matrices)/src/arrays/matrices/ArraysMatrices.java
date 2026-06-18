/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrays.matrices;

import java.util.Scanner;

/**
 *
 * @author josgimgar3
 */
public class ArraysMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner dato = new Scanner(System.in);
        System.out.print("Introduce el tamaño de la matriz: ");
        int t = dato.nextInt();

        int matriz[][] = new int[t][t];

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                System.out.print("Dato:");
                matriz[i][j] = dato.nextInt();
            }
            System.out.println();
        }
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        int suP = sumaDiagonalPrincipal(matriz);
        int suS = sumaDiagonalSecundaria(matriz);
        System.out.println("Suma Diagonal Principal = " + suP);
        System.out.println("Suma Diagonal Secundaria = " + suS);
    }

    public static int sumaDiagonalPrincipal(int[][] matriz) {
        int total = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(i == j){
                    total += matriz[i][j];
                }
            }
            System.out.println();
        }
        return total;
    }
     public static int sumaDiagonalSecundaria(int[][] matriz) {
        int total = 0;
        for (int i = matriz.length - 1; i > 0; i--) {
            for (int j = 0; j < matriz[i].length ; j++) {
                    total += matriz[i][j];
            }
            System.out.println();
        }
        return total;
    }
}
