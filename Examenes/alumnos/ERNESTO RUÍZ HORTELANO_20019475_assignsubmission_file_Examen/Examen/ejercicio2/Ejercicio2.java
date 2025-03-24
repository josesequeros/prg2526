package ejercicio2;

public class Ejercicio2 {

    public static void main(String[] args) {
        // TODO code application logic here
        Triangulo[] triangulos = {
            new Triangulo(5, 10), // Área = 25
            new Triangulo(3, 6), // Área = 9
            new Triangulo(7, 8), // Área = 28
            new Triangulo(4, 5), // Área = 10
            new Triangulo(6, 9), // Área = 27
            new Triangulo(10, 5), // Área = 25 (Duplicado)
            new Triangulo(6, 3) // Área = 9 (Duplicado)
        };

        // Mostrar triángulos antes del ordenamiento
        System.out.println("Triángulos antes del ordenamiento:");
        for (Triangulo t : triangulos) {
            System.out.println(t);
        }
        // Ordenar usando el método de inserción
        ordenarPorSeleccion(triangulos);
        
        System.out.println("Triángulos despues del ordenamiento:");
        
        for (Triangulo t : triangulos) {
            System.out.println(t);
        }
        
        // Eliminar duplicados por área
        Triangulo[] sinDuplicados = eliminarDuplicados(triangulos);
        // Mostrar triángulos después del ordenamiento y eliminación de duplicados
        System.out.println("\nTriángulos después de al eliminación de duplicados:");
        for (Triangulo t : sinDuplicados) {
            System.out.println(t);
        }
    }

    // método de ordenación por selección. Adaptar para ordenar triángulos
    public static void seleccion(int[] a) {
        int i, j, aux, minimo;
        //Recorrido del array
        for (i = 0; i < a.length - 1; i++) {
            minimo = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[j] < a[minimo]) {
                    minimo = j;
                }
            }
            aux = a[i];
            a[i] = a[minimo];
            a[minimo] = aux;
        }
    }
    public static void ordenarPorSeleccion(Triangulo[] a) {
        int i, j,  minimo;
        Triangulo aux;
        //Recorrido del array
        for (i = 0; i < a.length - 1; i++) {
            minimo = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[j].calcularArea() < a[minimo].calcularArea()) {
                    minimo = j;
                }
            }
            aux = a[i];
            a[i] = a[minimo];
            a[minimo] = aux;
        }
    }
    public static Triangulo[] eliminarDuplicados(Triangulo[] a){
        Triangulo[] aux = new Triangulo[a.length];
        aux[0] = a[0];
        int count = 0;
        for(int i = 1; i < a.length; i++){
            if(a[i-1].calcularArea() != a[i].calcularArea()){
                aux[i] = a[i];
            }else{
                count++;
            }
        }
        
        Triangulo[] array = new Triangulo[a.length - count];
        for(int j = 0, i = 0; i < a.length; i++){
            if(aux[i] != null){
                array[j] = aux[i];
                j++;
            }
        }
        
        return array;
    }
}
