/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ageofempires;

import static ageofempires.TipoMina.ORO;
import static ageofempires.TipoMina.PIEDRA;
import java.util.ArrayList;

/**
 *
 * @author IEUser
 */
public class Civilizacion {

    private String nombre;
    private String rey;
    private int oro;
    private int piedra;
    private int madera;
    private ArrayList aldeanos;
    private int[] almacen;

    public Civilizacion(String nombre, String rey, int oro, int piedra, int madera) {
        this.nombre = nombre;
        this.rey = rey;
        this.oro = oro;
        this.piedra = piedra;
        this.madera = madera;
        this.aldeanos = new ArrayList();
        this.almacen = new int[TipoMina.values().length];

        almacen[TipoMina.ORO.ordinal()] = oro;
        almacen[TipoMina.PIEDRA.ordinal()] = piedra;
        almacen[TipoMina.MADERA.ordinal()] = madera;

        for (TipoMina tp : TipoMina.values()) {
            almacen[tp.ordinal()] = 123;
        }

    }

    public Civilizacion(String nombre, String rey) {
        this.nombre = nombre;
        this.rey = rey;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRey() {
        return rey;
    }

    public int getOro() {
        return oro;
    }

    public int getPiedra() {
        return piedra;
    }

    public int getMadera() {
        return madera;
    }

    public ArrayList getAldeanos() {
        return aldeanos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRey(String rey) {
        this.rey = rey;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public void setPiedra(int piedra) {
        this.piedra = piedra;
    }

    public void setMadera(int madera) {
        this.madera = madera;
    }

    public void setAldeanos(ArrayList aldeanos) {
        this.aldeanos = aldeanos;
    }

    @Override
    public String toString() {
        return "Civilizacion{" + "nombre=" + nombre + ", rey=" + rey
                + ", oro=" + oro + ", piedra=" + piedra + ", madera="
                + madera + ", aldeanos=" + aldeanos.size() + '}';
    }

    public void mostrarRecursos() {
        for (int i = 0; i < almacen.length; i++) {
            System.out.print(TipoMina.values()[i] + ": ");
            System.out.println(almacen[i]);
        }

    }

    public int buscarAldeano(Aldeano aldeano) {
        for (int i = 0; i < aldeanos.size(); i++) {
            if (aldeanos.get(i).equals(aldeano)) {
                System.out.println("Posicion " + i);
            }
        }
        System.out.println((Object) aldeano);
        return 0;
    }

}
