/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen02;

/**
 *
 * @author jabue
 */
public class Examen02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 10;
        int[] vector = new int[n];

        for (int i = 0; i < n; i++) {
            vector[i] = (int) (Math.random() * 21 - 10);
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%3d", vector[i]);
        }
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += vector[i];
        }
        System.out.println("");
        System.out.println("Suma = " + suma);
        for (int i = 0; i < n; i++) {
            if (vector[i] == suma - vector[i]) {
                System.out.println("El elemento en la posicion " + i + " es un centro");
            }
        }

    }

}
