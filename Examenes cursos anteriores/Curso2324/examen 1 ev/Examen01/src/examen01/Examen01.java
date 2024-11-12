/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen01;

/**
 *
 * @author jabue
 */
public class Examen01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 10;
        int[][] vector = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                vector[i][j] = (int) (Math.random() * 10 + 1);
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("%3d", vector[i][j]);
            }
            System.out.println("");
        }

        double max = vector[0][0] * vector[0][1] / 2.0;
        int posicion = 0;
        for (int i = 0; i < n; i++) {
            int base = vector[i][0];
            int altura = vector[i][1];
            double area = base * altura / 2.0;
            if (area > max) {
                max = area;
                posicion = i;
            }
        }
        System.out.println("");
        System.out.println("Triangulo Mayor: " + posicion + 
                " con base= " + vector[posicion][0] + " y altura= " + vector[posicion][1] + " de Area =  " + max);
    }

}
