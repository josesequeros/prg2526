/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testpilas;

/**
 *
 * @author IEUser
 */
public class Pilas {

    private Node first;

    private class Node {
        private String item;
        private Node next;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void push(String item) { // Insertar un nuevo nodo al comienzo de la Pila
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() { // Borra el primer nodo de la lista y devuelve el item
        String item = first.item;
        first = first.next;
        return item;
    }

    
}
