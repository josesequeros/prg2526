/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testcolaimpresion;

/**
 *
 * @author jabue
 */
public class ColaGenerica<Item> {

    private Nodo primero, ultimo;
    private int talla;

    private class Nodo {

        private Item dato;
        private Nodo siguiente;

        public Nodo() {
            siguiente = null;
            dato = null;
        }

        public Nodo(Item dato) {
            this.dato = dato;
        }

//        public Nodo(Item newDato, Nodo valorSiguiente) {
//            dato = newDato;
//            siguiente = valorSiguiente;
//        }

        public Item getDato() {
            return dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }
    }

    public ColaGenerica() {
        this.primero = null;
    }

    public void encolar(Item nuevoDato) {
        Nodo nuevoNodo = new Nodo(nuevoDato);
        if (this.primero == null) {
            this.primero = nuevoNodo;
        } else {
            this.ultimo.siguiente = nuevoNodo;
        }
        this.ultimo = nuevoNodo;
        talla++;
    }

    public Item desencolar() {
        Item t = null;

        if (this.primero != null) {
            t = this.primero.dato;
            this.primero = this.primero.siguiente;
            if (this.primero == null) {
                this.ultimo = null;
            }
            talla--;
        }

        return t;
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

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public void imprimirCola() {
        //return "ColaGenerica{" + "primero=" + primero + ", ultimo=" + ultimo + ", talla=" + talla + '}';
        System.out.println("Imprimiento cola");
        Nodo aux = this.primero;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    public boolean esVacia() {
        return this.talla == 0;
    }

    public Item primerDato() {
        Item t = null;
        if (!esVacia()) {
            t = this.primero.dato;
        }
        return t;
    }

}
