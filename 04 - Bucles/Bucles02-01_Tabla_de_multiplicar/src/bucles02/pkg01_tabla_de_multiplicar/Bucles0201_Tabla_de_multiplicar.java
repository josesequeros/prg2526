/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bucles02.pkg01_tabla_de_multiplicar;

/**
 *
 * @author jabue
 */
public class Bucles0201_Tabla_de_multiplicar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero;

        numero = (int) (Math.random() * 10 + 1);
        System.out.println("Tabla de Multiplicar de: " + numero);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%3d x%3d = %3d \n", numero,i,numero*i);
            
        }

    }

}
