/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejr2ex;

/**
 *
 * @author robgarbor
 */
public class Triangulo {
   

    private double base;
    private double altura;

    // Constructor
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Método para calcular el área del triángulo
    public double calcularArea() {
        return (base * altura) / 2;
    }

    // Método toString para imprimir información del triángulo
    @Override
    public String toString() {
        return String.format("Triángulo [Base: %.2f, Altura: %.2f, Área: %.2f]", base, altura, calcularArea());
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
   
}
