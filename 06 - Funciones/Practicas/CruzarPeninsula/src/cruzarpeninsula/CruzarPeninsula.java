/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cruzarpeninsula;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class CruzarPeninsula {

    static final int inicio = 0, arriba = 1, derecha = 2, abajo = 3, izquierda = 4;
    static final int diagonal1 = 5, diagonal2 = 6, diagonal3 = 7, diagonal4 = 8;
    static final int NOALCANZADO = 0, ALCANZADO = 1;

    static int[][] terreno;
    static int[][] terrenoRecorrido;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int filas, columnas, arboles, salto;
        int arbolesCortados = 0;
        int filaInicio = 0;
        int columnaInicio = 0;
        int[][] camino = {};

        /*
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el ancho del terreno: ");
        columnas = entrada.nextInt();
        System.out.print("Introduce el alto del terreno: ");
        filas = entrada.nextInt();
        System.out.print("Introduce numero de arboles: ");
        arboles = entrada.nextInt();
        System.out.print("Introduce valor de salto: ");
        salto = entrada.nextInt();
         */
        filas = 5;
        columnas = 5;
        arboles = 5;
        salto = 3;

        terreno = new int[filas][columnas];
        terrenoRecorrido = new int[filas][columnas];

        int[][] terreno1 = {
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 4, 0},
            {0, 0, 0, 3, 2},
            {0, 0, 0, 0, 5}
        };
        int[][] terreno2 = {
            {1, 2, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {3, 0, 0, 4, 0},
            {5, 0, 0, 6, 7},
            {0, 0, 0, 0, 8}
        };

        // Rellenamos el terreno recorrido
        for (int[] row : terrenoRecorrido) {
            Arrays.fill(row, 0);
        }

        // Distribuir árboles
        distribuirArboles(terreno, arboles);
        //terreno = terreno1;
        terreno = terreno2;
        // Visualizar Terreno
        visualizarTerreno(terreno);

        //camino = recorrido(terreno, terrenoRecorrido, filaInicio, columnaInicio, salto);
        camino = recorrido(filaInicio, columnaInicio, salto);
        if (camino.length == 0) {
            System.out.println("Nunca esistió el camino");
        } else {
            mostrarCamino(camino);
        }

    }

    public static void distribuirArboles(int[][] terreno, int arboles) {
        int filas = terreno.length;
        int columnas = terreno[0].length;
        int f, c;

        terreno[0][0] = 1;
        terreno[filas - 1][columnas - 1] = arboles;
        for (int i = 2; i < arboles; i++) {
            f = (int) (Math.random() * (filas));
            c = (int) (Math.random() * (columnas));
            if (terreno[f][c] == 0) {
                terreno[f][c] = i;
            } else {
                i--;
            }
        }
    }

    public static void visualizarTerreno(int[][] terreno) {
        System.out.println("");
        for (int i = 0; i < terreno.length; i++) {
            for (int j = 0; j < terreno[0].length; j++) {
                System.out.printf("%4d", terreno[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    //public static int[][] recorrido(int[][] terreno, int[][] terrenoRecorrido,
    public static int[][] recorrido(int filaInicio, int columnaInicio, int salto) {
        int filas = terreno.length;
        int columnas = terreno[0].length;

        int[][] camino = {};
        int s = 1;

        if (filaInicio >= 0 && filaInicio < filas && columnaInicio >= 0 && columnaInicio < columnas) {
            if (terrenoRecorrido[filaInicio][columnaInicio] == NOALCANZADO
                    && terreno[filaInicio][columnaInicio] > 0) {
                camino = addArbolCamino(camino, filaInicio, columnaInicio);
                terrenoRecorrido[filaInicio][columnaInicio] = ALCANZADO;
                //mostrarCamino(camino);
                //camino = addCamino(camino, recorrido(terreno, terrenoRecorrido, filaInicio, columnaInicio + s, salto));
                for (s = 1; s <= salto; s++) {

                    camino = addCamino(camino, recorrido(filaInicio, columnaInicio + s, salto));

                    if (!(camino[camino.length - 1][0] == filas - 1 && camino[camino.length - 1][1] == columnas - 1)) {
                        camino = addCamino(camino, recorrido(filaInicio + s, columnaInicio, salto));
                    }

                    if (!(camino[camino.length - 1][0] == filas - 1 && camino[camino.length - 1][1] == columnas - 1)) {
                        camino = addCamino(camino, recorrido(filaInicio, columnaInicio - s, salto));
                    }

                    if (!(camino[camino.length - 1][0] == filas - 1 && camino[camino.length - 1][1] == columnas - 1)) {
                        camino = addCamino(camino, recorrido(filaInicio - s, columnaInicio, salto));
                    }
                }
                if (!(camino[camino.length - 1][0] == filas - 1 && camino[camino.length - 1][1] == columnas - 1)) {
                    camino = quitarArbolCamino(camino, filaInicio, columnaInicio);
                    //System.out.println("eliminado");
                }
            }
        }
        //mostrarCamino(camino);
        return camino;
    }

    public static int[][] addArbolCamino(int[][] camino, int fila, int columna) {
        int[][] nuevoCamino = new int[camino.length + 1][2];
        int i;
        for (i = 0; i < camino.length; i++) {
            nuevoCamino[i][0] = camino[i][0];
            nuevoCamino[i][1] = camino[i][1];
        }
        nuevoCamino[i][0] = fila;
        nuevoCamino[i][1] = columna;
        return nuevoCamino;
    }

    public static int[][] quitarArbolCamino(int[][] camino, int fila, int columna) {
        int[][] nuevoCamino = new int[camino.length - 1][2];
        int i;
        for (i = 0; i < camino.length - 1; i++) {
            nuevoCamino[i][0] = camino[i][0];
            nuevoCamino[i][1] = camino[i][1];
        }
        return nuevoCamino;
    }

    public static int[][] addCamino(int[][] camino, int[][] caminoNuevo) {
        int[][] nuevoCamino = new int[camino.length + caminoNuevo.length][2];
        int i;
        for (i = 0; i < camino.length; i++) {
            nuevoCamino[i][0] = camino[i][0];
            nuevoCamino[i][1] = camino[i][1];
        }
        int pos = i;
        for (i = 0; i < caminoNuevo.length; i++) {
            nuevoCamino[pos + i][0] = caminoNuevo[i][0];
            nuevoCamino[pos + i][1] = caminoNuevo[i][1];
        }
        return nuevoCamino;
    }

    public static void mostrarCamino(int[][] camino) {
        int i;
        for (i = 0; i < camino.length - 1; i++) {
            System.out.print("(");
            System.out.print(camino[i][0]);
            System.out.print(",");
            System.out.print(camino[i][1]);
            System.out.print(")");
            System.out.print(" --> ");
        }
        if (i < camino.length) {
            System.out.print("(");
            System.out.print(camino[i][0]);
            System.out.print(",");
            System.out.print(camino[i][1]);
            System.out.print(")");
            System.out.println("");
        }
    }
}
