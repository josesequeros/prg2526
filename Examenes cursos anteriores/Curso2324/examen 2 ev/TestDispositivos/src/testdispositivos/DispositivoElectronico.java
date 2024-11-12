/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdispositivos;

/**
 *
 * @author jabue
 */
public abstract class DispositivoElectronico {

    private String marca;
    private String modelo;
    private int yearFabricacion;
    protected boolean encendido;

    public abstract void powerOn();

    public abstract void powerOff();

    public void mostrarInformacion() {
        System.out.println("DispositivoElectronico: "
                + "\nmarca=" + marca
                + "\n modelo=" + modelo
                + "\n yearFabricacion=" + yearFabricacion
                + "\n encendido=" + encendido + "\n"
        );
    }

    public DispositivoElectronico(String marca, String modelo, int yearFabricacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.yearFabricacion = yearFabricacion;
        this.encendido = false;
    }

}
