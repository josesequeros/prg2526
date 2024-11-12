/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdispositivos;

/**
 *
 * @author jabue
 */
public class PCSobremesa extends DispositivoElectronico implements Ordenador {

    private String sistemaOperativo;
    private String usuario;
    private String password;
    private String tipo;

    public PCSobremesa(String sistemaOperativo, String usuario, String password, String tipo, String marca, String modelo, int fechaFabricacion) {
        super(marca, modelo, fechaFabricacion);
        this.sistemaOperativo = sistemaOperativo;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
    }

    public void iniciarservicio(String servicio) {
        if (this.tipo.equals("servidor")) {
            System.out.println("El PC Servidor está iniciando el servicio: " + servicio);
        }
    }

    @Override
    public void powerOn() {
        System.out.println("El PC se ha encendido");
        this.encendido = true;
    }

    @Override
    public void powerOff() {
        System.out.println("El PC se ha apagado");
        this.encendido = false;
    }

    @Override
    public boolean logon(String usuario, String password) {
        if (this.usuario.equals(usuario) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void logoff() {
        System.out.println("El PC ha cerrado la sesion");
    }

    @Override
    public void ejecutarAplicacion(String aplicacion) {
        System.out.println("El PC esta ejecutando la aplicacion: " + aplicacion);
    }
}
