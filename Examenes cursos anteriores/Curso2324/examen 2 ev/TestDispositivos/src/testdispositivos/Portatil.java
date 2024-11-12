/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdispositivos;

/**
 *
 * @author jabue
 */
public class Portatil extends DispositivoElectronico implements DispositivoMovil, Ordenador {

    private double tamanoPantalla;
    private String sistemaOperativo;
    private String usuario;
    private String password;
    private int bateria;

    public Portatil(double tamanoPantalla, String sistemaOperativo, String usuario, String password, int bateria, String marca, String modelo, int fechaFabricacion) {
        super(marca, modelo, fechaFabricacion);
        this.tamanoPantalla = tamanoPantalla;
        this.sistemaOperativo = sistemaOperativo;
        this.usuario = usuario;
        this.password = password;
        this.bateria = bateria;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Portatil{" + "tamanoPantalla=" + tamanoPantalla + ", sistemaOperativo=" + sistemaOperativo + ", usuario=" + usuario + ", password=" + password + ", bateria=" + bateria + '}');
    }

    @Override
    public void powerOn() {
        System.out.println("El portatil se ha encendido");
        this.encendido=true;
    }

    @Override
    public void powerOff() {
        System.out.println("El portatil se ha apagado");
        this.encendido=false;
    }

    @Override
    public String conectar() {
        return "El portatil se ha conectado";
    }

    @Override
    public String desconectar() {
        return "El portatil se ha desconectado";
    }

    @Override
    public void recargar(int porcentaje) {
        this.bateria = Math.max(100, this.bateria + porcentaje);
    }

    @Override
    public boolean logon(String usuario, String password) {
        if (this.usuario.equals(usuario) && this.password.equals(password) && this.bateria >= 10) {
            this.bateria = this.bateria - 10;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void logoff() {
        this.desconectar();
    }

    @Override
    public void ejecutarAplicacion(String aplicacion) {
        if (this.bateria >= 30) {
            System.out.println("el portatil esta ejecutando la aplicacion: " + aplicacion);
            this.bateria = this.bateria - 30;
        }
    }

}
