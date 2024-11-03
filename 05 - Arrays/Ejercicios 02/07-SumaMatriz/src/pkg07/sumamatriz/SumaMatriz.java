/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg07.sumamatriz;

/**
 *
 * @author IEUser
 */
public class SumaMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] matriz;
        int filas = 5;
        int columnas = 6;
        int suma = 0;
        matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) { 
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) (0 + Math.random() * 10);
            }
        }
        // recorrido por filas
        System.out.println("Matriz:");
        for (int i = 0; i < filas; i++) { 
            //System.out.print("Fila: " + i + "  ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j]+" ");
                suma += matriz[i][j];
            }
            System.out.println("");
        }
        // recorrido por columnas
        System.out.println("La suma es: " + suma);
    } 
}
