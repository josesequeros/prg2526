/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testlistas01;

/**
 *
 * @author jabue
 */
public class TestListas01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NodoInt sec = null;
        sec = new NodoInt(10);
        sec = new NodoInt(5, sec);
        sec = new NodoInt(-2, sec);
        
        Listas lista = null;
        lista.addItem(0);
    }

}
