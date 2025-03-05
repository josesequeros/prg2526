/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author IEUser
 */
public class Pruebas extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int tamaño = 100; // Tamaño del cuadrado en píxeles
        int x = 50, y = 50; // Posición inicial

        g.setColor(Color.BLUE); // Color del cuadrado
        g.drawRect(x, y, tamaño, tamaño); // Dibuja el contorno del cuadrado
        g.fillRect(x, y, tamaño, tamaño); // Rellena el cuadrado
        g.setColor(Color.RED); // Color del cuadrado
        g.drawOval(x, y, 50, 50);
    }
    
    public static void main(String[] args) {
        // Default initialization of Stack
        // frame ventana
        JFrame frame = new JFrame("Triángulo Gráfico");
        Pruebas panel = new Pruebas();
        
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
