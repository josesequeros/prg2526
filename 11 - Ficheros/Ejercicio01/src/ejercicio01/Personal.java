/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio01;

import java.util.ArrayList;

/**
 *
 * @author jabue
 */
public class Personal {
    private ArrayList<Persona> personal;

    public Personal() {
        this.personal = new ArrayList<Persona>();
    }

    public Personal(ArrayList<Persona> personal) {
        this.personal = personal;
    }
    
    public void addPersona(Persona persona) {
        this.personal.add(persona);
    }
    
    public void borrarPorEmail(String email) {
        Persona aux = null;
        for (Persona persona : this.getPersonal()) {
            System.out.println(persona);
            if (persona.getEmail().equals(email)) {
                System.out.println("pasa");
                //this.getPersonal().remove(persona);
                aux = persona;
                break;
                //System.out.println("Persona a borrar: " + persona);
            }
        }
        if (aux != null) {
            this.getPersonal().remove(aux);
        }
    }

    /**
     * @return the personal
     */
    public ArrayList<Persona> getPersonal() {
        return personal;
    }

    /**
     * @param personal the personal to set
     */
    public void setPersonal(ArrayList<Persona> personal) {
        this.personal = personal;
    }
    
    public ArrayList<Persona> personaPais(String pais) {
        ArrayList<Persona> lista = new ArrayList<>();
        for (Persona persona : this.getPersonal()) {
            if (persona.getPais().equals(pais)) {
                lista.add(persona);
            }
        }        
        return lista;
    }

    public void mostrarPersonal() {
        int i= 1;
        for (Persona persona : personal) {
            System.out.println(i++ + " " + persona);
        }
    }
    
    
}
