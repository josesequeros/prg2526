/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0301;

import java.util.Arrays;

/**
 *
 * @author jabue
 */
public class Ejercicio0301 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int elementos = 10;
        int rango = 100;
        int[] vector = new int[elementos];

        for (int i = 0; i < elementos; i++) {
            //vector[i] = (int) (Math.random() * 21) - 10;
            vector[i] = (int) (Math.random() * rango + 1) - 0;
        }
        System.out.println("Vector Original: ");
        for (int i = 0; i < elementos - 1; i++) {
            System.out.print(vector[i] + ", ");
        }
        System.out.println(vector[elementos - 1]);

        System.out.println("Vector al reves: ");
        for (int i = elementos - 1; i > 0; i--) {
            System.out.print(vector[i] + ", ");
        }
        System.out.println(vector[0]);

        System.out.println("Suma de Pares e Impares: ");
        int sumaPar = 0;
        int sumaImpar = 0;
        for (int i = 0; i < elementos; i++) {
            if (vector[i] % 2 == 0) {
                sumaPar += vector[i];
            } else {
                sumaImpar += vector[i];
            }
        }
        System.out.println("La suma de los elementos pares es: " + sumaPar);
        System.out.println("La suma de los elementos impares es: " + sumaImpar);

        System.out.println("Media de Pares e Impares: ");
        int pares = 0;
        int impares = 0;
        for (int i = 0; i < elementos; i++) {

            if (vector[i] % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }
        System.out.println("La media de los elementos pares es: " + sumaPar + "/" + pares + "=" + (double) sumaPar / pares);
        System.out.println("La media de los elementos impares es: " + sumaImpar + "/" + impares + "=" + (double) sumaImpar / impares);

        System.out.println("Ordenado de Mayor a Menor: ");
        int i = 0;
        while (i < elementos - 1 && vector[i] >= vector[i + 1]) {
            i++;
        }
        if (i == elementos - 1) {
            System.out.println("El vector esta ordenada descendentemente");
        }

        System.out.println("Ordenado de Menor a Mayor: ");
        i = 0;
        while (i < elementos - 1 && vector[i] <= vector[i + 1]) {
            i++;
        }
        if (i == elementos - 1) {
            System.out.println("El vector esta ordenada ascendentemente");
        }

        System.out.println("Numeros Repetidos: ");
        int[] contadores = new int[rango + 1];
        Arrays.fill(contadores, 0);
        for (int j = 0; j < elementos; j++) {
            contadores[vector[j]]++;
            //System.out.println(vector[j]);
        }
        for (int j = 1; j <= rango; j++) {
            if (contadores[j] > 1) {
                System.out.println(j + " se repite " + contadores[j]);
            }
        }

    }

}
