/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crecidasnilo;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class CrecidasNilo {

    static final int inicio = 0, arriba = 1, derecha = 2, abajo = 3, izquierda = 4;
    static final int NOINUNDADO = 0, INUNDADO = 1;
    static int camino = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int filas, columnas;
        int maximaAltura = 10;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el ancho del terreno: ");
        columnas = entrada.nextInt();
        System.out.print("Introduce el alto del terreno: ");
        filas = entrada.nextInt();

        int[][] terreno = new int[filas][columnas];
        int[][] terrenoInundado = new int[filas][columnas];

        // Rellenamos el terreno inundado
        for (int[] row : terrenoInundado) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                terreno[i][j] = (int) (Math.random() * (maximaAltura + 1));
            }
        }

        // El terreno del ejemplo
        int[][] terreno2 = new int[][]{{3, 9, 1, 8, 2, 6}, {0, 0, 4, 4, 0, 5}, {1, 1, 1, 1, 1, 3}};
        terreno2 = new int[][]{
            {2, 1, 2, 4, 6},
            {0, 3, 3, 9, 0},
            {3, 7, 8, 9, 3}
        };
        terreno = new int[][]{
            {2, 1, 2, 4, 2},
            {6, 6, 6, 6, 6},
            {2, 1, 2, 4, 6},
            {0, 3, 3, 9, 0},
            {3, 7, 8, 9, 3}
        };
        //terreno = terreno2;

        int puntoEntrada = (filas - 1) / 2;
        terreno[puntoEntrada][0] = 0;

        // visualizar el terreno
        visualizarTerreno(terreno);

        int inundadas = 0, altura;
        for (altura = 1; altura <= maximaAltura; altura++) {
            inundadas = calcularInundacion(terreno, terrenoInundado, puntoEntrada, 0, inicio, altura);
            if (inundadas > (filas * columnas) / 2) {
                break;
            } else {
                for (int[] row : terrenoInundado) {
                    Arrays.fill(row, NOINUNDADO);
                    camino = 0;
                }
            }
        }
        System.out.println("Altura de la Crecida: " + altura);
        System.out.println("Parcelas Inundadas: " + inundadas);

        System.out.println("Camino recorrido por el agua: ");
        visualizarTerreno(terrenoInundado);
    }

    public static void visualizarTerreno(int[][] terreno) {
        System.out.println("");
        for (int i = 0; i < terreno.length; i++) {
            for (int j = 0; j < terreno[0].length; j++) {
                System.out.printf("%3d", terreno[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static int calcularInundacion(int[][] terreno, int[][] terrenoInundado, int fila, int columna, int entrada, int altura) {
        int inundadas = 0;

        //System.out.println("Coordenadas (F,C): " + fila + ", " + columna + " Inundadas: " + inundadas + " Altura: " + altura);
        if (fila >= 0 && fila < terreno.length && columna >= 0 && columna < terreno[0].length && terrenoInundado[fila][columna] == NOINUNDADO && terreno[fila][columna] <= altura) {
            //System.out.print("Coordenadas (F,C): " + fila + ", " + columna);
            inundadas++;
            terrenoInundado[fila][columna] = ++camino;  //INUNDADO;
            // if colocados por didáctico, no son necesarios
            // miramos la de arriba
            if (entrada != arriba) {
                inundadas += calcularInundacion(terreno, terrenoInundado, fila - 1, columna, abajo, altura);
            }
            // miramos la de derecha
            if (entrada != derecha) {
                inundadas += calcularInundacion(terreno, terrenoInundado, fila, columna + 1, izquierda, altura);
            }
            // miramos la de abajo
            if (entrada != abajo) {
                inundadas += calcularInundacion(terreno, terrenoInundado, fila + 1, columna, arriba, altura);
            }
            // miramos la de izquierda
            if (entrada != izquierda) {
                inundadas += calcularInundacion(terreno, terrenoInundado, fila, columna - 1, derecha, altura);
            }
            //System.out.println(" Inundadas: " + inundadas + " Altura: " + altura);
            //visualizarTerreno(terrenoInundado);
        }
        return inundadas;
    }

}
