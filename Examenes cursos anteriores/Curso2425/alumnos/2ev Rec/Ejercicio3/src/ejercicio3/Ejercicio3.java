/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3;
import java.util.Stack;
/**
 *
 * @author robgarbor
 */
public class Ejercicio3 {
class NodoInt {
int dato;
NodoInt siguiente;
NodoInt(int d) {
dato = d;
siguiente = null;
}
NodoInt(int d, NodoInt s) {
dato = d;
siguiente = s;
}
}
    public static void main(String args){
    
        
     int[] arrayejA = {1, 2, 5, 8, 11, 14, 17, 20, 23, 26};
     int[] arrayejB = {1, 3, 5, 8, 10, 12, 15, 18, 21, 24};
    
         Stack<Integer> pila = new Stack<>();
          pila.add(1);
          pila.add(3);
          pila.add(4);
          pila.add(8);
          pila.add(9);
          System.out.println(pila.pop());
          Stack<Integer> pila2 = new Stack<>();
          pila2.add(2);
          pila2.add(4);
          pila2.add(6);
          pila2.add(8);
          pila2.add(10);
        System.out.println(pila2.pop());
       Stack<Integer> pila3 = new Stack<>();
       if(pila.equals(pila2)
               ){}
       else{
            pila3.add(1);
            pila3.add(2);
            pila3.add(6);
            pila3.add(10);
               }
      System.out.println(pila3.pop());

    }
    
    
    
    
}
    /**
     * @param args the command line arguments
     */
    