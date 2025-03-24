/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2evejercicio2;

/**
 *
 * @author jabue
 */
public class Triangulo {

    private int base;
    private int altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public double getArea() {
        return (base * altura) / 2.0;
    }

    @Override
    public String toString() {
        return "Triangulo{De primeras la base seria: " + base + ", luego la altura seria: " + altura + " y finalmente el area seria: " + getArea() + "}";
    }

    public static Triangulo[] ordenarPorArea(Triangulo[] triangulos) {
        int n = triangulos.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (triangulos[j].getArea() < triangulos[minIndex].getArea()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // Intercambiar si las áreas son diferentes
                Triangulo temp = triangulos[i];
                triangulos[i] = triangulos[minIndex];
                triangulos[minIndex] = temp;
            }
        }
        return triangulos;
    }

//    private double base;
//    private double altura;

    // Constructor
//    public Triangulo(double base, double altura) {
//        this.base = base;
//        this.altura = altura;
//    }

    // Método para calcular el área del triángulo
//    public double calcularArea() {
//        return (base * altura) / 2;
//    }

    // Método toString para imprimir información del triángulo
//    @Override
//    public String toString() {
//        return String.format("Triángulo [Base: %.2f, Altura: %.2f, Área: %.2f]", base, altura, calcularArea());
//    }
    
//    public double getBase() {
//        return base;
//    }

//    public void setBase(double base) {
//        this.base = base;
//    }

//    public double getAltura() {
//        return altura;
//    }

//    public void setAltura(double altura) {
//        this.altura = altura;
//    }
    
    
}
