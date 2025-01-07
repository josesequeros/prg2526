/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nidodeserpientes;

/**
 *
 * @author jabue
 */
public class Nido {

    private Serpiente[] serpientes;
    private int total;

    public Nido(int total) {
        this.total = total;
        this.serpientes = new Serpiente[total];
        for (int i = 0; i < total; i++) {
            serpientes[i] = new Serpiente("S" + (i + 1));
        }
    }

    @Override
    public String toString() {
        String elementos = "";
        for (int i = 0; i < total; i++) {
            if (serpientes[i].isViva()) {
                elementos += "Serpientes= " + serpientes[i] + "\n";
            }
        }
        return elementos;
    }

    public Serpiente[] getSerpientes() {
        return serpientes;
    }

    public Serpiente getSerpientes(int i) {
        return serpientes[i];
    }

    public int serpientesVivas() {
        int elementos = 0;
        for (int i = 0; i < total; i++) {
            if (serpientes[i].isViva()) {
                elementos++;
            }
        }
        return elementos;
    }
}
