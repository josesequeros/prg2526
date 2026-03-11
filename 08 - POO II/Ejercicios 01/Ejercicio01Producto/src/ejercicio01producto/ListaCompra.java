/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio01producto;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ja.buenoseva
 */
public class ListaCompra {

    private ArrayList<Producto> listaCompra;

    public ListaCompra() {
        this.listaCompra = new ArrayList<>();
    }

    /**
     * @return the listaCompra
     */
    public ArrayList<Producto> getListaCompra() {
        return listaCompra;
    }

    /**
     * @param listaCompra the listaCompra to set
     */
    public void setListaCompra(ArrayList<Producto> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public void add(Producto producto) {
        this.listaCompra.add(producto);
    }

    public void borrar(Producto producto) {
        this.listaCompra.remove(producto);
    }

    public void borrar(int n) {
        this.listaCompra.remove(n);
    }

    @Override
    public String toString() {
        return "ListaCompra{" + "listaCompra=" + listaCompra + '}';
    }

    public void imprimirListaCompra() {
        System.out.println("Imprimiendo lista");
        for (Producto producto : listaCompra) {
            System.out.println("\t" + producto.getNombre());
        }
    }

    public void imprimeLista() {
        System.out.println("LISTA DE PRODUCTOS CON " + listaCompra.size() + " ELEMENTOS");
        Iterator<Producto> it = listaCompra.iterator();
        while (it.hasNext()) {
        //for (Iterator<Producto> it = listaCompra.iterator(); it.hasNext();) {
            Producto p = it.next();
            System.out.println(p.getNombre() + ": " + p.getCantidad());
        }
        System.out.println("");
    }
    
    public void borrarLista() {
        this.listaCompra.clear();
    }
}
