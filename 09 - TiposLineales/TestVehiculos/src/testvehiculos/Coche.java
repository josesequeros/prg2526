/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testvehiculos;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author ja.buenoseva
 */
public class Coche extends VehiculoInteligente implements SistemaAutopiloto, ConectividadVehiculo {

    private String matricula;
    private int plazas;
    private int bateria;

    public Coche(String marca, String modelo, int yearFabricacion, String matricula, int plazas) {
        super(marca, modelo, yearFabricacion);
        this.matricula = matricula;
        this.plazas = plazas;
    }

    @Override
    public boolean powerOn() {
        if (!this.encendido) {
            if (this.bateria >= 15) {
                this.encendido = true;
                this.instanteEncendidoActual = LocalDateTime.now();
            }
        } else {
            System.err.println("Coche ya encendido");
        }
        return this.encendido;
    }

    @Override
    public void powerOff() {
        if (this.encendido) {
            long segundos = Duration.between(instanteEncendidoActual, LocalDateTime.now()).getSeconds();
            long minutos = segundos / 60;
            this.tiempoEncendido = this.tiempoEncendido + segundos;
        } else {
            System.err.println("Coche ya apagado");
        }
        this.encendido = false;
    }

    @Override
    public boolean iniciarSesion(String usuario, String password) {
        System.out.println("---------------");
        System.out.println("Sesion iniciada");
        System.out.println("---------------");
        return true;
    }

    @Override
    public void cerraSesion() {
        System.out.println("--------------");
        System.out.println("Sesion Cerrada");
        System.out.println("--------------");
    }

    @Override
    public void ejecutarModulo(String modulo) {
        if (encendido) {
            if (this.bateria >= 30) {
                System.out.println("Ejecutando modulo: " + modulo);
                this.gastarBateria(30);
            } else {
                this.bateria = 0;
                System.err.println("NO se ha podido ejecutar el módulo: " + modulo);
                System.err.println("No habia suficiente bateria");
            }
            if (this.bateria == 0) {
                this.powerOff();
            }
        } else {
            System.err.println("Coche Apagado. No se puede operar con el");
        }
    }

    public void gastarBateria(int cantidad) {
        this.bateria = Math.max(this.bateria - cantidad, 0);
    }

    @Override
    public String conectar() {
        return "Coche" + this.matricula + " Conectado";
    }

    @Override
    public String desconectar() {
        return "Dron " + this.matricula + " Desconectado";
    }

    @Override
    public void recargar(int cantidad) {
        this.bateria = Math.min(this.bateria + cantidad, 100);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Matricula: " + matricula);
        System.out.println("Plazas: " + plazas);
        System.out.println("Bateria Coche: " + bateria);
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPlazas() {
        return plazas;
    }

    public int getBateria() {
        return bateria;
    }
    
    
}
