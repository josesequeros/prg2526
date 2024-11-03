/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0307;

/**
 *
 * @author jabue
 */
public class Ejercicio0307 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int elementos = 10;
        int rango = 10;
        elementos = (int) (Math.random() * 10 + 1) - 0;
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

        int i = 0;
        int j = vector.length - 1;
        int suma = 0;
        while (i <= j) {
            if (vector[i] == vector[j]) {
                if (i == j) {
                    suma += vector[i];
                } else {
                    suma += vector[i] + vector[j];
                }
            }
            i++;
            j--;
        }
        System.out.println("Suma = " + suma);
    }

}
