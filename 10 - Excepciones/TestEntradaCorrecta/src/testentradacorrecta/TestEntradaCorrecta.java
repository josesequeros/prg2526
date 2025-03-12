/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testentradacorrecta;

import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author IEUser
 */
public class TestEntradaCorrecta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int minimo = 10;
        int maximo = 20;

        Scanner teclado = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Introduce un número Real:");
        Double valor = utilidades.EntradaCorrecta.nextDouble(teclado, "Valor Real: ");
        System.out.println("Valor Doble:" + valor);

        System.out.println("Introduce un número Real Positivo:");
        Double valorPositivo = utilidades.EntradaCorrecta.nextDoublePositive(teclado, "Valor Real Positivo: ");
        System.out.println("Valor Doble Positivo:" + valorPositivo);

        System.out.println("Introduce un número Real Entero entre Positivo:");
        int valorEntero = utilidades.EntradaCorrecta.nextInt(teclado, "Valor entero entre " + minimo + " y " + maximo + ": ", minimo, maximo);
        System.out.println(valorEntero + " Es un Valor entero entre " + minimo + " y " + maximo);
    }

}
