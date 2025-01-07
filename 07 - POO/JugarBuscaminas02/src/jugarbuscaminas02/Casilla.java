/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jugarbuscaminas02;

/**
 *
 * @author jose
 */
public class Casilla {

    private boolean mina;
    private boolean marcada;
    private boolean descubierta;
    private int minasAdyacente;
    private char render;

    //public Casilla(boolean mina, boolean marcada, boolean descubierta, int minasAdyacente) {
    public Casilla() {
        this.mina = false;
        this.marcada = false;
        this.descubierta = false;
        this.minasAdyacente = 0;

        this.render = '.';
    }

    @Override
    public String toString() {
        return "Casilla{" + "mina=" + mina + ", marcada=" + marcada + ", descubierta=" + descubierta + ", minasAdyacente=" + minasAdyacente + '}';
    }

    /**
     * @return the mina
     */
    public boolean isMina() {
        return mina;
    }

    /**
     * @param mina the mina to set
     */
    public void setMina(boolean mina) {
        this.mina = mina;
    }

    /**
     * @return the marcada
     */
    public boolean isMarcada() {
        return marcada;
    }

    /**
     * @param marcada the marcada to set
     */
    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
        if (marcada) {
            this.render = '+';
        }
        else {
            this.render = '.';
        }
    }

    /**
     * @return the descubierta
     */
    public boolean isDescubierta() {
        return descubierta;
    }

    /**
     * @param descubierta the descubierta to set
     */
    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
        this.render = (char) (this.minasAdyacente + '0');
    }

    /**
     * @return the minasAdyacente
     */
    public int getMinasAdyacente() {
        return minasAdyacente;
    }

    /**
     * @param minasAdyacente the minasAdyacente to set
     */
    public void setMinasAdyacente(int minasAdyacente) {
        this.minasAdyacente = minasAdyacente;
    }

    /**
     * @return the render
     */
    public char getRender() {
        return render;
    }

    /**
     * @param render the render to set
     */
    public void setRender(char render) {
        this.render = render;
    }

}
