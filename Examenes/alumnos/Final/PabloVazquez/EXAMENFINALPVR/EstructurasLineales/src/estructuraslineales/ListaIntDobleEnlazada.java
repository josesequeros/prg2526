/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuraslineales;

/**
 *
 * @author pabvazrui
 */
public class ListaIntDobleEnlazada {

    private NodoIntDoble primero;
    private NodoIntDoble ultimo;
    private int talla;

    private class NodoIntDoble {

        int dato;
        NodoIntDoble siguiente;
        NodoIntDoble anterior;

        NodoIntDoble(int d) {
            dato = d;
            siguiente = null;
            anterior = null;
        }
    }

    public void addPrimero(int valor) {
        NodoIntDoble nuevo = new NodoIntDoble(valor);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
        talla++;
    }

    public void addUltimo(int valor) {
        NodoIntDoble nuevo = new NodoIntDoble(valor);
        if (ultimo == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        talla++;
    }
    
    public void deListaSimple(ListaInt listaSimple) {
        primero = null;
        ultimo = null;
        talla = 0;

        ListaInt.NodoInt aux = listaSimple.getPrimero();
        while (aux != null) {
            addUltimo(aux.dato);
            aux = aux.siguiente;
        }
    }

    public void deListaSimpleReversa(ListaInt listaSimple) {
        primero = null;
        ultimo = null;
        talla = 0;

        ListaInt.NodoInt aux = listaSimple.getPrimero();
        while (aux != null) {
            addPrimero(aux.dato); 
            aux = aux.siguiente;
        }
    }

    @Override
    public String toString() {
        if (primero == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        NodoIntDoble aux = primero;
        while (aux != null) {
            sb.append(aux.dato);
            if (aux.siguiente != null) {
                sb.append(", ");
            }
            aux = aux.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}