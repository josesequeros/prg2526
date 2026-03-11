/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testagendaampliada;

/**
 *
 * @author ja.buenoseva
 */
public class ContactoPersona extends Contacto {

    private String cumpleAños;

    public ContactoPersona(String cumpleAños, String nombre, String telefono) {
        super(nombre, telefono);
        this.cumpleAños = cumpleAños;
    }

    public String getCumpleAños() {
        return cumpleAños;
    }

    public void setCumpleAños(String cumpleAños) {
        this.cumpleAños = cumpleAños;
    }

    @Override
    public String toString() {
        return "ContactoPersona{" + "cumpleA\u00f1os=" + cumpleAños + '}';
    }

    @Override
    public void imprimirContacto() {
        System.out.println(this.getNombre() + " - " + getTelefono() + " - " + cumpleAños);
    }
    
    

}
