/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package objetos_mutables_inmutables;

/**
 *
 * @author jabue
 */
public class Objetos_Mutables_Inmutables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Inicializar variables
        String letras = "";
        int maxCaracteres = 2000000; // 2 millones de caracteres
        String objetivo = "LEAR";

        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            int n = (int) (Math.random() * 26);
            char letra = (char) ('A' + n);
            letras += letra;

        }
        System.out.println(letras);
        while(!letras.substring(letras.length() - 4).equals(objetivo) && letras.length() <=maxCaracteres){
            int n = (int) (Math.random() * 26);
            char letra = (char) ('A' + n);
            letras += letra;
        }
        
        long fin = System.currentTimeMillis();
        if(letras.length() < maxCaracteres){
            System.out.println("encontrada");
            System.out.println(letras.length());
            System.out.println((fin - inicio));
        }
        
       /* StringBuilder letras2 = new StringBuilder("");
        letras2.indexOf(objetivo);*/

    }

}
