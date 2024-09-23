/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlestructurasa2;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class ControlEstructurasA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int deposito = 0;
        int importe = 0;
        int cantidad;
        boolean devolver = false;
        int billetes;
        int numeroBilletes;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Deposito realizado: ");
        deposito = teclado.nextInt();
        System.out.println("Importe final: ");
        importe = teclado.nextInt();
        cantidad = Math.abs(deposito - importe);
        if (deposito > importe) {
            devolver = true;
            System.out.println("Te devuelven: " + cantidad);
        }
        else {
            System.out.println("Te Faltan: " + cantidad);
        }
        
        billetes = 500;
        numeroBilletes = (int) cantidad / billetes;
        cantidad = cantidad % billetes;
        if (numeroBilletes > 0) {
            System.out.println(numeroBilletes + " Billetes de " + billetes);
        }

        billetes = 200;
        numeroBilletes = (int) cantidad / billetes;
        cantidad = cantidad % billetes;
        if (numeroBilletes > 0) {
            System.out.println(numeroBilletes + " Billetes de " + billetes);
        }

        billetes = 100;
        numeroBilletes = (int) cantidad / billetes;
        cantidad = cantidad % billetes;
        if (numeroBilletes > 0) {
            System.out.println(numeroBilletes + " Billetes de " + billetes);
        }

        billetes = 50;
        numeroBilletes = (int) cantidad / billetes;
        cantidad = cantidad % billetes;
        if (numeroBilletes > 0) {
            System.out.println(numeroBilletes + " Billetes de " + billetes);
        }

        billetes = 20;
        numeroBilletes = (int) cantidad / billetes;
        cantidad = cantidad % billetes;
        if (numeroBilletes > 0) {
            System.out.println(numeroBilletes + " Billetes de " + billetes);
        }

        billetes = 10;
        numeroBilletes = (int) cantidad / billetes;
        cantidad = cantidad % billetes;
        if (numeroBilletes > 0) {
            System.out.println(numeroBilletes + " Billetes de " + billetes);
        }

        billetes = 5;
        numeroBilletes = (int) cantidad / billetes;
        cantidad = cantidad % billetes;
        if (numeroBilletes > 0) {
            System.out.println(numeroBilletes + " Billetes de " + billetes);
        }

        billetes = 2;
        numeroBilletes = (int) cantidad / billetes;
        cantidad = cantidad % billetes;
        if (numeroBilletes > 0) {
            System.out.println(numeroBilletes + " Monedas de " + billetes);
        }

        if (cantidad > 0) {
            System.out.println("1 Moneda de 1");
        }
    }

}
