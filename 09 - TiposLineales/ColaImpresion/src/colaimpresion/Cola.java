/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colaimpresion;

import java.util.NoSuchElementException;

/**
 * Clase Colas: Cola de int. Implementación enlazada.
 *
 * @author
 * @version
 */
public class Cola {

    private NodoInt primero, ultimo;
    private int talla;

    /**
     * Crea una cola vacía.
     */
    public Cola() {
        primero = null;
        ultimo = null;
        talla = 0;
    }

    /**
     * Encola un nuevo elemento en la cola.
     *
     * @param int x, el elemento a encolar.
     */
    public void encolar(int x) {
        NodoInt nuevo = new NodoInt(x);
        if (ultimo != null) {
            ultimo.siguiente = nuevo;
        } else {
            primero = nuevo;
        }
        ultimo = nuevo;
        talla++;
    }

    /**
     * Desencola y devuelve el primer elemento de la cola.
     *
     * @return int, la cabeza de la cola antes de desencolar.
     * @throws NoSuchElementException si la cola está vacía.
     */
    public int desencolar() {
        if (talla == 0) {
            throw new NoSuchElementException("Cola vacía");
        }
        int x = primero.dato;
        primero = primero.siguiente;
        if (primero == null) {
            ultimo = null;
        }
        talla--;
        return x;
    }

    /**
     * Devuelve el primer elemento de la cola.
     *
     * @return int, la cabeza de la cola.
     * @throws NoSuchElementException si la cola está vacía.
     */
    public int primero() {
        if (talla == 0) {
            throw new NoSuchElementException("Cola vacía");
        }
        return primero.dato;
    }

    /**
     * Comprueba si la cola está vacía.
     *
     * @return boolean, true si la cola está vacía y false en caso contrario.
     */
    public boolean esVacia() {
        return (talla == 0);
    }

    /**
     * Devuelve la talla de la cola.
     *
     * @return int, la talla.
     */
    public int talla() {
        return talla;
    }

    /**
     * Devuelve un String con los datos de la cola.
     *
     * @return String, los datos de la cola.
     */
    public String toString() {
        String s = "";
        NodoInt aux = primero;
        while (aux != null) {
            s += String.format("%4d", aux.dato);
            aux = aux.siguiente;
        }
        return s;
    }

    /**
     * Comprueba si la cola es igual o no a una cola dada.
     *
     * @param o Object, la cola a comparar.
     * @return boolean, true si son iguales y false en caso contrario.
     */
    public boolean equals(Object o) {
        boolean igual = false;
        if (o instanceof Cola) {
            Cola c = (Cola) o;
            if (talla == c.talla) {
                NodoInt aux = primero, auxC = c.primero;
                while (aux != null && aux.dato == auxC.dato) {
                    aux = aux.siguiente;
                    auxC = auxC.siguiente;
                }
                if (aux == null) {
                    igual = true;
                }
            }
        }
        return igual;
    }

    public void verCola() {
        NodoInt aux = this.primero;
        System.out.println("Trabajos en Cola de Impresión:");
        while (aux != null) {
            System.out.println("Trabajo: " + aux.dato);
            aux = aux.siguiente;
        }

    }

}
