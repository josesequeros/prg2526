/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo02;

/**
 *
 * @author jabue
 */
public class Cuadrado {

    // Atributos
    double x1, y1, x2, y2;

    // Métodos
    double CalcularDiagonal() {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    double calcularPerimetro() {
        double diagonal = CalcularDiagonal();
        double lado = diagonal / Math.sqrt(2);

        return 4 * lado;
    }

    double calcularArea() {
        double diagonal = CalcularDiagonal();

        return (0.5 * diagonal * diagonal);
    }
}
