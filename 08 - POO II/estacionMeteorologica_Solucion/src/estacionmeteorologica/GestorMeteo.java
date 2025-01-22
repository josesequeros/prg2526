/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionmeteorologica;

import java.util.*;
import java.io.*;

/**
 *
 * @author IEUser
 */
public class GestorMeteo {

    // Definición de atributos: A COMPLETAR POR EL ALUMNO ...
    private Medida[] medidasArray;
    private int numeroMedidas;
    private static int MAXIMOMEDIDAS = 1000;

    public GestorMeteo(String nomFich) throws IOException {
        // A COMPLETAR POR EL ALUMNO ...
        medidasArray = new Medida[MAXIMOMEDIDAS];
        numeroMedidas = 0;
        Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US);
        while (f.hasNext() && numeroMedidas < MAXIMOMEDIDAS) {
            int mes = f.nextInt();
            int dia = f.nextInt();
            int hora = f.nextInt();
            double tempMax = f.nextDouble();
            double pluvio = f.nextDouble();
            medidasArray[numeroMedidas++] = new Medida(new Momento(dia, mes, hora), tempMax, pluvio);
        }
        f.close();
    }

    public Momento mayorTemp() {
        // A COMPLETAR POR EL ALUMNO ...
        int posMax = 0;
        for (int i = 1; i < getNumeroMedidas(); i++) {
            if (getMedidasArray()[i].getTempMax() > getMedidasArray()[posMax].getTempMax()) {
                posMax = i;
            }
        }
        if (getNumeroMedidas() > 0) {
            return getMedidasArray()[posMax].getMomento();
        } else {
            return null;
        }
    }

    public double pluvioMedia(int mes) {
        // A COMPLETAR POR EL ALUMNO ...
        double plMedia = 0;
        int cont = 0;
        for (int i = 0; i < getNumeroMedidas(); i++) {
            if (getMedidasArray()[i].getMomento().getMes() == mes) {
                plMedia += getMedidasArray()[i].getPluvio();
                cont++;
            }
        }
        if (cont > 0) {
            return plMedia / cont;
        } else {
            return -1;
        }
    }

    /**
     * Método de ordenación de un array de enteros por Selección Directa.
     * Utilícese como guía para resolver el método ordenarPorMomento().
     */
    public void SeleccionDirecta(int v[]) {
        for (int i = 0; i < v.length - 1; i++) {
            int posMin = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[posMin]) {
                    posMin = j;
                }
            }
            int aux = v[posMin];
            v[posMin] = v[i];
            v[i] = aux;
        }
    }

    public void ordenarPorMomento() {
        // A COMPLETAR POR EL ALUMNO, utilizando el método anterior de la clase Medida.
        for (int i = 0; i < getNumeroMedidas() - 1; i++) {
            int posMin = i;
            for (int j = i + 1; j < getNumeroMedidas(); j++) {
                if (getMedidasArray()[j].anterior(getMedidasArray()[posMin])) {
                    posMin = j;
                }
            }
            Medida aux = getMedidasArray()[posMin];
            getMedidasArray()[posMin] = getMedidasArray()[i];
            getMedidasArray()[i] = aux;
        }
    }

    /**
     * @return the medidasArray
     */
    public Medida[] getMedidasArray() {
        return medidasArray;
    }

    /**
     * @param medidasArray the medidasArray to set
     */
    public void setMedidasArray(Medida[] medidasArray) {
        this.medidasArray = medidasArray;
    }

    /**
     * @return the numeroMedidas
     */
    public int getNumeroMedidas() {
        return numeroMedidas;
    }

    /**
     * @param numeroMedidas the numeroMedidas to set
     */
    public void setNumeroMedidas(int numeroMedidas) {
        this.numeroMedidas = numeroMedidas;
    }

}
