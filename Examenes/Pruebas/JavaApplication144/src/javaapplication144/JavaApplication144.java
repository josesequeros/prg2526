/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication144;

import java.util.Arrays;

/**
 *
 * @author jabue
 */
public class JavaApplication144 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int orden = 10;
        int matriz[][] = new int[orden][orden];
        int vectorSumasFilas[] = new int[orden+1];

        for (int fila = 0; fila < orden; fila++) {
            for (int columna = 0; columna < orden; columna++) {
                matriz[fila][columna] = (int) (Math.random() * 2);
            }
        }
        for (int fila = 0; fila < orden; fila++) {
            for (int columna = 0; columna < orden; columna++) {
                System.out.printf("%2d", matriz[fila][columna]);
            }
            System.out.println("");
        }
        // suma de filas
        int suma = 0;
        for (int fila = 0; fila < orden; fila++) {
            suma = 0;
            for (int columna = 0; columna < orden; columna++) {
                suma += matriz[fila][columna];
            }
            vectorSumasFilas[suma]++;
        }
        System.out.println("Vector suma de filas: " + Arrays.toString(vectorSumasFilas));
        //Fila que mas veces suma
        int filaMayor = -1;
        int aparece = 0;
        for (int fila = 0; fila < orden; fila++) {
            if (vectorSumasFilas[fila] > filaMayor) {
                filaMayor = vectorSumasFilas[fila];
                aparece = 1;
            } else if (vectorSumasFilas[fila] == filaMayor) {
                aparece++;
            }

        }
        System.out.println("La mayor es: " + filaMayor);
        System.out.println("Y aparece: " + aparece + " veces");
    }

}
