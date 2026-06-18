/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio03matrices;

/**
 *
 * @author jabue
 */
public class Ejercicio03Matrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 3;
        int[][] matriz;

        matriz = generarMatriz(n);
        visualizarMatriz(matriz);
        int suma;
        suma = sumaDiagonalPrincipal(matriz);
        System.out.println("La diagonal principal suma: " + suma);
        suma = sumaDiagonalSecundaria(matriz);
        System.out.println("La diagonal secundaria suma: " + suma);
        if (esSimetrica(matriz)) {
            System.out.println("Es simétrica");
        } else {
            System.out.println("No es simétrica");
        }
    }

    private static int[][] generarMatriz(int n) {
        int[][] matriz = new int[n][n];
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                matriz[fila][columna] = (int) (Math.random() * 3);
            }
        }
        return matriz;
    }

    private static void visualizarMatriz(int[][] matriz) {
        int n = matriz.length;
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                System.out.printf("%3d", matriz[fila][columna]);
            }
            System.out.println("");
        }
    }

    private static int sumaDiagonalPrincipal(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][i];
        }
        return suma;
    }

    private static int sumaDiagonalSecundaria(int[][] matriz) {
        int suma = 0;
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            suma += matriz[i][n - i - 1];
        }
        return suma;
    }

    private static boolean esSimetrica(int[][] matriz) {
        int n = matriz.length;
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                if (matriz[fila][columna] != matriz[columna][fila]) {
                    return false;
                }
            }
        }
        return true;
    }
}
