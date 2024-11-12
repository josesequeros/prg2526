/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursividadpalindromosinsubstring;

/**
 *
 * @author jabue
 */
public class RecursividadPalindromoSinSubString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            // TODO code application logic here
        String cadena = "noon noon";
        cadena = "Dabale arroz a la zorra el abad";
        String frase = cadena.replace(" ", "");
        frase = frase.toUpperCase();
        if (esPalindromo(frase)) {
            System.out.println(cadena + " es Palindromo");
        } else {
            System.out.println("no es palindromo: " + cadena);
        }
        //System.out.println(subCadena(cadena, 2, 5));
    }

    public static boolean esPalindromo(String s) {
        if (s.length() <= 1) // Base case
        {
            return true;
        } else if (s.charAt(0) != s.charAt(s.length() - 1)) // Base case
        {
            return false;
        } else {
            return esPalindromo(subCadena(s, 1, s.length() - 1));
        }
    }

    public static String subCadena(String s, int inicio, int fin) {
        String sub = "";
        for (int i = inicio; i < s.length() - fin; i++) {
            sub += s.charAt(i);
        }
        return sub;
    }
}
    