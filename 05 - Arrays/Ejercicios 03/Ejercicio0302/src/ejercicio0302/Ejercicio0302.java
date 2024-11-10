/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0302;

/**
 *
 * @author jabue
 */
public class Ejercicio0302 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int elementos = 2;
        int rango = 40;

        int[] vectorA = new int[elementos];
        int[] vectorB = new int[elementos];
        for (int i = 0; i < elementos; i++) {
            //vector[i] = (int) (Math.random() * 21) - 10;
            vectorA[i] = (int) (Math.random() * rango + 1) - 0;
            vectorB[i] = (int) (Math.random() * rango + 1) - 0;
        }

        //int[] vectorA = {2, 4, 6, 8};
        //int[] vectorB = {1, 2, 3, 4};
        System.out.println("Vector A: ");
        for (int i = 0; i < elementos; i++) {
            System.out.print(vectorA[i] + ", ");
        }
        System.out.println("");
        System.out.println("Vector B: ");
        for (int i = 0; i < elementos; i++) {
            System.out.print(vectorB[i] + ", ");
        }
        System.out.println("");

        double factor = vectorA[0] / vectorB[0];
        boolean proporcionales = true;
        for (int i = 0; i < vectorA.length; i++) {
            //proporcionales = proporcionales && vectorA[i] / vectorB[i] == factor;
            proporcionales = proporcionales && vectorA[i] == vectorB[i] * factor;
        }
        if (proporcionales) {
            System.out.println("Los vectores son proporcionales");
        } else {
            System.out.println("Los vectores NO son proporcionales");
        }

        boolean menor = true;
        for (int i = 0; i < vectorA.length; i++) {
            menor = menor && vectorA[i] <= vectorB[i];
        }
        if (menor) {
            System.out.println("El vector A es menor que el vector B");
        } else {
            System.out.println("A no es menor que B");
        }

        int cont = 1;
        while (!proporcionales) {
            for (int i = 0; i < elementos; i++) {
                //vector[i] = (int) (Math.random() * 21) - 10;
                vectorA[i] = (int) (Math.random() * rango + 1) - 0;
                vectorB[i] = (int) (Math.random() * rango + 1) - 0;
            }
            proporcionales = true;
            for (int i = 0; i < vectorA.length; i++) {
                //proporcionales = proporcionales && vectorA[i] / vectorB[i] == factor;
                proporcionales = proporcionales && vectorA[i] == vectorB[i] * factor;
            }
            cont++;
        }
        System.out.println("Generados: " + cont);
        System.out.println("Vector A: ");
        for (int i = 0; i < elementos; i++) {
            System.out.print(vectorA[i] + ", ");
        }
        System.out.println("");
        System.out.println("Vector B: ");
        for (int i = 0; i < elementos; i++) {
            System.out.print(vectorB[i] + ", ");
        }
        System.out.println("");
    }

}
