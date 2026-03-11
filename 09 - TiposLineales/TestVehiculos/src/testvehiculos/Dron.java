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
public class Dron extends VehiculoInteligente implements ConectividadVehiculo {

    private int id;
    private int carga;
    private int bateria;

    public Dron(String marca, String modelo, int añoFabricacion, int id, int carga) {
        super(marca, modelo, añoFabricacion);
        this.id = id;
        this.carga = carga;
    }

    @Override
    public boolean powerOn() {
        if (!this.encendido) {
            if (this.bateria >= 15) {
                this.encendido = true;
                this.instanteEncendidoActual = LocalDateTime.now();
            }
        } else {
            System.err.println("Dron ya encendido");
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
            System.err.println("Dron ya apagado");
        }
        this.encendido = false;
    }

    @Override
    public String conectar() {
        return "Dron " + this.id + " Conectado";
    }

    @Override
    public String desconectar() {
        return "Dron " + this.id + " Desconectado";
    }

    @Override
    public void recargar(int cantidad) {
        this.bateria = Math.min(this.bateria + cantidad, 100);
        System.out.println("Bateria:" + bateria);
    }

    public void gastarBateria(int cantidad) {
        this.bateria = Math.max(this.bateria - cantidad, 0);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("id: " + id);
        System.out.println("Carga: " + carga);
        System.out.println("Bateria Dron: " + bateria);
    }

    public void entregarPaguete(double peso) {
        if (encendido) {
            if (this.bateria >= 15) {
                if (this.carga >= peso) {
                    System.out.println("Ejecutando entrega de paquete de peso: " + peso);
                    this.gastarBateria(15);
                } else {
                    System.out.println("No se ha podido ejecutar la entrega por exceso de carga: " + (carga - peso));
                }
            } else {
                this.bateria = 0;
                System.err.println("NO se ha podido ejecutar la entrega: " + peso);
                System.err.println("No habia suficiente bateria");
            }
            if (this.bateria == 0) {
                this.powerOff();
            }
        } else {
            System.err.println("Dron Apagado. No se puede realizar la entrega");
        }
    }

    public String tomarFotografia() {
        String mensaje = "";

        if (encendido) {
            if (this.bateria >= 30) {
                mensaje = "Tamada fotografia.";
                this.gastarBateria(30);
            } else {
                this.bateria = 0;
                mensaje = "NO se ha podido tomar la fotografia.";
                mensaje += "\nNo habia suficiente bateria";
            }
            if (this.bateria == 0) {
                this.powerOff();
            }
        } else {
            mensaje = "Dron Apagado. No se puede realizar la entrega";
        }
        return mensaje;
    }

}
