/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2ev;

/**
 *
 * @author jabue
 */
public class Examen2ev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangulo triangulos = new Triangulo();
        triangulos.insertar(25);
        triangulos.insertar(9);
        triangulos.insertar(28);
        triangulos.insertar(10);
        triangulos.insertar(27);
        triangulos.insertar(25); //duplicado
        triangulos.insertar(9); //duplicado
        triangulos.imprimir();
        triangulos.eliminarDuplicados();
        if (triangulos.estaOrdenada()) {
            System.out.println("La lista está ordenada");
        } else {
            System.out.println("La lista no está ordenada");
        }
        triangulos.imprimir();
    }
}
