/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0209;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ja.buenoseva
 */
public class Ejercicio0209 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 10;
        int numeros[];
        int opc = 0;

        numeros = crearArray(n, -10, 10);
        visualizarArray(numeros);

        do {
            opc = menu();
            switch (opc) {
                case 1:
                    System.out.println("Minimo: " + minimoArray(numeros));
                    break;
                case 2:
                    System.out.println("Máximo: " + maximoArray(numeros));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opc != 0);
    }

    public static int[] crearArray(int n, int menor, int mayor) {
        int vector[] = new int[n];
        for (int i = 0; i < n; i++) {
            vector[i] = (int) (Math.random() * (mayor - menor) + menor);
        }
        return vector;
    }

    public static int minimoArray(int[] numeros) {
        int menor = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
        return menor;
    }

    public static int maximoArray(int[] numeros) {
        int mayor = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        return mayor;
    }

    public static int menu() {
        int opc = 0;

        System.out.println("");
        System.out.println("Menu");
        System.out.println("-----------------------------");
        System.out.println("1.- Mínimo del array");
        System.out.println("2.- Máximo del array");
        System.out.println("0.- Salir");
        System.out.println("");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca numero opcion: ");
        opc = teclado.nextInt();

        return opc;
    }

    public static void visualizarArray(int[] numeros) {
        System.out.println(Arrays.toString(numeros));
    }

}
