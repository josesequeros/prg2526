/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4_estructurasdinamicas;

/**
 *
 * @author jabue
 */
public class Ejercicio4_EstructurasDinamicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaGenerica<String> listaStrings = new ListaGenerica<>();
        listaStrings.addNodo("agua");
        //listaStrings.addNodo("agua");
        listaStrings.addNodo("barco");
        listaStrings.addNodo("dedal");
        listaStrings.addNodo("dedal");
        listaStrings.addNodo("dedal");
        listaStrings.addNodo("huerta");
        listaStrings.addNodo("kilo");
        listaStrings.addNodo("kilo");
        listaStrings.addNodo("kilo");
        listaStrings.addNodo("kilo");
        //listaStrings.mostrarLista();
        if (listaStrings.listaOrdenadaDescendente()) {
            System.out.println("La lista esta ordenada decendentemente");
        }
        else {
            System.out.println("Lista no esta ordenada");
        }
        listaStrings.eliminarDuplicadosListaOrdenada2();
        listaStrings.mostrarLista();
    }
    
}
