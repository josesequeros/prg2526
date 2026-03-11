/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testvehiculos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ja.buenoseva
 */
public abstract class VehiculoInteligente {

    private String marca;
    private String modelo;
    private int yearFabricacion;
    protected boolean encendido;
    protected long tiempoEncendido;
    protected LocalDateTime instanteEncendidoActual;
    protected LocalDate ultimoMantenimiento;

    public abstract boolean powerOn();
    public abstract void powerOff();

    public VehiculoInteligente(String marca, String modelo, int yearFabricacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.yearFabricacion = yearFabricacion;
        this.ultimoMantenimiento = LocalDate.of(yearFabricacion, 1, 1);
    }

    @Override
    public String toString() {
        return "VehiculoInteligente{" + "marca=" + marca + ", modelo=" + modelo + ", Año Fabricacion=" + yearFabricacion + ", encendido=" + encendido + ", ultimoMantenimiento=" + ultimoMantenimiento + ", tiempoEncendido=" + tiempoEncendido + ", instanteEncendidoActual=" + instanteEncendidoActual + '}';
    }

    public void mostrarInformacion() {
        System.out.println("Datos: " + marca + ", " + modelo + ", " + yearFabricacion);
        System.out.println("Tiempo encendido: " + tiempoEncendido);
        System.out.println("ültimo encendido: " + instanteEncendidoActual);
        String fecha="De Casa";
        if (ultimoMantenimiento != null) {
            fecha = ultimoMantenimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        System.out.println("Ultimo mantenimiento: " + fecha);
    }

    public int diasDesdeUltimoMantenimiento() {
        int dias;

        Period periodo = Period.between(ultimoMantenimiento, LocalDate.now());
        dias = periodo.getYears()*365 + periodo.getMonths()*30 + periodo.getDays();

        return dias;
    }

    public LocalDate programarMantenimiento(int dias) {
        return ultimoMantenimiento.plusDays(dias);
    }

    public long getTiempoEncendido() {
        return tiempoEncendido;
    }

    public LocalDate getUltimoMantenimiento() {
        return ultimoMantenimiento;
    }
    
    
}
