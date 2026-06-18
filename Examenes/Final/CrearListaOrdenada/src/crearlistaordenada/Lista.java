/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearlistaordenada;

/**
 *
 * @author ja.buenoseva
 */
public class Lista {

    private NodoInt primero;

    public class NodoInt {

        private int dato;
        private NodoInt siguiente;

        NodoInt(int d) {
            this.dato = d;
            siguiente = null;
        }

        NodoInt(int d, NodoInt s) {
            dato = d;
            siguiente = s;
        }
    }

    public Lista() {
        this.primero = null;
    }

    public void addItem2(int x) {
        primero = new NodoInt(x, primero);
    }

    public void addItem(int x) {
        NodoInt nuevo = new NodoInt(x);
        nuevo.siguiente = primero;
        primero = nuevo;
    }

    public void listar() {
        NodoInt aux = primero;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    public Lista crearListaOrdenada() {
        Lista lo = new Lista();
        NodoInt aux = this.primero;

        while (aux != null) {
            int dato = aux.dato;
            NodoInt nuevo = new NodoInt(dato);

            NodoInt actual = lo.primero;
            // Caso 1: cola vacía o insertar al principio
            if (actual == null || dato < actual.dato) {
                nuevo.siguiente = lo.primero;
                lo.primero = nuevo;
            } else {
                // Caso general: buscar la posición correcta
                while (actual.siguiente != null && actual.siguiente.dato < dato) {
                    actual = actual.siguiente;
                }
                // Insertar el nuevo nodo
                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;
            }
            aux = aux.siguiente;
        }
        return lo;
    }
}
