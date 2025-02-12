/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlistas01;

/**
 *
 * @author jabue
 */
public class Listas {

    /**
     * Clase Listas: Lista de int. Implementación enlazada.
     *
     * @author
     * @version
     */
    private NodoInt primero;
    private int talla;



    /**
     * Crea una lista vacía.
     */
    public Listas() {
        primero = null;
        talla = 0;
    }

    /**
     * Añade x a la lista
     *
     * @param int x, el valor a añadir.
     */
    public void addItem(int x) {
        primero = new NodoInt(x, primero);
        talla++;
    }
    
    public void listar() {
        NodoInt aux = primero;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }    
}
