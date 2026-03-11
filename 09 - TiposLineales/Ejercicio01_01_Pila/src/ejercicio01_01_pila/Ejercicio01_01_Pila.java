/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio01_01_pila;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author ja.buenoseva
 */
public class Ejercicio01_01_Pila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Listas pila = new Listas();
        if (pila.empty()) {
            System.out.println("al crear la pila, esta está vacía");
        }
        System.out.println("Añado elementos a la pila");
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.push(6);
        if (pila.empty()) {
            System.out.println("Vacía");
        } else {
            System.out.println("Elementos de la pila");
            pila.listar();
            System.out.println("");
            System.out.println(pila.peek());
        }
        System.out.println("Elemento eliminado de la cima");
        System.out.println(pila.pop());
        System.out.println("elemento de la cima");
        System.out.println(pila.peek());
        System.out.println("Elementos de la pila");
        pila.listar();
        System.out.println("buscar");
        System.out.println(pila.search(1));
    }

}
