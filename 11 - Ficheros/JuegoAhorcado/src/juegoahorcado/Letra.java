/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoahorcado;

/**
 *
 * @author jabue
 */
public class Letra {
   private Character letra;
    private Boolean acertada;

    /**
     * Constructor de la clase Letras
     * @param letra
     * @param acertada
     */
    public Letra(Character letra, Boolean acertada) {
        this.letra = letra;
        this.acertada = acertada;
    }

    /**
     * @return the letra
     */
    public Character getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(Character letra) {
        this.letra = letra;
    }

    /**
     * @return the acertada
     */
    public Boolean getAcertada() {
        return acertada;
    }

    /**
     * @param acertada the acertada to set
     */
    public void setAcertada(Boolean acertada) {
        this.acertada = acertada;
    }

    @Override
    public String toString() {
        if (acertada) {
            return letra.toString();
        }
        else {
            return "-";
        }
    }
    
    
}