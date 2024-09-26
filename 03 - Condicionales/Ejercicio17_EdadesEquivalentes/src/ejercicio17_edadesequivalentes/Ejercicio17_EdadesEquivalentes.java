/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio17_edadesequivalentes;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio17_EdadesEquivalentes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int edad;
        double edadEquivalente;
        String corresponde;

        System.out.println("Introduzca la edad: ");
        edad = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduzca si es un humano (h) o un perro (p): ");
        corresponde = teclado.nextLine();
        if (corresponde.equals("h")) {
            if (edad > 21) {
                edadEquivalente = 2 + (edad - 21) / 4.0;
            } else {
                edadEquivalente = edad / 10.5;
            }
            System.out.println("Equivale a " + edadEquivalente + " de un perro");
        } else {
            if (edad > 2) {
                edadEquivalente = 21 + (edad - 2) * 4.0;
            } else {
                edadEquivalente = edad * 10.5;
            }
            System.out.println("Equivale a " + edadEquivalente + " de un humano");
        }
        
    }

}
