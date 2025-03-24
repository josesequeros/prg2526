package examen2evejercicio2;

public class Triangulo {

    private double base;
    private double altura;
    private int area;

    // Constructor
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.area = (int)(base * altura);
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

    public double getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
    
    
}
