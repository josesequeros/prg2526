/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex01;

/**
 *
 * @author ja.buenoseva
 */
public class Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean multiplos3, multiplos5;
        int mayor = 0;
        int menor = 0;
        int cifrasMenor;
        int numero1, numero2;
        //do {
        numero1 = (int) (Math.random() * 201);
        numero2 = (int) (Math.random() * 201);

        System.out.println("El numero1 = " + numero1);
        System.out.println("El numero2 = " + numero2);

        if (numero1 > numero2) {
            mayor = numero1;
            menor = numero2;
        } else {
            mayor = numero2;
            menor = numero1;
        }
        System.out.println("1) El mayor es: " + mayor);

        multiplos3 = numero1 % 3 == 0 && numero2 % 3 == 0;
        multiplos5 = numero1 % 5 == 0 && numero2 % 5 == 0;

        //} while (!(multiplos5 && multiplos3));
        if (multiplos3 && multiplos5) {
            System.out.println("4) ambos son multiplos de 3 y de 5");
        } else {
            if (multiplos3) {
                System.out.println("2) ambos son multiplos de 3");
            } else if (multiplos5) {
                System.out.println("3) ambos son multiplos de 5");
            }
        }

        int cifras = 1;
        int aux = menor;
        while (aux / 10 > 0) {
            aux = aux / 10;
            cifras++;
        }
        System.out.println("5) Total de cifras del numero menor: " + cifras);
        int cociente = mayor / menor;
        if (cociente % 2 == 0) {
            System.out.println("6)el cociente de la división entera del número mas grande entre el número mas pequeño es par: " + cociente);
        }
        System.out.println("7) Multiplos comunes");
        for (int i = 1; i < menor; i++) {
            //boolean multiplo = menor % i == 0;
            //if (multiplo) {
            if (menor % i == 0 && mayor % i == 0) {
                System.out.print("\t" + i);
            }
            //}
        }
        System.out.println("");
    }

}
