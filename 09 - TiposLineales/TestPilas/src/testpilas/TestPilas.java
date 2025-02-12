/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testpilas;

/**
 *
 * @author IEUser
 */
public class TestPilas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pilas pila = new Pilas();
        pila.push("Primer elemento");
        pila.push("Segundo elemento");
        pila.push("tercer elemento");
        System.out.println("Elementos de la Pila");
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        
        System.out.println("");
        
        Colas<String> cola = new Colas<String>();
        cola.encolar("Primer elemento");
        cola.encolar("Segundo elemento");
        cola.encolar("Tercer elemento");
        System.out.println("Elementos de la cola");
        while (!cola.isEmpty()) {
            System.out.println(cola.desencolar());
        }

        System.out.println("");
        
        System.out.println("Elementos de la cola Iterable");
        ColasIterables<String> colaI = new ColasIterables<String>();
        colaI.encolar("Primer elemento");
        colaI.encolar("Segundo elemento");
        colaI.encolar("Tercer elemento");
        for (String s : colaI){
            System.out.println(s);   
        }
    }

}
