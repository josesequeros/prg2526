/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testfiguras;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author jabue
 */
public class TestFiguras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Panel de Figuras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        ArrayList<Figura> figuras = new ArrayList<>();
       /*
        PanelFiguras pf = new PanelFiguras(figuras);
        frame.add(pf);
        frame.setVisible(true);
        */

        ArrayList<Coordenada> coordenadasCuadrado = new ArrayList<>();
        coordenadasCuadrado.add(new Coordenada(100, 100));
        coordenadasCuadrado.add(new Coordenada(100, 200));
        coordenadasCuadrado.add(new Coordenada(200, 200));
        coordenadasCuadrado.add(new Coordenada(200, 100));
        Cuadrado cuadrado = new Cuadrado("Cuadrado", Math.sqrt(2), "Rojo", coordenadasCuadrado);
        System.out.println(cuadrado.lado);

        ArrayList<Coordenada> coordenadasCuadrado2 = new ArrayList<>();
        coordenadasCuadrado2.add(new Coordenada(100, 100));
        coordenadasCuadrado2.add(new Coordenada(100, 200));
        coordenadasCuadrado2.add(new Coordenada(200, 200));
        coordenadasCuadrado2.add(new Coordenada(200, 100));
        Cuadrado cuadrado2 = new Cuadrado("Cuadrado2", Math.sqrt(2), "Verde", coordenadasCuadrado2);
        cuadrado2.redimensionarMismoCentro(2);
        System.out.println(cuadrado2.lado);

        ArrayList<Coordenada> coordenadasCuadrado3 = new ArrayList<>();
        coordenadasCuadrado3.add(new Coordenada(100, 100));
        coordenadasCuadrado3.add(new Coordenada(100, 200));
        coordenadasCuadrado3.add(new Coordenada(200, 200));
        coordenadasCuadrado3.add(new Coordenada(200, 100));
        Cuadrado cuadrado3 = new Cuadrado("Cuadrado3", Math.sqrt(2), "Naranja", coordenadasCuadrado3);
        cuadrado3.redimensionarMismoCentro(2.5);
        System.out.println(cuadrado3.lado);

        //cuadrado.mostrarDetalles();
        ArrayList<Coordenada> coordenadasTriangulo = new ArrayList<>();
        coordenadasTriangulo.add(new Coordenada(50, 250));
        coordenadasTriangulo.add(new Coordenada(150, 50));
        coordenadasTriangulo.add(new Coordenada(250, 250));
        Triangulo triangulo = new Triangulo("Triángulo", 5.0, 5.0, "Azul", coordenadasTriangulo);
        Triangulo triangulo2 = nuevoTriangulo("Triangulo 2", "negro", 100, 400, 400);
        Triangulo triangulo3 = nuevoTriangulo("Triangulo 3", "negro", 100, 400, 400);
        Triangulo triangulo4 = nuevoTriangulo("Triangulo 4", "negro", 100, 400, 400);
        Triangulo triangulo5 = nuevoTriangulo("Triangulo 5", "negro", 100, 400, 400);
        Triangulo triangulo6 = nuevoTriangulo("Triangulo 6", "negro", 100, 400, 400);
        triangulo2.rotar(30);
        triangulo3.rotar(60);
        triangulo4.rotar(90);
        triangulo5.rotar(120);
        triangulo6.rotar(150);
        figuras.add(cuadrado);
        figuras.add(cuadrado2);
        figuras.add(cuadrado3);
        figuras.add(triangulo);
        figuras.add(triangulo2);
        figuras.add(triangulo3);
        figuras.add(triangulo4);
        figuras.add(triangulo5);
        figuras.add(triangulo6);

        //triangulo.rotar(45);
        //cuadrado2.rotar(45);
        figuras.add(nuevoTriangulo("Triangulo dos", "rojo", 100, 300, 300));
        //figuras.add();
        figuras.add(nuevoCuadrado("Cuadrado nuevo", "rojo", 100, 300, 300));
        //triangulo2.rotar(-90);

        
        PanelFiguras pf = new PanelFiguras(figuras);
        frame.add(pf);
        frame.setVisible(true);
        
        //cuadrado.redimensionarMismoCentro(2.0);
        //cuadrado.mostrarDetalles();
        //cuadrado.rotar(45.0);
        //cuadrado.mostrarDetalles();
        //figuras.add(cuadrado);
        //cuadrado.dibujar();

        //frame.setVisible(true);
        System.out.println("Pentagono0");
        ArrayList<Coordenada> coordenadasPentagono0 = obtenerCoordenadasPentagono(200, 400, 100);
        Pentagono pentagono0 = new Pentagono("Pentagono 0", 100, "verde", coordenadasPentagono0);
        //pentagono0.rotar(0);        
        figuras.add(pentagono0);        
        
        System.out.println("Pentagono1");        
        ArrayList<Coordenada> coordenadasPentagono1 = obtenerCoordenadasPentagono(200, 400, 100);
        Pentagono pentagono1 = new Pentagono("Pentagono 1", 100, "azul", coordenadasPentagono1);
        pentagono1.rotar(30);
        figuras.add(pentagono1);

        System.out.println("Pentagono2");
        ArrayList<Coordenada> coordenadasPentagono2 = obtenerCoordenadasPentagono(200, 400, 100);
        Pentagono pentagono2 = new Pentagono("Pentagono 2", 100, "rojo", coordenadasPentagono2);
        pentagono2.rotar(60);
        figuras.add(pentagono2);

        System.out.println("Pentagono3");
        ArrayList<Coordenada> coordenadasPentagono3 = obtenerCoordenadasPentagono(200, 400, 100);
        Pentagono pentagono3 = new Pentagono("Pentagono 3", 100, "negro", coordenadasPentagono3);
        pentagono3.rotar(90);        
        figuras.add(pentagono3);

        triangulo.mostrarCoordenadas();
        //triangulo.rotar(180);
        triangulo.mostrarCoordenadas();
        //triangulo.rotar(180);
        triangulo.mostrarCoordenadas();
        

    }

    public static Triangulo nuevoTriangulo(String nombre, String color, double base, int x, int y) {

        double altura = base * 1 / 2 * Math.sqrt(3);
        Coordenada c1 = new Coordenada(x, y);
        double x2 = x + base / 2;
        double y2 = y - base / 2 * Math.sqrt(3);
        Coordenada c2 = new Coordenada(x2, y2);
        double x3 = x + base;
        double y3 = y;
        Coordenada c3 = new Coordenada(x3, y3);
        ArrayList<Coordenada> listaCoordenadas = new ArrayList<>();
        listaCoordenadas.add(c1);
        listaCoordenadas.add(c2);
        listaCoordenadas.add(c3);
        return new Triangulo(nombre, base, altura, color, listaCoordenadas);
    }

    public static Cuadrado nuevoCuadrado(String nombre, String color, double lado, int x, int y) {
        Coordenada c1 = new Coordenada(x, y);
        double x2 = x;
        double y2 = y - lado;
        Coordenada c2 = new Coordenada(x2, y2);
        double x3 = x2 + lado;
        double y3 = y2;
        Coordenada c3 = new Coordenada(x3, y3);
        double x4 = x3;
        double y4 = y3 + lado;
        Coordenada c4 = new Coordenada(x4, y4);
        ArrayList<Coordenada> listaCoordenadas = new ArrayList<>();
        listaCoordenadas.add(c1);
        listaCoordenadas.add(c2);
        listaCoordenadas.add(c3);
        listaCoordenadas.add(c4);

        return new Cuadrado(nombre, lado, color, listaCoordenadas);
    }

    // Función para calcular las coordenadas de los vértices de un pentágono equilátero
    public static double[][] calcularVertices(double x, double y, double lado) {
        // Calcular el radio del círculo circunscrito al pentágono
        double angulo = 2 * Math.PI / 5;

        // Calcula el radio del círculo circunscrito al pentágono
        double radio = lado / (2 * Math.sin(Math.PI / 5));

        // Calcula las coordenadas del centro del pentágono
        double centroX = x;
        double centroY = y + radio;

        // Calcula las coordenadas de los vértices
        double[][] vertices = new double[5][2];
        for (int i = 0; i < 5; i++) {
            double anguloActual = angulo * i;
            double verticeX = centroX + radio * Math.cos(anguloActual);
            double verticeY = centroY + radio * Math.sin(anguloActual);
            vertices[i][0] = verticeX;
            vertices[i][1] = verticeY;
        }
        return vertices;
    }

    /**
     * Devuleve un ArrayList con las 5 coordenadas de los vétices de un pentágono regular
     * a partir de el primer vétice
     * 
     * @param x: valor de la coordenada x
     * @param y: valor de la coordenada y
     * @param lado: lado del pentágono
     * @return un ArrayList de Coordenadas
     */
    public static ArrayList<Coordenada> obtenerCoordenadasPentagono(int x, int y, int lado) {
        ArrayList<Coordenada> coordenadasPentagono = new ArrayList<>();
        double radianes = Math.toRadians(72);   // 360/5=72 al ser regular el pentágono
        double apotema = lado / 1.453085056;         // Aproximadamente // Apotema = (lado/2)/tan(72/2) = lado/(2*0.726542528) = lado/1.453085056
        apotema = (lado) / (2 * Math.tan(Math.toRadians(36)));      // mas preciso?
        // Calculamos el centro del pentágono
        double cx = (x + lado / 2.0);
        double cy = (y - apotema);
        int origenX = x;
        int origenY = y;
        System.out.println("Primer Punto: " + origenX + "," + origenY);
        coordenadasPentagono.add(new Coordenada(origenX, origenY));

        for (int i = 2; i < 6; i++) {
            double px = origenX - cx;
            double py = origenY - cy;
            double nx = cx + px * Math.cos(radianes) - py * Math.sin(radianes);
            double ny = cy + px * Math.sin(radianes) + py * Math.cos(radianes);
            origenX = (int) nx;
            origenY = (int) ny;
            System.out.println("Punto " + i + ": " + origenX + "," + origenY);
            coordenadasPentagono.add(new Coordenada(origenX, origenY));
        }

        return coordenadasPentagono;
    }
}
