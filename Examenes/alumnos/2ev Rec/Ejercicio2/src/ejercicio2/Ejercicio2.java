/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author robgarbor
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static boolean main(int[] array1) {
        // TODO code application logic here
        int pos=1;
        int n=10;
        int a =0;
        int d=3;
        int[] arrayejA = {1, 2, 5, 8, 11, 14, 17, 20, 23, 26};
        int[] arrayejB = {1, 3, 5, 8, 10, 12, 15, 18, 21, 24};
        
        for(pos=0; pos<n;pos++){
       
         
         if(pos>=2 && arrayejA[pos-1] == a-d ){ 
             System.out.println("true");
             return true;
           }
         else {
         System.out.println("false");
         return false;
         }
         
         
        }
        
        return false;
        
        
    }
    
}
