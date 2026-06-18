/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras_lineales;

/**
 *
 * @author josgimgar3
 */
public class NodoStr {

   public int dato;
   public NodoStr siguiente;

    NodoStr(int d) {
        this.dato = d;
        siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public NodoStr getSiguiente() {
        return siguiente;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoStr siguiente) {
        this.siguiente = siguiente;
    }

}
