/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testfiguras;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author jabue
 */
public abstract class Figura implements OperacionesAdicionales {

    String nombre;
    int cantidadLados;
    String color;
    Color colorGrafico;
    ArrayList<Coordenada> coordenadas;

    public Figura(String nombre, int cantidadLados, String color, ArrayList<Coordenada> coordenadas) {
        this.nombre = nombre;
        this.cantidadLados = cantidadLados;
        this.color = color;
        this.coordenadas = coordenadas;
    }

    abstract double calcularArea();

    abstract double calcularPerimetro();

    void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad de lados: " + cantidadLados);
        System.out.println("Color: " + color);
        System.out.println("Area: " + calcularArea());
        System.out.println("Perimetro: " + calcularPerimetro());
        String coordenadasStr = "Coordenadas: ";
        for (Coordenada coordenada : coordenadas) {
            int x = ((int) (coordenada.x * 100)) / 100;
            int y = ((int) (coordenada.y * 100)) / 100;
            //coordenadasStr += "(" + coordenada.x + "," + coordenada.y + ")" + " ";
            coordenadasStr += "(" + x + "," + y + ")" + " ";
        }
        System.out.println(coordenadasStr);
        System.out.println("");
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando la figura " + nombre + " de color " + color);
        // Lógica para dibujar la figura (no implementado en esta versión)
    }

    public void dibujar(Graphics g) {
        System.out.println("Dibujando la figura " + nombre + " de color " + color);
        // Lógica para dibujar la figura (no implementado en esta versión)
        colorGrafico = Colores.getColor(color);
        g.setColor(colorGrafico);
        int size = coordenadas.size();
        int[] x = new int[size];
        int[] y = new int[size];
        int pos = 0;

        for (Coordenada coordenada : coordenadas) {
            x[pos] = (int) coordenada.x;
            y[pos] = (int) coordenada.y;
            pos++;
        }
        g.drawString(this.nombre, x[0], y[0]);
        g.drawPolygon(x, y, size);
    }

    public void mostrarCoordenadas() {
        for (Coordenada coordenada : coordenadas) {
            System.out.println(coordenada);
        }
    }
}
