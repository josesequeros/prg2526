/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2;

import java.util.Arrays;

/**
 *
 * @author ja.buenoseva
 */
public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 5;
        int[][] matriz = new int[n][n];
        int[] contadores = new int[n+1];
        int[] sumaFilas = new int[n];

        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                matriz[fila][columna] = (int) (Math.random() * 2);
                System.out.printf("%2d", matriz[fila][columna]);
            }
            System.out.println("");
        }

        for (int fila = 0; fila < n; fila++) {
            int sumaFila = 0;
            for (int columna = 0; columna < n; columna++) {
                sumaFila += matriz[fila][columna];
            }
            sumaFilas[fila] = sumaFila;
            contadores[sumaFila]++;
        }
        System.out.println(Arrays.toString(sumaFilas));
        System.out.println(Arrays.toString(contadores));
        int veces = 0;
        int sumaMayor = 0;
        for (int fila = 0; fila < n; fila++) {
            if (contadores[fila] >= veces) {
                veces = contadores[fila];
                sumaMayor = fila;
            }
        }
        System.out.println("La suma que mas se repite es:  " + sumaMayor);
        System.out.println("y las veces que se repite son: " + veces);
    }

}
