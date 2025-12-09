/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primosenarray;

/**
 *
 * @author jabue
 */
public class PrimosEnArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int elementos = 100;
        int valorMaximo = 1000, valorMinimo = 0;
        int totalPrimos = 0;
        int mayorPrimo = 0;
        int numeros[] = new int[elementos];

        for (int i = 0; i < elementos; i++) {
            numeros[i] = (int) (Math.random() * (valorMaximo - valorMinimo) + valorMinimo);
            System.out.printf("%5d", numeros[i]);
            if ((i+1) % 20 == 0) {
                System.out.println("");
            }
        }
        System.out.println("");
        for (int i = 0; i < elementos; i++) {
            boolean esPrimo = true;
            for (int j = 2; j < numeros[i]; j++) {
                if (numeros[i] % j == 0) {
                    esPrimo = false;
                }
            }
            if (esPrimo) {
                totalPrimos++;
                if (numeros[i] > mayorPrimo) {
                    mayorPrimo = numeros[i];
                }
            }
        }
        System.out.println("");
        System.out.println("El mayor primo del array es: " + mayorPrimo);
        System.out.println("");
    }

}
