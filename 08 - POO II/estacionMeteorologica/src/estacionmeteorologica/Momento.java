/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionmeteorologica;

/**
 *
 * @author IEUser
 */
public class Momento {

    private int hora, dia, mes;

    public Momento(int d, int m, int h) {
        this.dia = d;
        this.mes = m;
        this.hora = h;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getHora() {
        return hora;
    }

    public String toString() {
        return mes + " " + dia + " " + hora;
    }

    public boolean equals(Object o) {
        Momento a = (Momento) o;
        return dia == a.dia && mes == a.mes && hora == a.hora;
    }

    public int compareTo(Momento otro) {
        // A COMPLETAR POR EL ALUMNO ...
        /*
            Método utilizado para realizar una ordenación natural
            Devuelve:
                0 si los dos objetos a comparar son iguales
                -1 si el objeto que se compara con otro es menor
                1 si el objeto que se compara con otro es mayor
        */

    }

}
