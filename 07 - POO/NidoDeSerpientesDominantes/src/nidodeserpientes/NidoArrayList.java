/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nidodeserpientes;

import java.util.ArrayList;

/**
 *
 * @author jabue
 */
public class NidoArrayList {

    private ArrayList<Serpiente> serpientes;
    private int total;

    public NidoArrayList(int total) {
        this.total = total;
        this.serpientes = new ArrayList();
        for (int i = 0; i < total; i++) {
            serpientes.add(new Serpiente("S" + (i + 1)));
        }
    }

    @Override
    public String toString() {
        String elementos = "";
        for (int i = 0; i < total; i++) {
            if (serpientes.get(i).isViva()) {
                elementos += "Serpientes= " + serpientes.get(i) + "\n";
            }
        }
        return elementos;
    }

    public ArrayList<Serpiente> getSerpientes() {
        return serpientes;
    }

    public Serpiente getSerpientes(int i) {
        return serpientes.get(i);
    }

    public int serpientesVivas() {
        int elementos = 0;
        for (int i = 0; i < total; i++) {
            if (serpientes.get(i).isViva()) {
                elementos++;
            }
        }
        return elementos;
    }
    
    public Serpiente serpienteAlfa() {
        int max = 0;
        Serpiente aux = null;
        for (int i = 0; i < total; i++) {
            if (serpientes.get(i).isViva()) {
                if (serpientes.get(i).getDominancia() > max) {
                    aux = serpientes.get(i);
                    max = serpientes.get(i).getDominancia();
                }
            }
        }
        return aux;
    }    
}
