/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ochoreinas;

/**
 *
 * @author jabue
 */
public class OchoReinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 8;
        int fila, columna;
        // dada una posición en el tablero
        fila = (int) (Math.random() * 8);
        columna = (int) (Math.random() * 8);
        //fila = 6;columna = 1;
        System.out.println("Posicion inicial: " + fila + "," + columna);
        // obtener que posiciones están amenenazadas
        // misma fila
        System.out.println("Misma fila: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fila + "," + i + " - ");
        }
        // Misma columna
        System.out.println("");
        System.out.println("Misma columna: ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + "," + columna + " - ");
        }
        // Diagonal 1
        System.out.println("");
        System.out.println("Diagonal 1: ");
        int menor = fila < columna ? fila : columna;
        int inicioFila = fila - menor;
        int inicioColumna = columna - menor;
        for (int i = inicioFila, j = inicioColumna; i < n && j < n; i++, j++) {
            System.out.print(i + "," + j + " - ");
        }
        // Diagonal 3
        System.out.println("");
        System.out.println("Diagonal 2: ");
        menor = fila < columna ? fila : columna;
        inicioFila = fila + columna < n ? fila + columna : n - 1;
        inicioColumna = columna - (inicioFila - fila);
        for (int i = inicioFila, j = inicioColumna; i >= 0 && i < n && j < n; i--, j++) {
            System.out.print(i + "," + j + " - ");
        }
    }

}
