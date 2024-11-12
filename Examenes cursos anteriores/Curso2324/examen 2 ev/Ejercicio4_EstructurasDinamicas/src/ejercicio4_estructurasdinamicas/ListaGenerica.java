/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4_estructurasdinamicas;

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

    public boolean listaOrdenadaDescendente() {
        if (this.primero == null || this.primero.siguiente == null) {
            return true;
        } else {
            Nodo anterior = primero;
            Nodo aux = primero.siguiente;
            while (aux != null && ((String) anterior.dato).compareTo((String) aux.dato) >= 0) {
                anterior = aux;
                aux = aux.siguiente;
            }
            return aux == null;
        }
    }

    public void eliminarDuplicadosListaOrdenada() {
        if (this.listaOrdenadaDescendente()) {
            if (!(this.primero == null || this.primero.siguiente == null)) {
                Nodo anterior = primero;
                Nodo aux = primero.siguiente;
                while (aux != null) {
                    while (aux != null && anterior.dato.equals(aux.dato)) {
                        aux = aux.siguiente;
                        anterior.siguiente = aux;
                    }
                    anterior = aux;
                    if (aux != null) {
                        aux = aux.siguiente;
                    }
                }
            }
        } else {
            System.out.println("Lista No ordenada");
        }
    }
    
        public void eliminarDuplicadosListaOrdenada2() {
        if (this.listaOrdenadaDescendente()) {
            if (!(this.primero == null || this.primero.siguiente == null)) {
                Nodo anterior = primero;
                Nodo aux = primero;
                while (anterior != null) {
                    aux = aux.siguiente;
                    while (aux != null && anterior.dato.equals(aux.dato)) {
                        aux = aux.siguiente;
                        anterior.siguiente = aux;
                    }
                    anterior = aux;
                }
            }
        } else {
            System.out.println("Lista No ordenada");
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
