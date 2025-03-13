/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todo;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Utiles {
    public static int nextInt(String msg, int lowerBound, int upperBound) {
        Scanner sc = new Scanner(System.in);
        int value = 0;
        boolean someError = true;
        do {
            try {
                System.out.print(msg);
                value = sc.nextInt();
                if (value > upperBound || value < lowerBound) {
                    throw new IllegalArgumentException(
                            value + " no esta en el rango [" + lowerBound + ", " + upperBound + "]");
                }
                someError = false;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introzca un numero entero correcto! ... ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, introduzca un valor correcto! ... ");
            } finally {
                sc.nextLine();
            }
        } while (someError);
        return value;
    }

    public static double nextDoublePositivo(String msg) {
        double value = 0.0;
        boolean someError = true;
        Scanner sc = new Scanner(System.in);
        
        class ExcepcionDoubleNegativo extends Exception {
        }

        do {
            try {
                System.out.print(msg);
                value = sc.nextDouble();
                if (value < 0.0) {
                    throw new ExcepcionDoubleNegativo();
                }
                someError = false;
            } catch (ExcepcionDoubleNegativo e) {
                System.out.println("Por favor, introduzca un valor correcto! ... ");
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca un numero real correcto! ... ");
            } finally {
                sc.nextLine();
            }
        } while (someError);
        return value;
    }
}
