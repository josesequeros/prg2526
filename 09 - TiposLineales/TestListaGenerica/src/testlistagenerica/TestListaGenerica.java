/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testlistagenerica;

/**
 *
 * @author jabue
 */
public class TestListaGenerica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaGenerica<String> ListaStrings = new ListaGenerica<>();
        ListaStrings.addNodo("Hola");
        ListaStrings.addNodo("Mundo");
        ListaStrings.mostrarLista();
        ListaGenerica<Integer> ListaEnteros = new ListaGenerica<>();
        for (int i = 0; i < 5; i++) {
            ListaEnteros.addNodo(i);
        }
        ListaEnteros.mostrarLista();
    }
}

