/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg04.filtrarlista01;

/**
 *
 * @author IEUser
 */
public class FiltrarLista01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] vectorNumeros, vectorSinRepetidos, vectorConRepetidos, vectorSumasParciales;
        int elementos = 10;
        vectorNumeros = new int[elementos];
        vectorSinRepetidos = new int[elementos];
        vectorConRepetidos = new int[elementos];
        vectorSumasParciales = new int[elementos];
        int posicion=0; 
        int j,k,suma;
        boolean repetido,insertado;

        for (int i = 0; i < elementos; i++) { 
            //vectorNumeros[i] = (int) (1 + Math.random() * 10);
            vectorNumeros[i] = (int) (1 + Math.random() * 10);
        }
        System.out.println("Array Original.");
        for (int i = 0; i < vectorNumeros.length; i++) {
            System.out.print(vectorNumeros[i] + " ");
        }
        System.out.println();
        // elementos sin repetir
        for (int i = 0; i < vectorNumeros.length; i++) {
            repetido = false;
            j=0;
            while (!repetido && j<vectorSinRepetidos.length) {
                if (vectorNumeros[i] == vectorSinRepetidos[j]) {
                    repetido = true;
                }
                j++;
            }
            if (!repetido) {
                vectorSinRepetidos[posicion] = vectorNumeros[i];
                posicion++;
            }
        }
        System.out.println("Elementos Sin Repetir.");
        for (int i = 0; i < vectorSinRepetidos.length; i++) {
            if (vectorSinRepetidos[i] == 0) {
                break;
            }
            System.out.print(vectorSinRepetidos[i] + " ");
        }
        System.out.println();
        
        // Elementos repetidos
        posicion = 0;
        for (int i = 0; i < vectorNumeros.length; i++) {
            repetido = false;
            j=i+1;
            while (!repetido && j<vectorNumeros.length) {
                if (vectorNumeros[i] == vectorNumeros[j]) {
                    repetido = true;
                }
                j++;
            }
            if (repetido) {
                k=0;
                insertado = false;
                while (!insertado && k<vectorConRepetidos.length) {
                    if (vectorNumeros[i] == vectorConRepetidos[k]) {
                        insertado = true;
                    }
                    k++;
                }
                if (!insertado) {
                    vectorConRepetidos[posicion] = vectorNumeros[i];
                    posicion++;
                }
            }
        }
        System.out.println("Elementos Repetidos.");
        for (int i = 0; i < vectorConRepetidos.length; i++) {
            if (vectorConRepetidos[i] == 0) {
                break;
            }
            System.out.print(vectorConRepetidos[i] + " ");
        }
        System.out.println();
        // Sumas Parciales
        suma = 0;
        for (int i = 0; i < elementos; i++) { 
            //vectorNumeros[i] = (int) (1 + Math.random() * 10);
            suma += vectorNumeros[i];
            vectorSumasParciales[i] = suma;
        }
        System.out.println("Sumas Parciales.");
        for (int i = 0; i < vectorSumasParciales.length; i++) {
            System.out.print(vectorSumasParciales[i] + " ");
        }
        System.out.println();
    }
}