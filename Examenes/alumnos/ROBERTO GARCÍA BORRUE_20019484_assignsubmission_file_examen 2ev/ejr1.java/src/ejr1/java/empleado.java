/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package ejr1.java;

/**
 *
 * @author robgarbor
 */
public class empleado  extends persona{
    int sueldo;

    empleado(int sueldo, String nombre, String apellidos, String correo) {
                   
    }

   

    /**
     * @return the sueldo
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
