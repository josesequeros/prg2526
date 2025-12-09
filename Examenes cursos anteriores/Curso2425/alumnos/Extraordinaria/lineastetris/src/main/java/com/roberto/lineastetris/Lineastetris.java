/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.roberto.lineastetris;

/**
 *
 * @author Usuario
 */
public class Lineastetris {

public static int[] eliminarPosicion(int[] array, int pos) {
        if (pos < 0 || pos >= array.length) return array;
        int[] nuevo = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != pos) nuevo[j++] = array[i];
        }
        return nuevo;
    }    
}

