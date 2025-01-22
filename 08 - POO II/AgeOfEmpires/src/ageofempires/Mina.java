/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ageofempires;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author IEUser
 */
public class Mina {

    private TipoMina tipo;
    private int items;
    private ArrayList<Aldeano> mineros;

    public Mina() {
        this.tipo = TipoMina.ORO;   //"Oro";
        this.items = 500;
        this.mineros = new ArrayList<>();
    }

    public Mina(TipoMina tipo, int items) {
        this.tipo = tipo;
        this.items = items;
        this.mineros = new ArrayList<>();
    }

    public String getTipoString() {
        return tipo.name();
    }

    public TipoMina getTipo() {
        return tipo;
    }

    public int getItems() {
        return items;
    }

    public void setTipoString(String tipo) {
        this.tipo = TipoMina.valueOf(tipo);
    }

    public void setTipo(TipoMina tipo) {
        this.tipo = tipo;
    }

    public void setItems(int items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Mina{" + "tipo=" + tipo + ", items=" + items + ", mineros=" + ctdTrabajadores() + '}';
    }

    public int ctdTrabajadores() {
        return mineros.size();
    }

    public boolean addAldeano(Aldeano minero) {
        boolean resultado = false;
        mineros.add(minero);
        return resultado;
    }

    public void listarAldeanos() {
        for (int i = 0; i < mineros.size(); i++) {
            System.out.println(mineros.get(i));
        }
    }

    public void extraerItem(int ctd) {
        int total = 0;
        for (int i = 0; i < mineros.size() && this.getItems() > 0; i++) {
            if (this.getItems() < ctd) {
                ctd = this.getItems();
            }
            //System.out.println("Un aldeano de: " +  mineros.get(i).getCivilizacion().getNombre() + " Extrae items: " + ctd);
            mineros.get(i).sumarItem(this.tipo, ctd);
            //System.out.println(mineros.get(i));
            total += ctd;
            this.setItems(this.getItems() - ctd);
        }
        //System.out.println("Extraidos: " + total + " items.");

        System.out.println("\tExtraidos: " + total + " items. Quedan en la mina: " + getItems() + " items.");
    }

    public Aldeano seleccionarAldeano(Civilizacion civilizacion) {
        for (Aldeano minero : mineros) {
            if (minero.getCivilizacion().getNombre().equals(civilizacion.getNombre())) {
                return minero;
            }
        }
        return null;
    }

}
