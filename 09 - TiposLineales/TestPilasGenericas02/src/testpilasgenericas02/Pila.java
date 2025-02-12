/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testpilasgenericas02;

/**
 *
 * @author jabue
 */
public class Pila<Item> {

    private Nodo<Item> cima;
    private int talla;

    public Pila(Nodo<Item> elementoCima) {
        this.cima = elementoCima;
        this.talla = 1;
    }

    public Pila() {
        this.cima = null;
        this.talla = 0;
    }

    /**
     *
     * @param dato
     */
    public void apilar(Item dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.next = this.cima;
        this.cima = nuevo;
        this.talla++;
    }

    public Nodo<Item> getCima() {
        return cima;
    }

    public int getTalla() {
        return talla;
    }

    public boolean vacia() {
        return cima == null;
    }

    public Item peek() {
        if (this.vacia()) {
            return null;
        } else {
            return this.getCima().dato;
        }
    }

    public Item pop() {
        Item dato = null;
        if (this.vacia()) {
            return null;
        } else {
            dato = this.getCima().dato;
            cima = cima.next;
            this.talla--;
        }
        return dato;
    }

    public void mostrar() {
        Nodo<Item> aux = this.cima;
        int j = 1;
        while (aux != null) {
            System.out.println(j++ + " " + aux.dato);
            aux = aux.next;
        }
    }
    
    public int search(Nodo<Item> elemento) {
        int posicion = 0;
        Nodo<Item> aux = this.cima;
        while (aux!=null ) {
            posicion++;
            if (aux.dato.equals(elemento.dato)) {
                return posicion;
            }
            aux = aux.next;
        }
        return -1;
    }
        public int search(Item elemento) {
        int posicion = -1;
        Nodo<Item> aux = this.cima;
        while (aux!=null ) {
            posicion++;
            if (aux.dato.equals(elemento)) {
                return posicion;
            }
            aux = aux.next;
        }
        return -1;
    }
}
