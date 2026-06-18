/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.util.ArrayList;


/**
 *
 * @author josgimgar3
 */
public class Personal {

    protected ArrayList<Persona> personal = new ArrayList();

    public Personal() {

    }

    public void addPersona(Persona p) {
        personal.add(p);
    }

    public void borrarPersona(String email) {
        boolean b = false;
        for (int i = 0; i < personal.size(); i++) {
            if (personal.get(i).email.equals(email)) {
                personal.remove(i);
                b = true;
            }
        }
        if (!b) {
            System.out.println("No se encuentra empleado con este email.");
        }
    }

    public void personasPais(String p) {
        for (int i = 0; i < personal.size(); i++) {
            if(personal.get(i).pais.equals(p)){
            personal.get(i).toString();
            }
        }

    }

}
