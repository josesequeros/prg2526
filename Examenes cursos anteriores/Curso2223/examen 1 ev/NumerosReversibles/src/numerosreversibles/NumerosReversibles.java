/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numerosreversibles;

/**
 *
 * @author IEUser
 */
public class NumerosReversibles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numero, reves, totalReversibles = 0;
        int posicion;
        boolean reversible = true;
        for (int i = 0; i < 1000; i++) {
            numero = i;
            posicion = 0;
            reves = 0;
            reversible = true;
            if (numero % 10 == 0) {
                reversible = false;
            } else {
                while (numero > 0) {
                    int digito = numero % 10;
                    reves = (int) (digito + reves * 10);//Math.pow(10, posicion));
                    numero = (int) numero / 10;
                    posicion++;
                }
                int suma = i + reves;
                numero = suma;
                while (numero > 0 && reversible) {
                    int digito = numero % 10;
                    if (digito % 2 == 0) {
                        reversible = false;
                    }
                    numero = (int) numero / 10;
                }
                //System.out.println("Número: " + i + " reves: " + reves + " Tamaño: " + posicion);
            }
            if (reversible) {
                System.out.println("Número: " + i + " Es Reversible: " + reves);
                totalReversibles++;
            }
        }
        System.out.println("Total de números reversibles: " + totalReversibles);
    }

}
