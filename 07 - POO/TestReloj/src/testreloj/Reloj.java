/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testreloj;

/**
 *
 * @author ja.buenoseva
 */
public class Reloj {

    private int hora;
    private int minutos;
    private int segundos;

    private int bateria;

    // Constructor
    public Reloj(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;

        this.bateria = 100;
    }

    // Constructor por defecto
    public Reloj() {
        this.hora = 0;
        this.minutos = 0;
        this.segundos = 0;

        this.bateria = 100;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        if (hora == 24) {
            hora = 0;
        }
        this.hora = hora;
    }

    /**
     * @return the minutos
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * @param minutos the minutos to set
     */
    public void setMinutos(int minutos) {
        if (minutos == 60) {
            minutos = 0;
            setHora(this.hora + 1);
            setBateria(bateria - 1);
        }
        this.minutos = minutos;
    }

    /**
     * @return the segundos
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * @param segundos the segundos to set
     */
    public void setSegundos(int segundos) {
        if (segundos == 60) {
            segundos = 0;
            setMinutos(this.minutos + 1);

        }
        this.segundos = segundos;
    }

    @Override
    public String toString() {
        String horaStr = "00" + this.hora;
        String minutoStr = "00" + this.minutos;
        String segundoStr = "00" + this.segundos;

        // Completamos con ceros
        horaStr = horaStr.substring(horaStr.length() - 2);
        minutoStr = minutoStr.substring(minutoStr.length() - 2);
        segundoStr = segundoStr.substring(segundoStr.length() - 2);

        String tiempo = horaStr + ":" + minutoStr + ":" + segundoStr;
        return tiempo;
        //return "Reloj{" + "hora=" + hora + ", minutos=" + minutos + ", segundos=" + segundos + '}';
    }

    public String mostrarReloj12() {
        if (bateria <= 0) {
            return "";

        }
        String cadena = " am";
        if (this.hora > 12) {
            cadena = " pm";
        } else {

        }
        String horaStr = "00" + this.hora % 12;
        String minutoStr = "00" + this.minutos;
        String segundoStr = "00" + this.segundos;

        // Completamos con ceros
        horaStr = horaStr.substring(horaStr.length() - 2);
        minutoStr = minutoStr.substring(minutoStr.length() - 2);
        segundoStr = segundoStr.substring(segundoStr.length() - 2);

        String tiempo = horaStr + ":" + minutoStr + ":" + segundoStr + cadena;
        return tiempo;
    }

    public String mostrarReloj12Real() {
        if (bateria <= 0) {
            return "";

        }
        String cadena = " am";
        if (this.hora >= 12) {
            cadena = " pm";
        } 
        String horaStr = "";
        if (this.hora % 12 == 0) {
            horaStr = "00" + 12;
        } else {
            horaStr = "00" + this.hora % 12;
        }
        String minutoStr = "00" + this.minutos;
        String segundoStr = "00" + this.segundos;

        // Completamos con ceros
        horaStr = horaStr.substring(horaStr.length() - 2);
        minutoStr = minutoStr.substring(minutoStr.length() - 2);
        segundoStr = segundoStr.substring(segundoStr.length() - 2);

        String tiempo = horaStr + ":" + minutoStr + ":" + segundoStr + cadena;
        return tiempo;
    }

    public void mostrarBateria() {
        String bateriaStr = "";
        StringBuilder bateriaSB = new StringBuilder();

        for (int i = 0; i < this.bateria; i++) {
            bateriaStr += "\u25A0";
            //bateriaSB.append("\u25A0");
            //System.out.print("\u25A0");
        }
        System.out.print(bateriaStr);
        //System.out.print(bateriaSB);

    }

    /**
     * @return the bateria
     */
    public int getBateria() {
        return bateria;
    }

    /**
     * @param bateria the bateria to set
     */
    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

}
