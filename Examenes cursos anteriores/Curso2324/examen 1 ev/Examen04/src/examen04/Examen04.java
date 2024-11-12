/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen04;

/**
 *
 * @author jossev
 */
public class Examen04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int filas = 3;
        int columnas = 4;
        int[][] matriz = new int[filas][columnas];
        int[][] mFilas = new int[4][filas];
        int[][] mColumnas = new int[4][columnas];

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                matriz[fila][columna] = (int) (Math.random() * 6);
            }
        }

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                System.out.printf("%3d", matriz[fila][columna]);
            }
            System.out.println("");
        }

        System.out.println("Filas");

        for (int fila = 0; fila < filas; fila++) {
            int sumaFilas = 0;
            int prodFilas = 1;
            int min = 100;
            int max = 0;
            for (int columna = 0; columna < columnas; columna++) {
                sumaFilas += matriz[fila][columna];
                prodFilas *= matriz[fila][columna];
                if (matriz[fila][columna] < min) {
                    min = matriz[fila][columna];
                }
                if (matriz[fila][columna] > max) {
                    max = matriz[fila][columna];
                }

            }
            mFilas[0][fila] = sumaFilas;
            mFilas[1][fila] = prodFilas;
            mFilas[2][fila] = min;
            mFilas[3][fila] = max;
        }
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < filas; columna++) {
                System.out.printf("%3d", mFilas[fila][columna]);
            }
            System.out.println("");
        }

        System.out.println("Columnas");

        for (int columna = 0; columna < columnas; columna++) {
            int sumaFilas = 0;
            int prodFilas = 1;
            int min = 100;
            int max = 0;
            for (int fila = 0; fila < filas; fila++) {
                sumaFilas += matriz[fila][columna];
                prodFilas *= matriz[fila][columna];
                if (matriz[fila][columna] < min) {
                    min = matriz[fila][columna];
                }
                if (matriz[fila][columna] > max) {
                    max = matriz[fila][columna];
                }

            }
            mColumnas[0][columna] = sumaFilas;
            mColumnas[1][columna] = prodFilas;
            mColumnas[2][columna] = min;
            mColumnas[3][columna] = max;
        }
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                System.out.printf("%3d", mColumnas[fila][columna]);
            }
            System.out.println("");
        }
    }

}
