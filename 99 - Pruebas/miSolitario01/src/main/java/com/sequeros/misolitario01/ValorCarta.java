/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.sequeros.misolitario01;

/**
 *
 * @author jabue
 */
public enum ValorCarta {
    AS(1),
    DOS(2),
    TRES(3),
    CUATRO(4),
    CINCO(5),
    SEIS(6),
    SIETE(7),
    OCHO(8),
    NUEVE(9),
    DIEZ(10),
    SOTA(11),
    REINA(12),
    REY(13);

    private final int value;

    ValorCarta(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
