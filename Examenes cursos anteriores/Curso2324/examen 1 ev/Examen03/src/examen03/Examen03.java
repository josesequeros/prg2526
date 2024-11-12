/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen03;

/**
 *
 * @author jossev
 */
public class Examen03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int filas = 5;
        int columnas = 5;
        int[][] matriz = new int[filas][columnas];
        int[][] mFilas = new int[4][filas];
        int[][] mColumnas = new int[4][columnas];

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                matriz[fila][columna] = (int) (Math.random() * 10);
            }
        }

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                System.out.printf("%3d", matriz[fila][columna]);
            }
            System.out.println("");
        }

        for (int fila = 0 + 1; fila < filas - 1; fila++) {
            for (int columna = 0 + 1; columna < columnas - 1; columna++) {
                boolean hoyo = true;
                for (int i = fila - 1; i <= fila + 1; i++) {
                    for (int j = columna - 1; j <= columna + 1; j++) {
                        if (!(i == fila && j == columna)
                                && matriz[fila][columna] >= matriz[i][j]) {
                            hoyo = false;
                        }
                    }
                }
                if (hoyo) {
                    System.out.println("Hoyo en fila: " + fila + " columna: " + columna);
                }
            }
        }

    }

}
