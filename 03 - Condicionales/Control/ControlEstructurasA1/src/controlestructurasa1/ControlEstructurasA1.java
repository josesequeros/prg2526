/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlestructurasa1;

import java.util.Scanner;

/**
 *
 * @author jossev
 */
public class ControlEstructurasA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        String tipoCarnet;
        int numeroPrácticas;
        int numeroExamen;
        int importeMatricula = 0;
        int importePracticas = 0;
        double recargo;
        int porcentaje = 0;
        double total;
        boolean valido = true;

        System.out.println("Tipo de Carnet: ");
        tipoCarnet = teclado.nextLine();
        System.out.println("Total de prácticas realizadas: ");
        numeroPrácticas = teclado.nextInt();
        System.out.println("Número de Examen: ");
        numeroExamen = teclado.nextInt();

        /*
        if (tipoCarnet.equals("a")) {
            importeMatricula = 200;
            importePracticas = 20 * numeroPrácticas;
            porcentaje = 10;
        } else if (tipoCarnet.equals("b")) {
            importeMatricula = 300;
            importePracticas = 30 * numeroPrácticas;
            porcentaje = 15;
        } else if (tipoCarnet.equals("c")) {
            importeMatricula = 400;
            importePracticas = 40 * numeroPrácticas;
            porcentaje = 20;
        } else if (tipoCarnet.equals("d")) {
            importeMatricula = 500;
            importePracticas = 50 * numeroPrácticas;
            porcentaje = 25;
        } else {
            System.out.println("Tipo de carnet no valido");
            valido = false;
        }
        */
        switch (tipoCarnet) {
            case "a":
                importeMatricula = 200;
                importePracticas = 20 * numeroPrácticas;
                porcentaje = 10;
                break;
            case "b":
                importeMatricula = 300;
                importePracticas = 30 * numeroPrácticas;
                porcentaje = 15;
                break;
            case "c":
                importeMatricula = 400;
                importePracticas = 40 * numeroPrácticas;
                porcentaje = 20;
                break;
            case "d":
                importeMatricula = 500;
                importePracticas = 50 * numeroPrácticas;
                porcentaje = 25;
                break;
            default:
                System.out.println("Tipo de carnet no valido");
                valido = false;
                break;
        }
        if (valido) {
            recargo = importeMatricula * ((numeroExamen - 1) * porcentaje / 100.0);
            total = importeMatricula + importePracticas + recargo;
            System.out.println("Importe Matrícula: ");
            System.out.println(importeMatricula);
            System.out.println("Importe recargo por " + numeroExamen + " examen");
            System.out.println(recargo);
            System.out.println("Importe Prácticas: " + importePracticas);
            System.out.println("Total: ");
            System.out.println(total);
        }
    }
}
