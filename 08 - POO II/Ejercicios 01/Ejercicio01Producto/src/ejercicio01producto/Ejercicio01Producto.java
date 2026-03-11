/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio01producto;

/**
 *
 * @author ja.buenoseva
 */
public class Ejercicio01Producto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaCompra lista = new ListaCompra();
        
        // Creamos 5 instancias de Producto
        Producto m = new Producto("Pan", 6);
        Producto n = new Producto("Leche", 2);
        Producto o = new Producto("Manzanas", 5);
        Producto p = new Producto("Brocoli", 2);
        Producto q = new Producto("Carne", 2);
        
        lista.add(m);
        lista.add(n);
        lista.add(o);
        lista.add(p);
        lista.add(q);
        
        System.out.println("Lista de la compra: lista");
        System.out.println(lista);
        
        lista.imprimirListaCompra();
        
        lista.borrar(1);
        lista.borrar(p);
        lista.imprimirListaCompra();
        
        System.out.println("");
        lista.imprimeLista();
        
        lista.borrarLista();
        lista.imprimirListaCompra();
        lista.imprimeLista();
        
    }
    
}
