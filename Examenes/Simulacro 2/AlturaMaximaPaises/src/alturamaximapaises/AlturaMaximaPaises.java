/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alturamaximapaises;

/**
 *
 * @author jabue
 */
public class AlturaMaximaPaises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int NumPaises = 4;
        int personas = 10;
        int alturaMaxima = 210, alturaMinima = 140;
        String paises[] = {"Spain", "France", "Portugal", "Ireland"};
        int alturas[][] = new int[4][personas];

        for (int i = 0; i < paises.length; i++) {
            System.out.printf("%-10s", paises[i]);
            for (int j = 0; j < personas; j++) {
                alturas[i][j] = (int) (Math.random() * (alturaMaxima - alturaMinima) + alturaMinima);
                System.out.printf("%4d", alturas[i][j]);
            }
            System.out.println("");
        }
        int maxima = 0;
        System.out.println("");
        for (int i = 0; i < paises.length; i++) {
            maxima = 0;
            for (int j = 0; j < personas; j++) {
                if (alturas[i][j] > maxima) {
                    maxima = alturas[i][j];
                }
            }
            System.out.printf("Mayor altura de: %-10s %4d", paises[i],maxima);
            System.out.println("");
        }
    }

}
