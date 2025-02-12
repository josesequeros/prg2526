/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import java.util.Stack;

/**
 *
 * @author IEUser
 */
public class Pruebas {

    public static void main(String[] args) {
        // Default initialization of Stack
        Stack stack1 = new Stack();
        // Initialization of Stack
        // using Generics
        Stack<String> stack2 = new Stack<String>();
        // pushing the elements
        stack1.push("WelCome");
        stack1.push("To");
        stack1.push("Stacks");
        stack2.push("Bienvenido");
        stack2.push("a");
        stack2.push("Pilas");
        Pila<String> pila1 = new Pila<>();
        Pila<Integer> pila2 = new Pila<>();
        pila1.apilar("Primer elemento");
        pila2.apilar(1);
        // Printing the Stack Elements
        System.out.println(stack1);
        System.out.println(stack2);
        System.out.println(pila1);
        System.out.println(pila2);
    }
}
