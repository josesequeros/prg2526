/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdispositivos;

/**
 *
 * @author jabue
 */
public class Smartphone extends DispositivoElectronico implements DispositivoMovil{

    private int numero;
    private double pantalla;
    private int bateria;

    public Smartphone(int numero, double pantalla, int bateria, String marca, String modelo, int fechaFabricacion) {
        super(marca, modelo, fechaFabricacion);
        this.numero = numero;
        this.pantalla = pantalla;
        this.bateria = bateria;
    }

    public void llamar(int numero) {
        this.bateria = Math.max(0, this.bateria - 15);
        System.out.println("El smartphone con numero: " + this.numero + " esta llamando al numero " + numero);
    }
    
    public String revisarCorreo(){
        return "El smartphone con numero: " + this.numero + " tiene 20 correos nuevos";
    }

    @Override
    public void powerOn() {
        System.out.println("El smartphone se ha encendido");
        this.encendido=true;
    }

    @Override
    public void powerOff() {
        System.out.println("El smartphone se ha apagado");
        this.encendido=false;
    }

    @Override
    public String conectar() {
        return "El smartphone se ha conectado";
    }

    @Override
    public String desconectar() {
        return "El smartphone se ha desconectado";
    }

    @Override
    public void recargar(int porcentaje) {
        this.bateria = Math.min(100, this.bateria + porcentaje);
    }

    @Override
    public String toString() {
        return super.toString() + " Smartphone{" + "numero=" + numero + ", pantalla=" + pantalla + ", bateria=" + bateria + '}';
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println(" Smartphone{" + "numero=" + numero + ", pantalla=" + pantalla + ", bateria=" + bateria + '}');
    }

}
