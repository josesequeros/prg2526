/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sieteymedia;

/**
 *
 * @author jabue
 */
public class Carta {

    private Palos palo;
    private String nombre;
    //private NombreCarta nombreCarta;
    private double valor;
    private String imagen;

    public Carta() {
        this.palo = null;
        this.nombre = "";
        this.valor = 0;
        this.imagen = "";
    }

    public Carta(Palos palo, String nombre, double valor, String imagen) {
        this.palo = palo;
        this.nombre = nombre;
        this.valor = valor;
        this.imagen = imagen;
    }

    /**
     * @return the palo
     */
    public Palos getPalo() {
        return palo;
    }

    /**
     * @param palo the palo to set
     */
    public void setPalo(Palos palo) {
        this.palo = palo;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        //return "Carta{" + "palo=" + palo.name() + ", numero=" + numero + ", valor=" + valor + ", imagen=" + imagen + '}';
        return imagen;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
