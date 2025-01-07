/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner sc = new Scanner(System.in);

        CuentaBancaria cuenta;
        
        // Pedimos datos y creamos la cuenta. Repetimos mientras no sea válida
        do {
            System.out.print("Introduzca numero IBAN: ");
            String iban = sc.nextLine();
            System.out.print("Introduzca titular de cuenta: ");
            String titular = sc.nextLine();
            cuenta = new CuentaBancaria(iban, titular);
            
        } while (!cuenta.getValida());

        int opcion;
        double cantidad;

        do {
            limpiar();
            System.out.println("Elija una opción");
            System.out.println("1. Datos de la cuenta.");
            System.out.println("2. IBAN.");
            System.out.println("3. Titular.");
            System.out.println("4. Saldo.");
            System.out.println("5. Ingreso.");
            System.out.println("6. Retirada.");
            System.out.println("7. Movimientos.");
            System.out.println("8. Salir.");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cuenta.imprimirDatos();
                    break;
                case 2:
                    System.out.println("IBAN: " + cuenta.getIban());
                    break;
                case 3:
                    System.out.println("Titular: " + cuenta.getTitular());
                    break;
                case 4:
                    System.out.println("Saldo: " + cuenta.getSaldo());
                    break;
                case 5:
                    System.out.print("Inserte cantidad a ingresar: ");
                    cantidad = sc.nextDouble();
                    if (cuenta.ingresar(cantidad)) {
                        System.out.println("Ingreso: OK");
                    } else {
                        System.out.println("Ingreso: ERROR");
                    }
                    break;
                case 6:
                    System.out.print("Inserte cantidad a retirar:");
                    cantidad = sc.nextDouble();
                    if (cuenta.retirar(cantidad)) {
                        System.out.println("Retirada: OK");
                    } else {
                        System.out.println("Retirada: ERROR");
                    }
                    break;
                case 7:
                    cuenta.imprimirMovimientos();
                    break;
                case 8:
                    System.out.println("GRACIAS POR USAR NUESTRA APLICACION");
                    break;
                default:
                    System.out.println("Opción elegida incorrecta.");
                    break;
            }
        } while (opcion != 8);

        sc.close();
    }
    
    public static void limpiar() {
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }
}
