/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0304;

/**
 *
 * @author jabue
 */
public class Ejercicio0304 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int elementos = 10;
        int rango = 10;
        int[] vector = new int[elementos];
        int[] vectorNuevo = new int[elementos];

        for (int i = 0; i < elementos; i++) {
            vector[i] = (int) (Math.random() * 21) - 10;
            //vector[i] = (int) (Math.random() * rango + 1) - 0;
        }
        System.out.println("Vector Original: ");
        for (int i = 0; i < elementos - 1; i++) {
            System.out.print(vector[i] + ", ");
        }
        System.out.println(vector[elementos - 1]);
        int j = 0;
        for (int i = 0; i < elementos; i++) {
            if (vector[i] < 0) {
                vectorNuevo[j++] = vector[i];
            }
        }
        for (int i = 0; i < elementos; i++) {
            if (vector[i] > 0) {
                vectorNuevo[j++] = vector[i];
            }
        }
        System.out.println("Vector Ordenado: ");
        for (int i = 0; i < elementos - 1; i++) {
            System.out.print(vectorNuevo[i] + ", ");
        }
        System.out.println(vectorNuevo[elementos - 1]);
    }

}
