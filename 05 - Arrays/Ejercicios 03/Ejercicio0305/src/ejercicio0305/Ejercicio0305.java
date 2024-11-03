/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0305;

/**
 *
 * @author jabue
 */
public class Ejercicio0305 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int elementos = 10;
        int rango = 10;
        int[] vector = new int[elementos];

        for (int i = 0; i < elementos; i++) {
            vector[i] = (int) (Math.random() * 21) - 10;
            //vector[i] = (int) (Math.random() * rango + 1) - 0;
        }
        System.out.println("Vector Original: ");
        for (int i = 0; i < elementos - 1; i++) {
            System.out.print(vector[i] + ", ");
        }
        System.out.println(vector[elementos - 1]);

        for (int i = 0; i < elementos; i++) {
            for (int j = elementos - 1; j > i; j--) {
                if (vector[j] < vector[j - 1]) {
                    int aux = vector[j];
                    vector[j] = vector[j - 1];
                    vector[j - 1] = aux;
                }
            }
        }
        System.out.println("Vector Ordenado: ");
        for (int j = 0; j < elementos - 1; j++) {
            System.out.print(vector[j] + ", ");
        }
        System.out.println(vector[elementos - 1]);
    }

}
