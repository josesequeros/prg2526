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
public class Pentagono extends Figura {

    double lado;

    public Pentagono(String nombre, double lado, String color, ArrayList<Coordenada> coordenadas) {
        super(nombre, 5, color, coordenadas);
        this.lado = lado;
    }

    @Override
    double calcularArea() {
        // Area = Perimetro * (Apotema) * 1/2;
        // Perimetro = 5 * lado
        // Apotema = sqrt((radio * radio)-((lado/2)*(lado/2)))  // teniendo el radio
        // Apotema = (lado/2)/tan(72/2) = lado/(2*0.726542528) = lado/1.453085056
        return 1.7204774 * lado * lado; // Fórmula aproximada para el área de un pentágono regular

    }

    @Override
    double calcularPerimetro() {
        return 5 * lado;
    }

    @Override
    public void redimensionar(double factorEscala) {
        lado *= factorEscala;
        // Actualizar las coordenadas de los vértices
        for (Coordenada coordenada : coordenadas) {
            coordenada.x *= factorEscala;
            coordenada.y *= factorEscala;
        }
        System.out.println("Pentágono redimensionado. Nuevo tamaño del lado: " + lado);
    }

    /**
     * Rota la figura un ángulo en grados recibido como parámetro
     * 
     * @param angulo : angulo a rotar en grados
     */
    @Override
    public void rotar(double angulo) {
        double radianes = Math.toRadians(angulo);
        System.out.println("Pentágono rotado. Ángulo de rotación: " + angulo);
        // Obtener el centro del pentágono (promedio de las coordenadas)
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
            coordenada.x = centroX + x * Math.cos(radianes) - y * Math.sin(radianes);
            coordenada.y = centroY + x * Math.sin(radianes) + y * Math.cos(radianes);
        }
    }

}
