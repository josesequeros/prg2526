/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio09;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);

        String nombre;
        int horas;
        double tarifa, salario, impuesto, salarioNeto;

        impuesto = 0;

        System.out.print("Introduce el nombre: ");
        nombre = entrada.nextLine();

        System.out.print("Introduce las horas trabajadas: ");
        horas = entrada.nextInt();

        System.out.print("Introduce el precio de la tarifa normal: ");
        tarifa = entrada.nextDouble();

        if (horas <= 35) {
            salario = horas * tarifa;
        } else {
            salario = 35 * tarifa + (horas - 35) * 1.5;
        }

        if (salario > 900) {
            impuesto = (400 * 0.25) + (salario - 900) * 0.45;
        } else if (salario > 500) {
            impuesto = (salario - 500) * 0.25;
        }

        salarioNeto = salario - impuesto;

        System.out.println("Informe del empleado " + nombre + ":");
        System.out.println("Salario bruto: " + salario + "€");
        System.out.println("Salario neto: " + salarioNeto + "€");
        System.out.println("Impuestos: " + impuesto + "€");
    }

}
