/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema06funcionesejerciciosadicionales01;

import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class Ejercicio07 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int num1 = entrada.nextInt();
        System.out.print("Introduce el segundo número: ");
        int num2 = entrada.nextInt();

        System.out.println(num1 + " En Binario es: " + cambioBase(2, num1));
        System.out.println(num1 + " En Octal es: " + cambioBase(8, num1));
        System.out.println(num1 + " En Hexadecimal es: " + cambioBase(16, num1));
        System.out.println("");
        System.out.println("El número Decimal: " + num2 + " es: ");
        System.out.println(" En Binario es: " + cambioBase(2, num2));
        System.out.println(" En Octal es: " + cambioBase(8, num2));
        System.out.println(" En Hexadecimal es: " + cambioBase(16, num2));
        System.out.println("");

    }

    public static String cambioBase(int base, int numero) {
        String simbolos = "0123456789ABCDEF";
        String resultado = "";
        int posicion = 0;
        while (numero > (base-1)) {
            posicion = numero % base;
            resultado = simbolos.charAt(posicion) + resultado;
            numero = (int) numero / base;
        }
        
        resultado = simbolos.charAt(numero) + resultado;
        return resultado;
    }

}
