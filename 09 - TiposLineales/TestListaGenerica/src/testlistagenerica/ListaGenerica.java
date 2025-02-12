/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlistagenerica;

/**
 *
 * @author jabue
 */
public class ListaGenerica<Item> {

    private Nodo primero;

    public ListaGenerica() {
        this.primero = null;
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
    
    
    
    private class Nodo {

        private Item dato;
        private Nodo siguiente;

        public Nodo() {
            siguiente = null;
            dato = null;
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
