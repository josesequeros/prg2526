/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1002;

import java.io.Serializable;

/**
 *
 * @author jabue
 */
public class Tarea implements Serializable {

    private String titulo;
    private double horas;
    private int estado;

    public Tarea(String titulo, double horas) {
        this.titulo = titulo;
        this.horas = horas;
        this.estado = 0;    //0 PENDIENTE, 1 EN PROCESO, 2 FINALIZADA
    }

    public String getTitulo() {
        return this.titulo;
    }

    public double getHoras() {
        return this.horas;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return getTitulo() + getHoras() + getEstado();
    }

    public String verEstado() {
        switch (this.estado) {
            case 0:
                return "Pendiente";
            case 1:
                return "En proceso";
            case 2:
                return "Finalizada";
            default:
                return "Estado desconocido";
        }
    }
}
