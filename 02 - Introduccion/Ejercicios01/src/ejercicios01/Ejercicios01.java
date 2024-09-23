/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios01;

/**
 *
 * @author jabue
 */
public class Ejercicios01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a,b,c,d;
        double resultado;
        int max = 10;
        
        a = (int) Math.floor(Math.random()*max+1);
        b = (int) Math.floor(Math.random()*max+1);
        c = (int) Math.floor(Math.random()*max+1);
        d = (int) Math.floor(Math.random()*max+1);
        // a=7;b=2;c=10;d=9;
        //a=5;b=3;c=1;d=3;
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.out.println("c = "+c);
        System.out.println("d = "+d);
        
        resultado = a/b+1;
        System.out.println("a) Resultado de a/b+1 = "+resultado);
        
        resultado = (a+b)/(c-d);
        System.out.println("b) Resultado de (a+b)/(c-d) = "+resultado);
        
        resultado = a+(b/c);
        System.out.println("c) Resultado de a+(b/c) = "+resultado);
        
        resultado = a/(b+c);
        System.out.println("d) Resultado de a/(b+c) = "+resultado);
        
        resultado = (a+b)*c/d;
        System.out.println("e) Resultado de (a+b)*c/d) = "+resultado);
        
        resultado = Math.pow(Math.pow(a+b,2),2);
        System.out.println("f) Resultado de ((a+b)^2)^2 = "+resultado);
        
        resultado = (double)(a*b)/(1-4*a);
        System.out.println("g) Resultado de ab/(1-4a) = "+resultado);
        
        resultado = Math.pow(a+b,2) * (a-b);
        System.out.println("h) Resultado de (a+b)^2*(a-b) = "+resultado);
    }
    
}
