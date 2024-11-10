/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0303;

/**
 *
 * @author jabue
 */
public class Ejercicio0303 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dimA, dimB;
        int rango = 10;
        dimA = (int) (Math.random() * rango + 1) - 0;
        dimB = (int) (Math.random() * rango + 1) - 0;

        int[] vectorA = new int[dimA];
        int[] vectorB = new int[dimB];
        for (int i = 0; i < vectorA.length; i++) {
            //vector[i] = (int) (Math.random() * 21) - 10;
            vectorA[i] = (int) (Math.random() * rango + 1) - 0;
        }
        for (int i = 0; i < vectorB.length; i++) {
            //vector[i] = (int) (Math.random() * 21) - 10;
            vectorB[i] = (int) (Math.random() * rango + 1) - 0;
        }
        System.out.println("Vector A: ");
        for (int i = 0; i < vectorA.length; i++) {
            System.out.print(vectorA[i] + ", ");
        }
        System.out.println("");
        System.out.println("Vector B: ");
        for (int i = 0; i < vectorB.length; i++) {
            System.out.print(vectorB[i] + ", ");
        }
        System.out.println("");
        int dimC = vectorA.length < vectorB.length ? vectorB.length : vectorA.length;
        int vectorC[] = new int[dimC];

        for (int i = 0; i < vectorA.length && i < vectorB.length; i++) {
            vectorC[i] = vectorA[i] + vectorB[i];
        }
        for (int i = vectorA.length; i < vectorB.length; i++) {
            vectorC[i] = vectorB[i];
        }
        for (int i = vectorB.length; i < vectorA.length; i++) {
            vectorC[i] = vectorA[i];
        }

        System.out.println("");
        System.out.println("Vector C: ");
        for (int i = 0; i < vectorC.length; i++) {
            System.out.print(vectorC[i] + ", ");
        }
        System.out.println("");
    }

}
