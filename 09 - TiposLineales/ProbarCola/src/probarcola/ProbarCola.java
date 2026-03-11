/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package probarcola;

/**
 *
 * @author ja.buenoseva
 */
public class ProbarCola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cola cola = new Cola();
        Cola cola2 = new Cola();

        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.encolar(40);
        cola.verCola();
        System.out.println("cola2");
        cola2.encolar(10);
        cola2.encolar(20);
        cola2.encolar(30);
        cola2.encolar(40);
        cola2.verCola();
        
        System.out.println(cola);
        

        if (cola.equals(cola2)) {
            System.out.println("iguales");
        }

    }

}
