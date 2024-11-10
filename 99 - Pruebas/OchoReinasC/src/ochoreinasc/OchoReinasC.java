/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ochoreinasc;

/**
 *
 * @author jabue
 */
public class OchoReinasC {


    private static final int N = 4; // Tamaño del tablero y número de reinas
    private int[][] tablero = new int[N][N];

    public static void main(String[] args) {
        OchoReinasC ochoReinas = new OchoReinasC();
        ochoReinas.resolver();
    }

    public void resolver() {
        if (colocarReina(0)) {
            System.out.println("Se encontró al menos una solución.");
        } else {
            System.out.println("No hay solución para el problema.");
        }
    }

    // Método recursivo para colocar las reinas
    private boolean colocarReina(int fila) {
        if (fila == N) { // Todas las reinas están colocadas
            imprimirTablero();
            return true;
        }

        boolean exito = false;

        for (int columna = 0; columna < N; columna++) {
            if (esPosicionSegura(fila, columna)) {
                tablero[fila][columna] = 1; // Coloca la reina
                exito = colocarReina(fila + 1) || exito;
                tablero[fila][columna] = 0; // Retira la reina (backtracking)
            }
        }

        return exito;
    }

    // Verifica si es seguro colocar una reina en una posición dada
    private boolean esPosicionSegura(int fila, int columna) {
        // Verifica la columna
        for (int i = 0; i < fila; i++) {
            if (tablero[i][columna] == 1) {
                return false;
            }
        }

        // Verifica la diagonal superior izquierda
        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        // Verifica la diagonal superior derecha
        for (int i = fila, j = columna; i >= 0 && j < N; i--, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Imprime el tablero con la solución actual
    private void imprimirTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

    

