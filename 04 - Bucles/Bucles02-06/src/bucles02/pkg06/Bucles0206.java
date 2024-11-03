/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bucles02.pkg06;

/**
 *
 * @author ja.buenoseva
 */
public class Bucles0206 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int filas = 8;

        for (int fila = 1; fila <= filas; fila++) {
            for (int espacios = 1; espacios <= filas - fila; espacios++) {
                System.out.print("    ");
            }
            for (int columna = 1; columna <= fila; columna++) {
                System.out.printf("%4d", (int) Math.pow(2, columna - 1));
            }
            for (int columna = fila - 2; columna >= 0; columna--) {
                System.out.printf("%4d", (int) Math.pow(2, columna ));
            }
            System.out.println("");
        }
    }

}
