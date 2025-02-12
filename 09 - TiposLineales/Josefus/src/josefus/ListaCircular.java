/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package josefus;

/**
 *
 * @author IEUser
 */
public class ListaCircular<Item> {

    private Nodo posicion;
    private int talla;

    private class Nodo {

        private Item dato;
        private Nodo siguiente;

        private Nodo(Item x) {
            this.dato = x;
            this.siguiente = null;
        }

        private Nodo(Item x, Nodo siguiente) {
            this.dato = x;
            this.siguiente = siguiente;
        }

        @Override
        public String toString() {
            return "Nodo{" + "dato=" + dato + '}';
        }
    }

    public ListaCircular() {
        this.posicion = null;
        this.talla = 0;
    }

    public void addItem(Item dato) {
        Nodo nodo = new Nodo(dato);
        if (esVacia()) {
            setPosicion(nodo);
            nodo.siguiente = nodo;
        } else {
            nodo.siguiente = getPosicion();
            ultimoNodo().siguiente = nodo;
        }
        setTalla(getTalla() + 1);
    }

    public String toString() {
        String cadena = "";
        if (esVacia()) {
            cadena = "";
        } else {
            if (getPosicion() == getPosicion().siguiente) {
                cadena = getPosicion().dato.toString();
            } else {
                Nodo aux = getPosicion();
                do {
                    if (!cadena.equals("")) {
                        cadena += ", ";
                    }
                    cadena += aux.dato.toString();
                    aux = aux.siguiente;
                } while (aux != getPosicion());
            }
        }
        return cadena;
    }

    public boolean esVacia() {
        return getPosicion() == null;
    }

    public Nodo ultimoNodo() {
        Nodo aux = getPosicion();
        while (aux.siguiente != getPosicion()) {
            aux = aux.siguiente;
        }
        return aux;
    }

    public Nodo anteriorNodo() {
        Nodo aux = getPosicion();
        //Nodo anterior = null;
        if (!this.esVacia()) {
            while (aux.siguiente != getPosicion()) {
                aux = aux.siguiente;
                //if (aux.siguiente == nodo) {
                  //  anterior = aux;
                    //break;
                //}
            }
        }
        return aux; //anterior;
    }
    
    public void borrarNodo() {
        if (!esVacia()) {
            Nodo aux = anteriorNodo();
            anteriorNodo().siguiente = posicion.siguiente;
            posicion = aux;
            //posicion = posicion.siguiente;  
        }
    }

    public void avanzarPosicion() {
        if (!esVacia()) {
            setPosicion(getPosicion().siguiente);
        }
    }

    /**
     * @return the posicion
     */
    public Nodo getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(Nodo posicion) {
        this.posicion = posicion;
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

}
