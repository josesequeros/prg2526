package examen2evejercicio2;

public class Examen2evEjercicio2 {

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
        // Eliminar duplicados por área
        Triangulo[] sinDuplicados = eliminarDuplicados(triangulos);
        // Mostrar triángulos después del ordenamiento y eliminación de duplicados
        System.out.println("\nTriángulos después del ordenamiento y eliminación de duplicados:");
        for (Triangulo t : sinDuplicados) {
            System.out.println(t);
        }
    }

    // método de ordenación por selección. Adaptar para ordenar triángulos
    public static Triangulo[] eliminarDuplicados(Triangulo[] lista) {
        int i, j, minimo, contadorRepetidos = 0;
        Triangulo aux;
        Triangulo[] NuevaLista;
        //Recorrido del array
        for (i = 0; i < lista.length - 1; i++) {
            minimo = i;
            for (j = i + 1; j < lista.length; j++) {
                if (lista[j].getArea() < lista[minimo].getArea()) {
                    minimo = j;
                }
            }
            contadorRepetidos++;
            aux = lista[i];
            lista[i] = lista[minimo];
            lista[minimo] = aux;
        }
        System.out.println("Repetidos " + contadorRepetidos);
        return lista;

    }

    // Crear un método que devuelva el array eliminando el elemento que tenga la misma área que uno ya existente.
}
