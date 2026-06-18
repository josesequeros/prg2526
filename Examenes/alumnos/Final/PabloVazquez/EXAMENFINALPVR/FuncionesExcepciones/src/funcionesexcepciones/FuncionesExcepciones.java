/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funcionesexcepciones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pabvazrui
 */
public class FuncionesExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cifras;

        try {
            System.out.print("Introduce el numero de cifras (0-9): ");
            cifras = sc.nextInt();

            if (cifras < 0 || cifras > 9) {
                System.out.println("Debe estar entre 0 y 9.");
                return;
            }

            if (cifras == 0) {
                System.out.println("Fin del programa.");
                return;
            }

            ArrayList<String> lista = generarCapicuas(cifras);

            System.out.println("Cantidad de numeros capicua: " + lista.size());

            if (lista.size() <= 10) {
                for (String num : lista) {
                    System.out.print(num + " ");
                }
            } else {
                for (int i = 0; i < 5; i++) {
                    System.out.print(lista.get(i) + " ");
                }

                System.out.print("... ");
                for (int i = lista.size() - 5; i < lista.size(); i++) {
                    System.out.print(lista.get(i) + " ");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: introduce un numero entero.");
        }

        sc.close();
    }

    public static ArrayList<String> generarCapicuas(int cifras) {
        ArrayList<String> resultado = new ArrayList<>();

        if (cifras == 1) {
            for (int i = 0; i <= 9; i++) {
                resultado.add(String.valueOf(i));
            }
            return resultado;
        }

        int mitad = (cifras + 1) / 2;
        int inicio = (int) Math.pow(10, mitad - 1);
        int fin = (int) Math.pow(10, mitad);

        for (int i = inicio; i < fin; i++) {
            String s = String.valueOf(i);
            String capicua;

            if (cifras % 2 == 0) {
                capicua = s + new StringBuilder(s).reverse();
            } else {
                capicua = s + new StringBuilder(s.substring(0, s.length() - 1)).reverse();
            }

            resultado.add(capicua);
        }

        return resultado;
    }
}
