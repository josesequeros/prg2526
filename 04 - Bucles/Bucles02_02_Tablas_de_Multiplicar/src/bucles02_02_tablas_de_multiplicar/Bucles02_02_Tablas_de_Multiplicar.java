/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bucles02_02_tablas_de_multiplicar;

/**
 *
 * @author jabue
 */
public class Bucles02_02_Tablas_de_Multiplicar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Tablas de Multiplicar");
        System.out.print("    ");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println("");
        for (int i = 0; i < 44; i++) {
            System.out.print("-");
        }
        System.out.println("");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%2d |",i);
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println("");
        }
    }

}
