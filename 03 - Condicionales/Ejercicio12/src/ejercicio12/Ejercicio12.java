/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio12;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int dia,mes,year;
        int diasFebrero = 28;
        int maximoDias;
        
        System.out.println("Introduza el día: ");
        dia = teclado.nextInt();
        System.out.println("Introduza el mes: ");
        mes = teclado.nextInt();
        System.out.println("Introduza el año: ");
        year = teclado.nextInt();
        
        if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
            System.out.println("Datos no v�lidos");
        }
        else {
            if (year %4 == 0 && year % 100 != 0 || year % 400 == 0) {
                diasFebrero = 29;
            }
            /*
            if (mes == 2) {
            maximoDias = diasFebrero;
            }
            else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            maximoDias = 30;
            }
            else {
            maximoDias = 31;
            }
            
            switch (mes) {
                case 2:
                    maximoDias = diasFebrero;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    maximoDias = 30;
                    break;
                default:
                    maximoDias = 31;
                    break;
            }
             */
            maximoDias = switch (mes) {
                case 2 -> diasFebrero;
                case 4, 6, 9, 11 -> 30;
                default -> 31;
            };
            if (dia <= maximoDias) {
                System.out.println("Los datos forman una fecha correcta");
            }
            else {
                System.out.println("Con esos datos no se puede formar una fecha correcta");
            }
        }
    }
    
}
