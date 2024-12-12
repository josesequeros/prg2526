/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuantoscapicuas;

import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class CuantosCapicuas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int digitos, numero, reves, cantidadCapicuas, cifra;
        int minimo, maximo;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el número de dígitos: ");
        digitos = entrada.nextInt();
        while (digitos > 0) {
            int[] primeros = {0, 0, 0, 0, 0};
            int[] ultimos = new int[]{0, 0, 0, 0, 0};
            
            cantidadCapicuas = 0;
            minimo = (int) Math.pow(10, digitos - 1);
            maximo = (int) Math.pow(10, digitos);
            System.out.println("Capicúas entre: " + minimo + " y " + (maximo - 1));
            int j = 0;
            for (int i = minimo; i < maximo; i++) {
                numero = i;
                reves = 0;
                while (numero > 0) {
                    cifra = numero % 10;
                    reves = (int) (cifra + reves * 10);
                    numero = (int) numero / 10;
                }
                if (i == reves) {
                    cantidadCapicuas++;
                    if (j < 5) {
                        primeros[j++] = i;
                    } else {
                        for (int k = 4; k > 0; k--) {
                            ultimos[k] = ultimos[k - 1];
                        }
                        ultimos[0] = i;
                    }
                    //System.out.println(i);
                }
            }

            for (int i = 0; i < 5; i++) {
                if (primeros[i] != 0) {
                    System.out.println(primeros[i]);
                }
            }
            if (cantidadCapicuas >= 10) {
                System.out.println("...");
            }
            for (int k = 4; k >= 0; k--) {
                if (ultimos[k] != 0) {
                    System.out.println(ultimos[k]);
                }
            }

            System.out.println("Capicúas de " + digitos + " cifras: " + cantidadCapicuas);
            System.out.println("\nIntroduzca el número de dígitos: ");
            digitos = entrada.nextInt();
        }
        System.out.println("\nFin del programa.");
    }

}
