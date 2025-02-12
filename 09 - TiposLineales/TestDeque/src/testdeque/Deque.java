/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdeque;

/**
 *
 * @author IEUser
 */
public class Deque<Item> {

    private Nodo primero;
    private Nodo ultimo;

    private class Nodo {

        private Item dato;
        private Nodo siguiente;
        private Nodo previo;

        public Nodo(Item x) {
            dato = x;
            siguiente = null;
            previo = null;
        }
    }

    /**
     *
     */
    public Deque() {
        primero = null;
        ultimo = null;
    }

    public Deque(Nodo cabeza, Nodo cola) {
        this.primero = cabeza;
        this.ultimo = cola;
    }

    public boolean isEmpty() {
        return primero == null && ultimo == null;
    }

    public void addFirst(Item item) {   // push
        Nodo nuevo = new Nodo(item);
        if (isEmpty()) {
            ultimo = nuevo;
        } else {
            primero.previo = nuevo;
            nuevo.siguiente = primero;
        }
        primero = nuevo;
    }

    public void addLast(Item item) {    // enqueue
        Nodo nuevo = new Nodo(item);
        if (isEmpty()) {
            primero = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.previo = ultimo;
        }
        ultimo = nuevo;
    }

    public Item getFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Nodo aux = primero;
            if (primero == ultimo) {
                primero = null;
                ultimo = null;
            } else {
                primero = primero.siguiente;
            }
            return aux.dato;
        }
    }

    public Item getLast() {
        if (isEmpty()) {
            return null;
        } else {
            Nodo aux = ultimo;
            if (primero == ultimo) {
                primero = null;
                ultimo = null;
            } else {
                ultimo = ultimo.previo;
                ultimo.siguiente = null;
            }
            return aux.dato;
        }
    }

    public void mostrarCola() {
        Nodo aux = primero;
        if (aux != null) {
            do {
                System.out.print(aux.dato + " -> ");
                aux = aux.siguiente;
            } while (aux != null) ;
            System.out.println("");
        }
    }
    
    public void mostrarPila() {
        Nodo aux = ultimo;
        if (aux != null) {
            do {
                System.out.print(aux.dato + " -> ");
                aux = aux.previo;
            } while (aux != null) ;
            System.out.println("");
        }
    }
    
    
}
