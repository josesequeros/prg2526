/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0308;

/**
 *
 * @author jabue
 */
public class Ejercicio0308 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int filas = 5;
        int columnas = 5;
        int dimension = 10;
        filas = (int) (Math.random() * dimension + 1) - 0;
        columnas = (int) (Math.random() * dimension + 1) - 0;

        int[][] matriz = new int[filas][columnas];

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                //matriz[i][j] = (int) (Math.random() * 21) - 10;   //  entre -10 y 10
                matriz[fila][columna] = fila + columna;
            }

        }

        System.out.println("matriz: ");
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                System.out.printf("%3d", matriz[fila][columna]);
            }
            System.out.println("");
        }

    }

}
