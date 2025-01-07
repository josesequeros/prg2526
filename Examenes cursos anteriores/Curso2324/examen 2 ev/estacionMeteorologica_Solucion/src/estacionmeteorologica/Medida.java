/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionmeteorologica;

/**
 *
 * @author IEUser
 */
public class Medida {

    private Momento mom;
    private double tempMax;
    private double pluvio;

    public Medida(Momento m, double tmax, double pl) {
        this.mom = m;
        this.tempMax = tmax;
        this.pluvio = pl;
    }

    public Momento getMomento() {
        return mom;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getPluvio() {
        return pluvio;
    }

    public String toString() {
        return mom.toString() + " " + tempMax + " " + pluvio;
    }

    public boolean anterior(Medida otra) {
        // A COMPLETAR POR EL ALUMNO, utilizando el método compareTo de la clase Momento.
        return this.mom.compareTo(otra.mom) < 0;
    }

}
