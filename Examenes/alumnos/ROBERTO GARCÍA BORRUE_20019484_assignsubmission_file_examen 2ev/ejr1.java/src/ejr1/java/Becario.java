/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejr1.java;

/**
 *
 * @author robgarbor
 */
public class Becario extends persona {
        String universidad;

    Becario(String universidad, String nombre, String apellidos, String correo) {
     this.universidad = universidad;
     this.nombre = nombre;
     this.apellidos = apellidos;
     this.correo = correo;
    }

    /**
     * @return the universidad
     */
    public String getUniversidad() {
        return universidad;
    }

    /**
     * @param universidad the universidad to set
     */
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

}
