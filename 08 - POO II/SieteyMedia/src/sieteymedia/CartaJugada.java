/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sieteymedia;

/**
 *
 * @author jabue
 */
public class CartaJugada extends Carta {

    private boolean oculta;

    public CartaJugada(boolean oculta) {
        this.oculta = oculta;
    }

    public CartaJugada(boolean oculta, Palos palo, int numero, float valor, String imagen) {
        super(palo, numero, valor, imagen);
        this.oculta = oculta;
    }

    @Override
    public String toString() {
        if (!isOculta()) {
            return super.toString();
        } else {
            return "Carta Oculta" + " = " + super.toString();
        }
    }

    /**
     * @return the oculta
     */
    public boolean isOculta() {
        return oculta;
    }

    /**
     * @param oculta the oculta to set
     */
    public void setOculta(boolean oculta) {
        this.oculta = oculta;
    }

    
}
