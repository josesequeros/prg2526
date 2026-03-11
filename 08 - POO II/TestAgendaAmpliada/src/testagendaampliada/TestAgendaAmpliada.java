/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testagendaampliada;

import java.util.ArrayList;

/**
 *
 * @author ja.buenoseva
 */
public class TestAgendaAmpliada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Contacto c1 = new Contacto("Jose", "123 456 789");
        System.out.println(c1.getNombre());
        c1.imprimirContacto();

        Agenda miAgenda = new Agenda();
        miAgenda.añadirContacto(c1);
        c1 = new Contacto("Pepe", "telefono de pepe");
        Contacto c2 = new Contacto("Ana", "223344");
        miAgenda.añadirContacto(c1);
        miAgenda.añadirContacto(c2);
        
        //System.out.println(miAgenda);
        
        System.out.println("");
        miAgenda.listarContactos();

        if (miAgenda.existeContacto("Ana")) {
            System.out.println("existe");
        } else {
            System.out.println("No existe");
        }
        
        System.out.println(miAgenda.buscaContacto("Ana MAra"));
        
        
        boolean resultado = miAgenda.eliminarContacto("Ana");
        System.out.println(resultado);
    }

    
}
