/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaagendaampliacion;

/**
 *
 * @author IEUser
 */
public class ContactoEmpresa extends Contacto {
    private String web;

    public ContactoEmpresa(String web, String nombre, String telefono) {
        super(nombre, telefono);
        this.web = web;
    }

    /**
     * @return the web
     */
    public String getWeb() {
        return web;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "\tContacto Empresa {" + "web= " + web + "}";
    }

    
    
}
