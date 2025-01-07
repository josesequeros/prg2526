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

    public GestorMeteo(String nomFich) throws IOException {
        Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US);
        while (f.hasNext() && numM < MAXM) {
            int mes = f.nextInt();
            int dia = f.nextInt();
            int hora = f.nextInt();
            double tempMax = f.nextDouble();
            double pluvio = f.nextDouble();
            // A COMPLETAR POR EL ALUMNO ... Añadir elementos al array
            -----
        }
        // A COMPLETAR POR EL ALUMNO ... Terminar el constructor
        -----
        -----
        f.close();
    }

    public Momento mayorTemp() {
        // A COMPLETAR POR EL ALUMNO ...

    }

    public double pluvioMedia(int mes) {
        // A COMPLETAR POR EL ALUMNO ...

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

    }
}
