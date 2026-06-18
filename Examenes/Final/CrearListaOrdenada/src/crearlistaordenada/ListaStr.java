/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearlistaordenada;

/**
 *
 * @author ja.buenoseva
 */
public class ListaStr {

    private NodoStr primero;

    public class NodoStr {

        private String dato;
        private NodoStr siguiente;

        NodoStr(String d) {
            this.dato = d;
            siguiente = null;
        }

        NodoStr(String d, NodoStr s) {
            dato = d;
            siguiente = s;
        }
    }

    public ListaStr() {
        this.primero = null;
    }

    public void addItem2(String x) {
        primero = new NodoStr(x, primero);
    }

    public void addItem(String x) {
        NodoStr nuevo = new NodoStr(x);
        nuevo.siguiente = primero;
        primero = nuevo;
    }

    public void listar() {
        NodoStr aux = primero;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    public ListaStr crearListaOrdenada() {
        ListaStr lo = new ListaStr();
        NodoStr aux = this.primero;

        while (aux != null) {
            String dato = aux.dato;
            NodoStr nuevo = new NodoStr(dato);

            NodoStr actual = lo.primero;
            // Caso 1: cola vacía o insertar al principio
            if (actual == null || dato.compareTo(actual.dato) < 0) {
                nuevo.siguiente = lo.primero;
                lo.primero = nuevo;
            } else {
                // Caso general: buscar la posición correcta
                while (actual.siguiente != null && actual.siguiente.dato.compareTo(dato) < 0) {
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
