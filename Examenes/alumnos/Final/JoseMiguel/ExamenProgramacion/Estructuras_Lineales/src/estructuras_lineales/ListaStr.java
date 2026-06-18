/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras_lineales;

/**
 *
 * @author josgimgar3
 */
public class ListaStr {

    NodoStr primero;

    public ListaStr() {
        this.primero = null;
    }

    public void addItem(int x) {
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

    public NodoStr getPrimero() {
        return primero;
    }

    public void setPrimero(NodoStr primero) {
        this.primero = primero;
    }

    NodoStr g() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
