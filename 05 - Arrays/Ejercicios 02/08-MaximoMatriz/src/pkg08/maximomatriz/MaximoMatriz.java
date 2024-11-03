/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg08.maximomatriz;

/**
 *
 * @author IEUser
 */
public class MaximoMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] matriz;
        int filas = 5;
        int columnas = 6;
        int posicionFila = 0, posicionColumna = 0;
        int maximo = 0;
        matriz = new int[filas][columnas];
        
        for (int i = 0; i < filas; i++) { 
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) (0 + Math.random() * 100);
            }
        }
        // recorrido por filas
        System.out.println("Matriz:");
        for (int i = 0; i < filas; i++) { 
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j]+" ");
                if (matriz[i][j] > maximo) {
                    maximo = matriz[i][j];
                    posicionFila = i;
                    posicionColumna = j;
                }
            }
            System.out.println("");
        }
        // recorrido por columnas
        System.out.println("La máximo es: " + matriz[posicionFila][posicionColumna]);
        System.out.println("En fila: " + posicionFila + " y columna: " + posicionColumna);
    }
    
}
