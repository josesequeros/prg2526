/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testpilas;

import java.util.Iterator;

/**
 *
 * @author IEUser
 */
public class ColasIterables<Item> implements  Iterable<Item> {

    private Node first;
    private Node last;

    private class Node {

        private Item item;
        private Node next;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }


    }

    public boolean isEmpty() {
        return (first == null);
    }


    public void encolar(Item item) { // Insertar un nuevo nodo al final de la lista
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public Item desencolar() { // Borrar el primer nodo de la lista y devolver el item
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

}
