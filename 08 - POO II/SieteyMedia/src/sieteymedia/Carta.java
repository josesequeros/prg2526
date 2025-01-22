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
    private int numero;
    private float valor;
    private String imagen;

    public Carta() {
        this.palo = null;
        this.numero = 0;
        this.valor = 0;
        this.imagen = "";
    }

    public Carta(Palos palo, int numero, float valor, String imagen) {
        this.palo = palo;
        this.numero = numero;
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
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
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
    
    
}
