/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package josefusdeque;

/**
 *
 * @author IEUser
 */
public class Deque<Item> {

    private Nodo primero;
    private Nodo ultimo;
    private Nodo posicion;

    void borrarNodo() {
        //System.out.println(posicion.dato);
        //this.mostrarPila();
        if (this.posicion!=null) {
            posicion.siguiente.previo=posicion.previo;
            posicion.previo.siguiente = posicion.siguiente;
        }
    }

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
        posicion=null;
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
            } while (aux != null);
            System.out.println("");
        }
    }

    public void mostrarPila() {
        Nodo aux = ultimo;
        if (aux != null) {
            do {
                System.out.print(aux.dato + " -> ");
                aux = aux.previo;
            } while (aux != null);
            System.out.println("");
        }
    }

    public int size() {
        int n = 0;
        Nodo aux = ultimo;

        if (aux != null) {
            do {
                aux = aux.previo;
                n++;
            } while (aux != null);

        }
        return n;
    }

    public void remove(Nodo nodo) {
        Nodo aux = ultimo;

        if (aux != null) {
            do {
                if (aux == nodo) {

                }
                aux = aux.previo;
            } while (aux != null);

        }
    }

    public void avanzarPosicion() {
        if (!this.isEmpty()) {
            setPosicion(getPosicion().siguiente);
        }
    }

    public Nodo getPrimero() {
        return primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public Nodo getPosicion() {
        return posicion;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public void setPosicion(Nodo posicion) {
        this.posicion = posicion;
    }
    
}
