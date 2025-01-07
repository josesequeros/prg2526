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
    private Medida elArray[];
    private int numM;
    private static int MAXM = 1000;

    public GestorMeteo(String nomFich) throws IOException {
        // A COMPLETAR POR EL ALUMNO ...
        elArray = new Medida[MAXM];
        numM = 0;
        Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US);
        while (f.hasNext() && numM < MAXM) {
            int mes = f.nextInt();
            int dia = f.nextInt();
            int hora = f.nextInt();
            double tempMax = f.nextDouble();
            double pluvio = f.nextDouble();
            elArray[numM++] = new Medida(new Momento(dia, mes, hora), tempMax, pluvio);
        }
        f.close();
    }

    public Momento mayorTemp() {
        // A COMPLETAR POR EL ALUMNO ...
        int posMax = 0;
        for (int i = 1; i < getNumM(); i++) {
            if (getElArray()[i].getTempMax() > getElArray()[posMax].getTempMax()) {
                posMax = i;
            }
        }
        if (getNumM() > 0) {
            return getElArray()[posMax].getMomento();
        } else {
            return null;
        }
    }

    public double pluvioMedia(int mes) {
        // A COMPLETAR POR EL ALUMNO ...
        double plMedia = 0;
        int cont = 0;
        for (int i = 0; i < getNumM(); i++) {
            if (getElArray()[i].getMomento().getMes() == mes) {
                plMedia += getElArray()[i].getPluvio();
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
        for (int i = 0; i < getNumM() - 1; i++) {
            int posMin = i;
            for (int j = i + 1; j < getNumM(); j++) {
                if (getElArray()[j].anterior(getElArray()[posMin])) {
                    posMin = j;
                }
            }
            Medida aux = getElArray()[posMin];
            getElArray()[posMin] = getElArray()[i];
            getElArray()[i] = aux;
        }
    }

    /**
     * @return the elArray
     */
    public Medida[] getElArray() {
        return elArray;
    }

    /**
     * @param elArray the elArray to set
     */
    public void setElArray(Medida[] elArray) {
        this.elArray = elArray;
    }

    /**
     * @return the numM
     */
    public int getNumM() {
        return numM;
    }

    /**
     * @param numM the numM to set
     */
    public void setNumM(int numM) {
        this.numM = numM;
    }

}
