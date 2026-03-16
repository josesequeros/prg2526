/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testvehiculos;

/**
 *
 * @author josgimgar3
 */
public class DronReparto extends VehiculoInteligente {

    protected String id;
    protected int capacidadCargaKg;
    private int tiempoVueloEstimado;

    public DronReparto(String id, int capacidadCargaKg, int tiempoVueloEstimado, String marca, String modelo, int añofabricacion, int bateria) {
        super(marca, modelo, añofabricacion, bateria);
        this.id = id;
        this.capacidadCargaKg = capacidadCargaKg;
        this.tiempoVueloEstimado = tiempoVueloEstimado;
    }
    

    public void entregarPaquete(double peso) {
        int a = (int) peso;
        if (peso > capacidadCargaKg || bateria > 15) {
            System.out.println("No puede transportar el paquete");
        } else {
            System.out.println("Puede transportar el paquete");
        }
    }

    public void tomarFotografia() {
        if (bateria >= 45) {
            bateria -= 30;
            System.out.println("Fotografia tomada menos 30% de bateria = " + bateria);
        } else {
            System.out.println("No se puede tomar fotografia");
        }
    }

    public void bateriaControl() {
        if (bateria < 0) {
            bateria = 0;
        }
        if (bateria > 100) {
            bateria = 100;
        }
    }

    public String getId() {
        return id;
    }

    public int getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public int getTiempoVueloEstimado() {
        return tiempoVueloEstimado;
    }

    public int getBateria() {
        return bateria;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCapacidadCargaKg(int capacidadCargaKg) {
        this.capacidadCargaKg = capacidadCargaKg;
    }

    public void setTiempoVueloEstimado(int tiempoVueloEstimado) {
        this.tiempoVueloEstimado = tiempoVueloEstimado;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public String mostrarinformacion() {
        return super.mostrarinformacion() + "DronReparto{" + "id=" + id + ", capacidadCargaKg=" + capacidadCargaKg + ", tiempoVueloEstimado=" + tiempoVueloEstimado + ", bateria=" + bateria + '}';
    }

}
