/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sieteymedia;

import java.util.ArrayList;

/**
 *
 * @author jabue
 */
public class Jugador {

    private String nombre;
    private int saldo;
    private ArrayList<CartaJugada> mano;
    private int oculta;

    public Jugador(String nombre, int saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.mano = new ArrayList<CartaJugada>();
        this.oculta = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public ArrayList getMano() {
        return mano;
    }

    public int getOculta() {
        return oculta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setMano(ArrayList mano) {
        this.mano = mano;
    }

    public void setOculta(int oculta) {
        this.oculta = oculta;
    }

    @Override
    public String toString() {
        String cad = "";
        for (int i = 0; i < mano.size(); i++) {
            if (oculta > 0 && oculta == i) {
                cad += "Boca Abajo" + "\n";
            } else {
                cad += mano.get(i).toString() + "\n";
            }
        }
        return "Jugador{" + "nombre=" + nombre + ", saldo=" + saldo + ", mano=" + cad + ", oculta=" + oculta + '}';
    }

    public String mostrarMano() {
        String cad = "";
        for (int i = 0; i < mano.size(); i++) {
            if (mano.get(i).isOculta()) {
            //if (oculta > 0 && oculta == i) {
                cad += "Boca Abajo" + mano.get(i).toString()+"\n";
            } else {
                cad += mano.get(i).toString() + "\n";
            }
        }
        return "Jugador{" + "nombre=" + nombre + ", saldo=" + saldo + ", mano=" + cad + ", oculta=" + oculta + '}';
    }

    public float obtenerPuntuacion() {
        float total = 0;
        for (int i = 0; i < mano.size(); i++) {
            total += ((Carta) mano.get(i)).getValor();
        }
        return total;
    }

}
