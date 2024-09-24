/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio08;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int horas, minutos, segundos;

        System.out.print("Introduce las horas: ");
        horas = entrada.nextInt();

        System.out.print("Introduce los minutos: ");
        minutos = entrada.nextInt();

        System.out.print("Introduce los segundos: ");
        segundos = entrada.nextInt();

        if (segundos == 59) {
            segundos = 0;
            if (minutos == 59) {
                minutos = 0;

                if (horas == 23) {
                    horas = 0;
                } else {
                    horas++;
                }
            } else {
                minutos++;
            }
        } else {
            segundos++;
        }
        System.out.println("Son las " + horas + ":" + minutos + ":" + segundos);
    }

}
