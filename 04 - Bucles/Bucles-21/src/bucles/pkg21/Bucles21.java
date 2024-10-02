/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bucles.pkg21;

/**
 *
 * @author jabue
 */
public class Bucles21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int altura = 5;
        int base = 7;
        int veces = 3;

        System.out.println("Ejercicio 21");
        System.out.println("");
        for (int vez = 1; vez <= veces; vez++) {
            for (int fila = 1; fila <= altura; fila++) {
                if (fila < altura || (fila == altura && vez == veces)) {
                    for (int columna = 1; columna <= base; columna++) {
                        if (fila == 1 || fila == altura || columna == 1 || columna == base) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println("");
                }
            }
        }
    }

}
