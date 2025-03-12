/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoahorcado;

/**
 *
 * @author jabue
 */
public class Jugador {

    private String nombre;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int totalPuntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
        this.totalPuntos = 0;
    }

    public Jugador(String nombre, int partidasGanadas, int partidasPerdidas, int totalPuntos) {
        this.nombre = nombre;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.totalPuntos = totalPuntos;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", partidasGanadas=" + partidasGanadas + ", partidasPerdidas=" + partidasPerdidas + ", totalPuntos=" + totalPuntos + '}';
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

    /**
     * @return the partidasGanadas
     */
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    /**
     * @param partidasGanadas the partidasGanadas to set
     */
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    /**
     * @return the partidasPerdidas
     */
    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    /**
     * @param partidasPerdidas the partidasPerdidas to set
     */
    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    /**
     * @return the totalPuntos
     */
    public int getTotalPuntos() {
        return totalPuntos;
    }

    /**
     * @param totalPuntos the totalPuntos to set
     */
    public void setTotalPuntos(int totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

}
