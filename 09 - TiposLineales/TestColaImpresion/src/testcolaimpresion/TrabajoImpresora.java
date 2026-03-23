/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testcolaimpresion;

/**
 *
 * @author ja.buenoseva
 */
public class TrabajoImpresora {
    private int id;
    private int tiempo;

    public TrabajoImpresora(int id, int tiempo) {
        this.id = id;
        this.tiempo = tiempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "TrabajoImpresora{" + "id=" + id + ", tiempo=" + tiempo + '}';
    }
    
    
}
