/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuraslineales;

/**
 *
 * @author pabvazrui
 */
public class EstructurasLineales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaInt listaOriginal = new ListaInt();
        listaOriginal.addItem(10);
        listaOriginal.addItem(20);
        listaOriginal.addItem(30);
        
        
        System.out.println("Lista Original (Simple): " + listaOriginal);

        ListaIntDobleEnlazada listaDobleOrden = new ListaIntDobleEnlazada();
        listaDobleOrden.deListaSimple(listaOriginal);
        System.out.println("Lista Doble (Mismo orden): " + listaDobleOrden);
        
        ListaIntDobleEnlazada listaDobleReversa = new ListaIntDobleEnlazada();
        listaDobleReversa.deListaSimpleReversa(listaOriginal);
        System.out.println("Lista Doble (Orden inverso): " + listaDobleReversa);
       
        
    }
    
}
