/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg06.recorridomatriz;

/**
 *
 * @author IEUser
 */
public class RecorridoMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] matriz;
        int filas = 4;
        int columnas = 5;
        matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) { 
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) (1 + Math.random() * 100);
            }
        }
        // recorrido por filas
        System.out.println("Recorrido de la matriz por filas");
        for (int i = 0; i < filas; i++) { 
            System.out.print("Fila: " + i + "  ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        // recorrido por columnas
        System.out.println("Recorrido de la matriz por columnas");
        for (int j = 0; j < columnas; j++) {
            System.out.print("Columna: " + j + "  ");
            for (int i = 0; i < filas; i++) {     
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        // bucle for each
        System.out.println("Recorrido de la matriz por filas");
        for (int[] x:matriz){
            for (int y:x){
                System.out.print("Valor: "+ y + "  ");
            }
            System.out.println("");
        }
    }
}
