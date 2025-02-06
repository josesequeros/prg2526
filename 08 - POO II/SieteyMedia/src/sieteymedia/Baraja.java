/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sieteymedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author jabue
 */
public class Baraja {

    //private Carta baraja[];
    private ArrayList<Carta> baraja;

    public Baraja(ArrayList<Carta> baraja) {
        this.baraja = baraja;
    }
    
    /*
    public Baraja() {
        //String[] palosNombre = new String[]{"Oros", "Copas", "Espadas", "Bastos"};
        int numeros[] = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
        this.baraja = new Carta[40];
        int k = 0;
        for (Palos palo : Palos.values()) {
            for (int j = 0; j < numeros.length; j++) {
                baraja[k] = new Carta();
                baraja[k].setPalo(palo);
                baraja[k].setNumero(numeros[j]);
                float valor = (float) (numeros[j] > 7 ? 0.5 : numeros[j]);
                baraja[k].setValor(valor);
                baraja[k].setImagen(numeros[j] + " de " + palo.name());
                k++;
            }
        }
    }
    */
    
    public Baraja() {
        //String[] palosNombre = new String[]{"Oros", "Copas", "Espadas", "Bastos"};
        //int numeros[] = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
        this.baraja = new ArrayList<Carta>(40);
        for (Palos palo : Palos.values()) {
            for(NombreCarta nombre : NombreCarta.values()) {
                Carta carta = new Carta();
                //baraja[k] = new Carta();
                carta.setPalo(palo);
                carta.setNombre(nombre.name());
                carta.setValor(nombre.getValor());
                carta.setImagen(nombre.name() + " de " + palo.name());
                baraja.add(carta);
            }
        }
    }
        
    @Override
    public String toString() {
        String cad = "";
        for (int i = 0; i < 40; i++) {
            cad += baraja.get(i).toString() + "\n";
        }
        return "Baraja{" + "baraja=" + "\n" + cad + '}';
    }

    public void barajar() {
        //shuffle(this.baraja); // Para Arrays
        
        Collections.shuffle(baraja);
        /*
        Carta[] barajaArray = this.baraja.toArray(new Carta[0]);
        shuffle(barajaArray);
        this.baraja = new ArrayList<Carta>(40);
        for (Carta carta : barajaArray) {
            this.baraja.add(carta);
        }
        */
    }

    // genéricos en java
    static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        //System.out.println(temp.toString());
    }

    public static <T> void shuffle(T[] array) {
        Random random = new Random();
        int i = 0;
        for (int j : random.ints(array.length, 0, array.length).toArray()) {
            swap(array, i++, j);
        }
    }
}
