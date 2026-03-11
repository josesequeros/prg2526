/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2evaluacionejercicio1;

/**
 *
 * @author ja.buenoseva
 */
public class Examen2EvaluacionEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numeroMatrices = 3;
        int dimension = 5;
        int matriz[][];// = new int[dimension][dimension];
        int tope = 9 * dimension / 2;

        System.out.println("Tope = " + tope);
        for (int m = 0; m < numeroMatrices; m++) {
            System.out.println("Matriz: " + m);
            matriz = generarMatriz(dimension);
            imprimirMatriz(matriz);
            comprobarMatriz(matriz, tope);
        }
    }

    public static int[][] generarMatriz(int dimension) {
        int matriz[][] = new int[dimension][dimension];

        for (int fila = 0; fila < dimension; fila++) {
            for (int columna = 0; columna < dimension; columna++) {
                matriz[fila][columna] = (int) (Math.random() * 10);
            }
        }
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        int dimension = matriz[0].length;

        for (int fila = 0; fila < dimension; fila++) {
            int suma = 0;
            for (int columna = 0; columna < dimension; columna++) {
                System.out.print(matriz[fila][columna] + " ");
                suma += matriz[fila][columna];
            }
            System.out.println("\tSuma = " + suma);
        }
    }

    public static void comprobarMatriz(int[][] matriz, int tope) {
        int dimension = matriz[0].length;

        for (int fila = 0; fila < dimension; fila++) {
            int suma = 0;
            for (int columna = 0; columna < dimension; columna++) {
                suma += matriz[fila][columna];
            }
            if (suma > tope) {
                System.out.println("\t\tSuma Fila: " + fila + " = " + suma);
            }
        }
    }
}

