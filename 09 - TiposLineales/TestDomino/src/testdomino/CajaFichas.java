/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdomino;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ja.buenoseva
 */
public class CajaFichas {

    private ArrayList<Ficha> caja;

    public CajaFichas() {
        caja = new ArrayList<>();
        /*
        // por primer numero
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                Ficha ficha = new Ficha(i,j);
                caja.add(ficha);
            }
        }
         */
        // por segundo numero
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= i; j++) {
                Ficha ficha = new Ficha(j, i);
                caja.add(ficha);
            }
        }

    }

    @Override
    public String toString() {
        return "CajaFichas{" + "caja=" + caja + '}';
    }

    public void mostrarCaja() {
        int contador = 0;
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= i; j++) {
                //System.out.print(buscarFicha(j,i)+" ");
                System.out.print(this.caja.get(contador++));
            }
            System.out.println("");
        }
    }

    private Ficha buscarFicha(int j, int i) {
        return new Ficha(j, i);
    }

    public Ficha tomarPrimera() {
        Ficha aux = this.caja.get(0);
        this.caja.remove(0);
        return aux;
    }
    public Ficha tomarUltima() {
        int ultima = caja.size() - 1;
        Ficha aux = this.caja.get(ultima);
        this.caja.remove(ultima);
        return aux;
    }
    
    public Ficha tomarAleatoria() {
        int numero = (int) (Math.random() * caja.size());
        Ficha aux = this.caja.get(numero);
        this.caja.remove(numero);
        return aux;
    }
    
    public void repartiMano(Jugador jugador) {
        for (int i = 0; i < 7; i++) {
            jugador.getMano().add(tomarAleatoria());
        }
    }

    public void mezclar() {
        Collections.shuffle(caja);
    }
}
