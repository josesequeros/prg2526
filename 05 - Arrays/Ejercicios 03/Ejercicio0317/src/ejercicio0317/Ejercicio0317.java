/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0317;

/**
 *
 * @author jabue
 */
public class Ejercicio0317 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int filas = 0;
        int columnas = 0;
        int dimension = 10;
        filas = (int) (Math.random() * dimension + 1) - 0;
        columnas = (int) (Math.random() * dimension + 1) - 0;
        // definimos la matriz
        int[][] matriz = new int[filas][columnas];
        // damos valores a la matriz
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                //matriz[i][j] = (int) (Math.random() * 21) - 10;   //  entre -10 y 10
                matriz[fila][columna] = (int) (Math.random() * dimension) - 0;
            }
        }
        // mostramos la matriz
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[0].length; columna++) {
                System.out.printf("%3d", matriz[fila][columna]);
            }
            System.out.println("");
        }
        // obtenemos columna con suma mínima
        int sumaMinima = Integer.MAX_VALUE;
        int sumaMaxima = 0;
        int posicion = 0;
        for (int columna = 0; columna < matriz[0].length; columna++) {
            int suma = 0;
            for (int fila = 0; fila < matriz.length; fila++) {
                suma += matriz[fila][columna];
            }
            if (suma> sumaMaxima) {
                sumaMaxima = suma;
                posicion = columna;
            }
        }
        System.out.println("La suma maxima es: "+sumaMaxima);
        System.out.println("Corresponde a la columna: "+posicion);
        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("%3d", matriz[i][posicion]);
        }
        System.out.println("");
    }

}
