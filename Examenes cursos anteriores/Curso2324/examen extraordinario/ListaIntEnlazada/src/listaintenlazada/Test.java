/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaintenlazada;

/**
 *
 * @author IEUser
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Comienza");
        ListaIntEnlazada lista1 = new ListaIntEnlazada();
        ListaIntEnlazada lista2 = new ListaIntEnlazada();
        lista1.add(1);
        lista1.add(2);
        lista1.add(5);
        lista1.add(10);
        lista1.add(15);
        lista1.add(20);
        lista1.add(25);
        System.out.println("Una lista Vacía - sin elementos en común");
        System.out.println("Lista 1:");
        System.out.println(lista1);
        System.out.println("Lista 2:");
        System.out.println(lista2);
        ListaIntEnlazada lista = ListaIntEnlazada.fusionComunOrdenada(lista1, lista2);
        System.out.println("Lista fusion comun odenada, lista1 y lista2");
        System.out.println(lista);
        System.out.println("");
        System.out.println("Añadimos elementos a la lista 2");
        lista2.add(2);
        lista2.add(5);
        lista2.add(6);
        lista2.add(8);
        lista2.add(10);

        System.out.println("Lista 2:");
        System.out.println(lista2);
        System.out.println("Lista con elementos comunes");

        lista = ListaIntEnlazada.fusionComunOrdenada(lista1, lista2);
        System.out.println(lista);
        System.out.println("");

        // partimos de listas vacías
        System.out.println("Listas nuevas");
        lista2 = new ListaIntEnlazada();
        lista1 = new ListaIntEnlazada();

        // añadimos elementos a las listas
        lista1.add(1);
        lista1.add(2);
        lista1.add(5);
        lista1.add(10);
        lista1.add(15);
        lista1.add(20);
        lista1.add(25);
        lista2.add(2);
        lista2.add(5);
        lista2.add(6);
        lista2.add(8);
        lista2.add(10);
        // vaciamos una o ambas listas
        //lista2 = new ListaIntEnlazada();
        //lista1 = new ListaIntEnlazada();
        System.out.println("Lista 1:");
        System.out.println(lista1);
        System.out.println("Lista 2:");
        System.out.println(lista2);
        System.out.println("Lista con elementos distintos");

        lista = ListaIntEnlazada.fusionDiferenciaSimetricaOrdenada(lista1, lista2);
        System.out.println(lista);

        System.out.println("");
        System.out.println("Recursividad");
        recursividadA(14);
        System.out.println("");
        recursividadB(4873);
        System.out.println("");
        recursividadB(0);
        System.out.println("");

        String[] array = new String[]{"barco", "autobús", "tren", "moto", "bici"};
        int n = 4;
        int total = contarPalabrasRecursivo(array, 4, 0);
        System.out.println("Total de Palabras de longitud: " + n + " = " + total);

        int[] numeros = {1, 3, 5, 8, 11, 14};
        int diferencia = 3;
        int pos = 1;
        if (progresionAritmetica(numeros, diferencia, pos)) {
            System.out.println("Si es una Progresión Aritmética");
        } else {
            System.out.println("No es Progresión Aritmética");
        }

    }

    private static void recursividadA(int i) {
        if (i < 0) {
            System.out.println("");
        } else {
            System.out.print(i + " ");
            recursividadA(i - 1);
            System.out.print(i + " ");
        }
    }

    private static void recursividadB(int i) {
        if (i > 0) {
            System.out.print(i % 10);
            recursividadB((int) (i / 10));
            System.out.print(i % 10);
        }
    }

    private static int contarPalabrasRecursivo(String[] v, int n, int pos) {

        if (pos == v.length) {
            return 0;
        } else {
            if (v[pos].length() == n) {
                return 1 + contarPalabrasRecursivo(v, n, pos + 1);
            } else {
                return contarPalabrasRecursivo(v, n, pos + 1);
            }
        }
    }

    public static boolean progresionAritmetica(int[] a, int d, int pos) {
        if (pos == a.length - 1) {
            return true;
        } else {
            return (a[pos + 1] == a[pos] + d) && progresionAritmetica(a, d, pos + 1);
        }
    }
}
