/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructurasdinamicas;

/**
 *
 * @author 
 */
public class ListaIntEnlazada {

    private NodoInt primero;
    private int talla;

    /**
     * Clase NodoInt: representa un nodo de una secuencia enlazada que tiene un dato de tipo int y 
     * un enlace al nodo siguiente.
     *
     * @author Jose
     * @version 
     */
    class NodoInt {

        int dato;
        NodoInt siguiente;

        /**
         * Crea un nodo con un dato d y sin siguiente.
         *
         * @param d int, el dato del nuevo nodo.
         */
        NodoInt(int d) {
            dato = d;
            siguiente = null;
        }

        /**
         * Crea un nodo con un dato d, enlazado a un nodo ya existente s.
         *
         * @param d int, el dato del nuevo nodo.
         * @param s NodoInt, con el que enlazar el nuevo nodo.
         */
        NodoInt(int d, NodoInt s) {
            dato = d;
            siguiente = s;
        }
    }

    public ListaIntEnlazada() {
        this.primero = null;
        this.talla = 0;
    }

    public ListaIntEnlazada(NodoInt primero, int talla) {
        this.primero = primero;
        this.talla = 1;
    }

    /**
     * @return the primero
     */
    public NodoInt getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(NodoInt primero) {
        this.primero = primero;
    }

    /**
     * @return the talla
     */
    public int getTalla() {
        return talla;
    }

    /**
     * @param talla the talla to set
     */
    public void setTalla(int talla) {
        this.talla = talla;
    }

    @Override
    /**
     * Devuelve un String con los datos de la lista.
     *
     * @return String, los datos de la lista.
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
     * Comprueba si la lista está vacía.
     *
     * @return boolean, true si la lista está vacía y false en caso contrario.
     */
    public boolean esVacia() {
        return (talla == 0);
    }

    /**
     * Encola un nuevo elemento en la lista.
     *
     * @param int x, el elemento a añadir.
     */
    public void add(int x) {
        NodoInt nuevo = new NodoInt(x);
        NodoInt aux = this.primero;

        if (aux != null) {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        } else {
            primero = nuevo;
        }
        talla++;
    }

    static public ListaIntEnlazada fusionComunOrdenada(ListaIntEnlazada lista1, ListaIntEnlazada lista2) {
        ListaIntEnlazada lista = new ListaIntEnlazada();
        // Implementar por el alumno
        
        return lista;
    }

    static public ListaIntEnlazada fusionDiferenciaSimetricaOrdenada(ListaIntEnlazada lista1, ListaIntEnlazada lista2) {
        ListaIntEnlazada lista = new ListaIntEnlazada();
        // Implementar por el alumno

        return lista;
    }
}
