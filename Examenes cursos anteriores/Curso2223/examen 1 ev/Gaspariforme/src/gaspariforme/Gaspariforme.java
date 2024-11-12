/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gaspariforme;

/**
 *
 * @author jabue
 */
public class Gaspariforme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int elementos = 10;
        int rango = 10;
        int[] vector = new int[elementos];
        //int[] vector = {1, 5, -2, 2, 3, 0, -5, 3, -4, -3};
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

        System.out.println("Sumas: ");
        int suma = 0;
        boolean gaspariforme = true;
        for (int i = 0; i < elementos; i++) {
            suma += vector[i];
            System.out.println(suma);
            if (suma < 0) {
                gaspariforme = false;
            }
        }
        if (suma != 0) {
            gaspariforme = false;
        }
        if (gaspariforme) {
            System.out.println("Si es Gaspariforme");
        } else {
            System.out.println("No es Gaspariforme");
        }
    }

}
