/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crearlistaordenada;

/**
 *
 * @author ja.buenoseva
 */
public class CrearListaOrdenada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista lista = new Lista();
        lista.addItem(1);
        lista.addItem(2);
        lista.addItem(3);
        lista.addItem(30);
        lista.addItem(23);
        lista.addItem(10);
        lista.addItem(5);
        lista.addItem(13);
        lista.listar();

        Lista lo = lista.crearListaOrdenada();
        lo.listar();
        
        ListaStr ls = new ListaStr();
        ls.addItem("En");
        ls.addItem("un");
        ls.addItem("lugar");
        ls.addItem("de");
        ls.addItem("la");
        ls.addItem("mancha");
        ls.listar();
        
        ListaStr lso = ls.crearListaOrdenada();
        lso.listar();
    }

}
