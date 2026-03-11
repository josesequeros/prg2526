/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio01_01_pila;

/**
 *
 * @author ja.buenoseva
 */
public class PilaComoLista {

    /**
     * Clase Listas: Lista de int. Implementación enlazada.
     *
     * @author
     * @version
     */
    private NodoInt primero;

    private class NodoInt {

        private int dato;
        private NodoInt siguiente;

        private NodoInt(int x, NodoInt nodo) {
            this.dato = x;
            this.siguiente = nodo;
        }
    }
    
    
}
