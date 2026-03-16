/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testvehiculos;

/**
 *
 * @author josgimgar3
 */
public class CocheAutonomo extends VehiculoInteligente {

    protected String matricula;
    protected int plazas;

    public CocheAutonomo(String matricula, int plazas, String marca, String modelo, int añofabricacion, int bateria) {
        super(marca, modelo, añofabricacion, bateria);
        this.matricula = matricula;
        this.plazas = plazas;
    }

    public void navegarRuta(String destino) {
        if (bateria >= 21) {
            bateria -= 20;
            System.out.println("Ir a " + destino + "  bateria al " + bateria + "%");

        } else {
            System.out.println("Bateria insuficiente Bateria al " + bateria);
        }
    }

    public void reproducirMusica(String cancion) {
        if (bateria >= 6) {
            bateria -= 5;
            System.out.println(cancion + " se esta reproduciendo bateria al " + bateria + "%");

        } else {
            System.out.println("Bateria insuficiente Bateria al " + bateria + "%");
        }
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

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public String mostrarinformacion() {
        return super.mostrarinformacion() + " CocheAutonomo{" + "matricula=" + matricula + ", plazas=" + plazas + ", bateria=" + bateria + '}';
    }

}
