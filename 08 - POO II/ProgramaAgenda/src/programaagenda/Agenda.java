/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaagenda;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author IEUser
 */
public class Agenda {

    private ArrayList contactos;

    public Agenda() {
        this.contactos = new ArrayList();
    }

    public int posicionContacto(String nombre) {
        int posicion = -1;

        for (int i = 0; i < this.contactos.size(); i++) {
            if (((Contacto) this.contactos.get(i)).getNombre().equals(nombre)) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public boolean existeContacto(String nombre) {
        return posicionContacto(nombre) >= 0;
        /*
        Contacto contact;
        for (int i = 0; i < this.contactos.size(); i++) {
            contact = (Contacto) this.contactos.get(i);
            if (contact.getNombre().equals(nombre)) {
                existe = true;
            }
        }
        return existe;
        */
    }

    public Contacto buscarContacto(String nombre) {
        Contacto contacto;
        contacto = null;//new Contacto("","");
        int i = posicionContacto(nombre);
        if (i >= 0) {
            contacto = (Contacto) this.contactos.get(i);
        }
        return contacto;
        /*
        for (int i = 0; i < this.contactos.size(); i++) {
            if (((Contacto) this.contactos.get(i)).getNombre().equals(nombre)) {
                contacto = (Contacto) this.contactos.get(i);
                break;
            }
        }
        return contacto;
        */
    }

    public boolean addContactos(Contacto c) {
        boolean ok = false;
        if (!existeContacto(c.getNombre())) {
            this.contactos.add(c);
            ok = true;
        }
        return ok;
    }

    public void listarContactos() {
        Iterator iter = this.contactos.iterator();
        System.out.println("");
        System.out.println("Contenido de la Agenda");
        while (iter.hasNext()) {  // Recorremos mientras hayan elementos
            System.out.println(iter.next()); // Lo imprimimos por pantalla
        }
        System.out.println("");
        /*
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println(contactos.get(i)); // Lo imprimimos por pantalla
        }
         */
    }

}
