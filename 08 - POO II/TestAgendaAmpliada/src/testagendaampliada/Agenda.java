/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testagendaampliada;

import java.util.ArrayList;

/**
 *
 * @author ja.buenoseva
 */
public class Agenda {

    private ArrayList<Contacto> agenda;

    public Agenda() {
        agenda = new ArrayList<>();
    }

    public boolean añadirContacto(Contacto c) {
        agenda.add(c);
        return true;
    }

    @Override
    public String toString() {
        return "Agenda{" + "agenda=" + agenda + '}';
    }

    public void listarContactos() {
        System.out.println("-- Nombre --      --- Telefono ---");
        for (Contacto contacto : agenda) {
            contacto.imprimirContacto();
        }
        /*    
        for (int i = 0; i < agenda.size(); i++) {
            agenda.get(i).imprimirContacto();
        }
         */
    }

    public boolean existeContacto(String s) {
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public int buscaContacto(String s) {
        int posicion = -1;

        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).getNombre().equals(s)) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public boolean eliminarContacto(String s) {
        boolean posible = false;
        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).getNombre().equals(s)) {
                agenda.remove(i);
                posible = true;
                break;
            }
        }
        return posible;
    }
}
