/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0306;

import java.util.Arrays;

/**
 *
 * @author jabue
 */
public class Ejercicio0306 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int elementos = 20;
        int rango = 9;
        int[] vector = new int[elementos];
        //int[] vector = {8,8,4,3};
        //int[] vector = {4,0,5,9,9};
        //int[] vector = {0,9,4,5,9};
        //int[] vector = {1,7,1,0,0,8,7};

        //elementos = (int) (Math.random() * 10 + 1) - 0;
        for (int i = 0; i < elementos; i++) {
            //vector[i] = (int) (Math.random() * 21) - 10;
            vector[i] = (int) (Math.random() * rango + 1) - 0;
        }

        System.out.println("Vector Original: ");
        for (int i = 0; i < elementos - 1; i++) {
            System.out.print(vector[i] + ", ");
        }
        System.out.println(vector[elementos - 1]);

        int fin = 0;
        String numero = "";
        for (int i = 0; i < vector.length - 1; i++, fin = i) {
            //fin = i;
            numero = numero + vector[i];
            if (vector[i] == vector[i + 1]) {
                break;
            }
            if (i == vector.length - 2) {
                numero = numero + vector[i + 1];
            }
        }

        int[] nuevoVector = Arrays.copyOfRange(vector, 0, fin + 1);
        System.out.println("Vector Final: ");
        for (int i = 0; i < nuevoVector.length - 1; i++) {
            System.out.print(nuevoVector[i] + ", ");
        }
        System.out.println(nuevoVector[nuevoVector.length - 1]);
        System.out.println("");
        System.out.println("Numero = " + numero);
    }

}
