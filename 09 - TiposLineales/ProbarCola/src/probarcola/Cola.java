/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package probarcola;

import java.util.Objects;

/**
 *
 * @author ja.buenoseva
 */
public class Cola {

    private NodoInt primero, ultimo;
    int talla;

    class NodoInt {

        int dato;
        NodoInt siguiente;

        /**
         * Crea un nodo con un dato de tipo int sin enlazar.
         *
         * @param dato es un int, dato del nuevo nodo.
         */
        NodoInt(int dato) {
            this.dato = dato;
            siguiente = null;
        }

        /**
         * Crea un nodo con un dato dato de tipo int, enlazado a un nodo
         * existente.
         *
         * @param dato int, dato del nuevo nodo.
         * @param nodo NodoInt, con el que enlazar el nuevo nodo.
         */
        NodoInt(int dato, NodoInt nodo) {
            this.dato = dato;
            siguiente = nodo;
        }
    }

    public Cola(NodoInt primero, NodoInt ultimo) {
        this.primero = primero;
        this.ultimo = ultimo;
    }

    public Cola() {
    }

    void encolar(int i) {
        NodoInt nodo = new NodoInt(i);

        if (ultimo == null) {
            primero = nodo;
        } else {
            ultimo.siguiente = nodo;
        }
        ultimo = nodo;
    }

    public void verCola() {
        NodoInt aux;
        aux = this.primero;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cola other = (Cola) obj;
        if (this.talla != other.talla) {
            return false;
        }
        NodoInt aux = this.primero;
        NodoInt aux2 = other.primero;
        while (aux != null) {
            if (aux2.dato != aux.dato) {
                return false;
            } else {
                aux = aux.siguiente;
                aux2 = aux2.siguiente;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        NodoInt aux = this.primero;
        String cadena = "";
        while (aux != null) {
            cadena = cadena + aux.dato + " ";
            aux = aux.siguiente;
        }
        return cadena;
    }

}
