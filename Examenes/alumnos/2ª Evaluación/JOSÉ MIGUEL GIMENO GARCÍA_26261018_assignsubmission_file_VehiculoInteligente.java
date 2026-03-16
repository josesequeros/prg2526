/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testvehiculos;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author josgimgar3
 */
public class VehiculoInteligente {

    protected String marca;
    protected String modelo;
    protected int añofabricacion;
    protected LocalDate fechamantenimiento;
    protected boolean encendido;
    protected long tiempoencendido;
    protected LocalDateTime instanteencendido;
     protected int bateria;

    public VehiculoInteligente(String marca, String modelo, int añofabricacion, int bateria) {
        this.marca = marca;
        this.modelo = modelo;
        this.añofabricacion = añofabricacion;
        this.fechamantenimiento = null;
        this.encendido = false;
        this.tiempoencendido = 0;
        this.instanteencendido = null;
        this.bateria = bateria;
    }
//Metodos examen

    public boolean powerComprovar() {
        return encendido;
    }

    /**
     *
     * @return
     */
    public String mostrarinformacion() {
        return "VehiculoInteligente{" + "marca=" + marca + ", modelo=" + modelo + ", a\u00f1ofabricacion=" + añofabricacion + ", fechamantenimiento=" + fechamantenimiento + ", encendido=" + encendido + ", tiempoencendido=" + tiempoencendido + ", instanteencendido=" + instanteencendido + '}';
    }

//Geters y Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAñofabricacion(int añofabricacion) {
        this.añofabricacion = añofabricacion;
    }

    public void setFechamantenimiento(LocalDate fechamantenimiento) {
        this.fechamantenimiento = fechamantenimiento;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public void setTiempoencendido(long tiempoencendido) {
        this.tiempoencendido = tiempoencendido;
    }

    public void setInstanteencendido(LocalDateTime instanteencendido) {
        this.instanteencendido = instanteencendido;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAñofabricacion() {
        return añofabricacion;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public long getTiempoencendido() {
        return tiempoencendido;
    }

    public LocalDateTime getInstanteencendido() {
        return instanteencendido;
    }

}
