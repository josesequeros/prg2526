/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testfiguras;

import java.util.ArrayList;

/**
 *
 * @author jabue
 */
public class Cuadrado extends Figura {

    double lado;

    public Cuadrado(String nombre, double lado, String color, ArrayList<Coordenada> coordenadas) {
        super(nombre, 4, color, coordenadas);
        this.lado = lado;
    }

    @Override
    double calcularArea() {
        return lado * lado;
    }

    @Override
    double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public void redimensionar(double factorEscala) {
        lado *= factorEscala;
        // Actualizar las coordenadas de los vértices
        for (Coordenada coordenada : coordenadas) {
            coordenada.x *= factorEscala;
            coordenada.y *= factorEscala;
        }
        System.out.println("Cuadrado redimensionado. Nuevo tamaño del lado: " + lado);
    }

    /**
     * Redimensiona la figura un factor de escala manteniendo el mismo centro
     * 
     * @param factorEscala
     */
    public void redimensionarMismoCentro(double factorEscala) {
        // Calcular el centro del triángulo (promedio de las coordenadas)
        double centroX = 0, centroY = 0;
        for (Coordenada coordenada : coordenadas) {
            centroX += coordenada.x;
            centroY += coordenada.y;
        }
        centroX /= coordenadas.size();
        centroY /= coordenadas.size();

        // Redimensionar lado del cuadrado
        lado *= factorEscala;

        // Actualizar las coordenadas de los vértices manteniendo el centro fijo
        for (Coordenada coordenada : coordenadas) {
            double dx = coordenada.x - centroX;
            double dy = coordenada.y - centroY;
            coordenada.x = centroX + dx * factorEscala;
            coordenada.y = centroY + dy * factorEscala;
        }

        System.out.println("Cuadrado redimensionado. Nuevo lado: " + lado );
    }

    @Override
    public void rotar(double angulo) {
        System.out.println("Cuadrado rotado. Ángulo de rotación: " + angulo);
        // Obtener el centro del cuadrado (promedio de las coordenadas)
        double centroX = 0, centroY = 0;
        for (Coordenada coordenada : coordenadas) {
            centroX += coordenada.x;
            centroY += coordenada.y;
        }
        centroX /= coordenadas.size();
        centroY /= coordenadas.size();

        // Rotar cada vértice en torno al centro
        for (Coordenada coordenada : coordenadas) {
            double x = coordenada.x - centroX;
            double y = coordenada.y - centroY;
            coordenada.x = centroX + x * Math.cos(Math.toRadians(angulo)) - y * Math.sin(Math.toRadians(angulo));
            coordenada.y = centroY + x * Math.sin(Math.toRadians(angulo)) + y * Math.cos(Math.toRadians(angulo));
        }
    }
}
