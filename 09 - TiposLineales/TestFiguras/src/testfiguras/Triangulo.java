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
public class Triangulo extends Figura {

    double base;
    double altura;

    Triangulo(String nombre, double base, double altura, String color, ArrayList<Coordenada> coordenadas) {
        super(nombre, 3, color, coordenadas);
        this.base = base;
        this.altura = altura;
    }



    @Override
    double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    double calcularPerimetro() {
        // Suponiendo que es un triángulo equilátero
        return 3 * base;
    }

    @Override
    public void redimensionar(double factorEscala) {
        base *= factorEscala;
        altura *= factorEscala;
        // Actualizar las coordenadas de los vértices
        for (Coordenada coordenada : coordenadas) {
            coordenada.x *= factorEscala;
            coordenada.y *= factorEscala;
        }
        System.out.println("Triángulo redimensionado. Nueva base: " + base + ", Nueva altura: " + altura);
    }

    public void redimensionarCentro(double factorEscala) {
        // Calcular el centro del triángulo (promedio de las coordenadas)
        double centroX = 0, centroY = 0;
        for (Coordenada coordenada : coordenadas) {
            centroX += coordenada.x;
            centroY += coordenada.y;
        }
        centroX /= coordenadas.size();
        centroY /= coordenadas.size();

        // Redimensionar la base y la altura
        base *= factorEscala;
        altura *= factorEscala;

        // Actualizar las coordenadas de los vértices manteniendo el centro fijo
        for (Coordenada coordenada : coordenadas) {
            double dx = coordenada.x - centroX;
            double dy = coordenada.y - centroY;
            coordenada.x = centroX + dx * factorEscala;
            coordenada.y = centroY + dy * factorEscala;
        }

        System.out.println("Triángulo redimensionado. Nueva base: " + base + ", Nueva altura: " + altura);
    }

    @Override
    public void rotar(double angulo) {
        System.out.println("Triángulo rotado. Ángulo de rotación: " + angulo);
        // Obtener el centro del triángulo (promedio de las coordenadas)
        double centerX = 0, centerY = 0;
        for (Coordenada coordenada : coordenadas) {
            centerX += coordenada.x;
            centerY += coordenada.y;
        }
        centerX /= coordenadas.size();
        centerY /= coordenadas.size();

        // Rotar cada vértice en torno al centro
        for (Coordenada coordenada : coordenadas) {
            double x = coordenada.x - centerX;
            double y = coordenada.y - centerY;
            coordenada.x = centerX + x * Math.cos(Math.toRadians(angulo)) - y * Math.sin(Math.toRadians(angulo));
            coordenada.y = centerY + x * Math.sin(Math.toRadians(angulo)) + y * Math.cos(Math.toRadians(angulo));
        }
    }
}
