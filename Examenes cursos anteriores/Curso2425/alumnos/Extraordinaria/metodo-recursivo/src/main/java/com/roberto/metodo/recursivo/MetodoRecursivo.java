/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.roberto.metodo.recursivo;

/**
 *
 * @author Roberto
 */
public class MetodoRecursivo {

    public static boolean main(String[] args) {
        int x = 2;

        int[] y = {3, 6, 12, 24, 48};
        if (x * y.length == y.length + 1) {
            return true;
        } else {
            return false;
        }

    }
}
