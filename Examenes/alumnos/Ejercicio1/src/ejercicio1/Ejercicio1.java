/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author jabue
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String mesesAño[] = {"Enero ", "Febrero ", "Marzo ", "Abril ", "Mayo ", "Junio ", "Julio ", "Agosto ", "Septiembre ", "Octubre ", "Noviembre ", "Diciembre "};
        int meses = 12;
        int dias = 31;
        int[][] temperaturas = new int[meses][dias];
        int contador = 0;
        int contador2 = 0;;
        int contador3 = 0;
        int dia[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        //Generar datos aleatorios para las temperaturas
        for (int i = 0; i < meses; i++) {
            for (int j = 0; j < dias; j++) {
                temperaturas[i][j] = random.nextInt(50) + 0;
                System.out.print(temperaturas[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("\nMayor temperatura cada mes: ");
        for (int i = 0; i < meses; i++) {
            int temperaturaMaxima = 0;
            for (int j = 0; j < dias; j++) {

                if (temperaturas[i][j] > temperaturaMaxima) {
                    temperaturaMaxima = temperaturas[i][j];

                }

            }
            System.out.println("Mayor temperatura por mes " + Arrays.toString(temperaturas[i]) + mesesAño[contador++] + temperaturaMaxima);

        }
        System.out.println("\nMenor temperatura cada mes: ");
        for (int i = 0; i < meses; i++) {

            int temperaturaMinima = 50;
            for (int j = 0; j < dias; j++) {
                if (temperaturas[i][j] < temperaturaMinima) {
                    temperaturaMinima = temperaturas[i][j];
                    
                }

            }
            System.out.println("Menor temperatura por mes " + Arrays.toString(temperaturas[i]) + mesesAño[contador2++] + temperaturaMinima);

        }

        System.out.println("\nLas medias de las temperaturas por meses son: ");
        for (int i = 0; i < meses; i++) {
            int suma = 0;
            int media = 0;

            for (int j = 0; j < dias; j++) {
                suma += temperaturas[i][j];
                media = suma / 31;
            }
            System.out.println(suma);
            System.out.println(mesesAño[contador3++] + " " + media);

        }
        System.out.println("\nDia mas caluroso del año: ");
        for (int i = 0; i < dias; i++) {
            for (int j = 0; j < meses; j++) {
                
            }
        }
    }
}
