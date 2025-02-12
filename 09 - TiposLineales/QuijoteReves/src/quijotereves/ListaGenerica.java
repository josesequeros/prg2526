/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quijotereves;

import java.util.NoSuchElementException;

/**
 *
 * @author jabue
 */
public class ListaGenerica<Item> {

    private Nodo primero;
    private Nodo ultimo;
    private int talla;

    public ListaGenerica() {
        this.primero = null;
        this.ultimo = null;
        this.talla = 0;
    }

    public void encolar(Item x) {
        Nodo nuevo = new Nodo(x);
        if (ultimo != null) {
            ultimo.siguiente = nuevo;
        } else {
            primero = nuevo;
        }
        ultimo = nuevo;
        talla++;
    }

    public Item desencolar() {
        if (talla == 0) {
            throw new NoSuchElementException("Cola vacía");
        }
        Item x = primero.dato;
        primero = primero.siguiente;
        if (primero == null) {
            ultimo = null;
        }
        talla--;
        return x;
    }

    public void addNodo(Item nuevoDato) {
        Nodo nuevoNodo = new Nodo(nuevoDato, this.primero);
        this.primero = nuevoNodo;
    }

    public void mostrarLista() {
        Nodo aux = this.primero;
        while (aux != null) {
            /*
            System.out.println(aux.dato);
            aux = aux.siguiente;
             */
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    public Item primero() {
        if (talla == 0) {
            throw new NoSuchElementException("Cola vacía");
        }
        return primero.dato;

    }

    private class Nodo {

        private Item dato;
        private Nodo siguiente;

        public Nodo() {
            siguiente = null;
            dato = null;
        }

        public Nodo(Item d) {
            siguiente = null;
            dato = d;
        }

        public Nodo(Item newDato, Nodo valorSiguiente) {
            dato = newDato;
            siguiente = valorSiguiente;
        }

        public Item getDato() {
            return dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }
    }
}
