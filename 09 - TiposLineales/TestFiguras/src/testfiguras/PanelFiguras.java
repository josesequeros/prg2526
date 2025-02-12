/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testfiguras;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author jabue
 */
public class PanelFiguras extends JPanel {
    private ArrayList<Figura> figuras;

    public PanelFiguras(ArrayList<Figura> figuras) {
        this.figuras = figuras;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        // Dibujar todas las figuras en la lista
        for (Figura figura : figuras) {
            figura.dibujar(g);
        }
/*
        int[] xPoints = {50, 150, 250}; // Coordenadas x de los vértices
        int[] yPoints = {250, 50, 250}; // Coordenadas y de los vértices

        // Dibujar el triángulo
        g.drawPolygon(xPoints, yPoints, 3);
        int[] xCuadrado = {100, 100, 200, 200, 100}; // Coordenadas x de los vértices
        int[] yCuadrado = {100, 200, 200, 100, 100}; // Coordenadas y de los vértices
        // Dibujar el cuadrado
        g.setColor(Color.BLUE);
        g.drawPolygon(xCuadrado, yCuadrado, 4);
        // Pentagono
        int[] xPentagono = new int[5]; // Coordenadas x de los vértices
        int[] yPentagono = new int[5]; // Coordenadas y de los vértices
        double radio = 100;
        double angulo = 360 / 5;
        double radianes = (angulo * Math.PI) / 180;

        g.setColor(Color.RED);
        for (int i = 0; i < 5; i++) {
            double x = 300 + radio * Math.cos(radianes * i);
            double y = 300 + radio * Math.sin⁡(radianes * i);
            xPentagono[i] = (int) x;
            yPentagono[i] = (int) y;
        }
        g.drawPolygon(xPentagono, yPentagono, 5);
*/
    }
}
