/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package subarraysumacero;

import java.util.Arrays;

/**
 *
 * @author jabue
 */
public class SubarraySumaCero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int elementos = 10;
        int rango = 10;
        //int[] vector = new int[elementos];
        int[] vector = {-2, 4, 1, -5, 7, -3, 5, -8, 6, 2};
        int[] vectorNuevo = new int[elementos];

        for (int i = 0; i < elementos; i++) {
            //vector[i] = (int) (Math.random() * 21) - 10;
            //vector[i] = (int) (Math.random() * rango + 1) - 0;
        }

        System.out.println("Vector Original: ");
        for (int i = 0; i < elementos - 1; i++) {
            System.out.print(vector[i] + ", ");
        }
        System.out.println(vector[elementos - 1]);

        for (int i = 0; i < elementos; i++) {
            boolean sumaCero = false;
            int j = i;
            int inicio = i;
            int fin = j;
            int suma = 0;
            while (j < elementos && !sumaCero) {
                fin = j;
                suma += vector[j++];
                if (suma == 0) {
                    sumaCero = true;
                }
            }
            if (sumaCero) {
                int[] subarray = Arrays.copyOfRange(vector, inicio, fin + 1);
                System.out.println("Inicio = " + inicio + " Fin = " + fin + " Subarray = "
                        + "");
                for (int k = 0; k < subarray.length; k++) {
                    System.out.print(subarray[k] + " ");
                }
                System.out.println("");

            }
        }
        
        System.out.println("");
        for (int i = 0; i < elementos; i++) {
                int suma = 0;
                for (int j = i; j < elementos; j++) {
                    suma += vector[j];
                    if (suma == 0) {
                        for (int k = i; k <= j; k++) {
                            System.out.print(vector[k] + " ");
                        }
                        System.out.println("");
                    }
                }
            }
        
    }

}
