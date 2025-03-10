/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.ed.solitario.utils;

import ies.ed.solitario.CartaComponent;
import ies.ed.solitario.MontonComponent;

/**
 *
 * @author pedro
 */
public class ZonaIntercambio {
    private static ZonaIntercambio zonaintercambio;
    private MontonComponent origen;
    private MontonComponent destino;
    private CartaComponent carta;
    {
        zonaintercambio=null;
    }
    private ZonaIntercambio(){
        
        
    }
    public void clean(){
        this.origen=null;
        this.destino=null;
        this.carta=null;
    }
    public static ZonaIntercambio getInstance(){
        if(zonaintercambio==null)
            zonaintercambio= new ZonaIntercambio();
        return zonaintercambio;
    }

    /**
     * @return the origen
     */
    public MontonComponent getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(MontonComponent origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public MontonComponent getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(MontonComponent destino) {
        this.destino = destino;
    }

    /**
     * @return the carta
     */
    public CartaComponent getCarta() {
        return carta;
    }

    /**
     * @param carta the carta to set
     */
    public void setCarta(CartaComponent carta) {
        this.carta = carta;
    }
}
