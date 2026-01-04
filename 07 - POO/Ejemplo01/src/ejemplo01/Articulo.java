/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo01;

/**
 *
 * @author jabue
 */
public class Articulo {

    // Atributos de la Clase
    String cod;
    String titulo;
    String formato;
    float precio_alquiler;

    // Métodos de la Clase
    float precio1() {
        return precio_alquiler;
    }

    float precio2() {
        float precio_total;

        precio_total = precio_alquiler * 1.80f;

        return precio_total;
    }

    float precio_semana() {
        float precio_total;

        precio_total = precio_alquiler * 5;

        return precio_total;
    }
}
