/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ordenacion01y02;

/**
 *
 * @author jabue
 */
public class Ordenacion01y02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int elementos = 100;
        int[] numeros = new int[elementos];
        for (int i = 0; i < elementos; i++) {
            numeros[i] = (int) (Math.random() * 1000 + 1);
            System.out.print(numeros[i] + " ");
        }
        System.out.println("");
        burbuja(numeros);
        mostrarArray(numeros);
        System.out.println("");

        // Array de 
        String[] nombres = {
            "John Doe", "Jane Smith", "Mike Johnson", "Emily Davis", "Chris Brown",
            "Amanda Wilson", "David Clark", "Sarah Miller", "Ryan Taylor", "Ashley Thomas",
            "Michael Williams", "Jessica Martinez", "Matthew Anderson", "Emma Taylor", "Daniel Garcia",
            "Olivia Rodriguez", "William Hernandez", "Isabella Lopez", "Ethan Gonzalez", "Sophia Perez",
            "Alexander Lee", "Madison Harris", "Liam Clark", "Chloe King", "James Martinez",
            "Amelia White", "Benjamin Hall", "Ava Robinson", "Mason Martinez", "Charlotte Scott",
            "Jackson Green", "Penelope Adams", "Lucas Baker", "Ella Garcia", "Jacob Rodriguez",
            "Luna Hernandez", "Logan Wilson", "Avery Anderson", "Layla Jackson", "Oliver Martinez",
            "Riley Carter", "Emma Thompson", "Sebastian Moore", "Aria Kelly", "Julian Sanchez",
            "Harper Nguyen", "Daniel Smith", "Zoe Davis", "Carter Brown", "Mia Martinez",
            "Elijah Johnson", "Scarlett White", "Noah Hall", "Grace Adams", "Ethan Wilson",
            "Avery Thompson", "Madison Garcia", "Michael Brown", "Emma Lee", "Sophia Martinez",
            "Benjamin Rodriguez", "Mason Nguyen", "Ava Smith", "Isabella Johnson", "James Davis",
            "Charlotte Moore", "William Nguyen", "Ella Anderson"
        };

        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i] + " ");
        }

        insercion(nombres);

        for (String nombre : nombres) {
            System.out.println(nombre + " ");
        }
    }

    public static void insercion(int[] a) {
        int i, j, aux;

        //Recorrido del array 
        for (i = 1; i < a.length; i++) {
            aux = a[i];
            for (j = i - 1; j >= 0 && aux < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = aux;
        }
    }

    public static void insercion(String[] a) {
        int i, j;
        String aux;

        //Recorrido del array 
        for (i = 1; i < a.length; i++) {
            aux = a[i];
            for (j = i - 1; j >= 0 && aux.compareTo(a[j]) < 0; j--) {
                a[j + 1] = a[j];
                a[j] = aux; //inserción del elemento analizado en cada iteración
            }
        }
    }

    public static void burbuja(int[] a) {
        int i, j, aux;
        //Nº de vueltas
        for (i = 0; i < a.length - 1; i++) {
            //Recorrido del array 
            for (j = 0; j < a.length - 1 - i; j++) {
                //En cada iteración el recorrido acaba un elemento antes
                if (a[j] > a[j + 1]) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
    }

    public static void burbujaM(int[] a) {
        int aux, i = 0, j;
        boolean intercambio = true;
        //Mientras intercambio sea true 
        while (intercambio) {
            intercambio = false;
            //Recorrido del array 
            for (j = 0; j < a.length - 1 - i; j++) {
                //En cada vuelta el recorrido acaba un elemento antes
                if (a[j] > a[j + 1]) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                    intercambio = true;
                }
            }
            i++;
        }
    }
    
    public static void mostrarArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
