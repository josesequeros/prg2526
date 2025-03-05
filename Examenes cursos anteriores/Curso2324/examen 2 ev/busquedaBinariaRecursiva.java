    public static int busquedaBinariaRecursiva(int[] arr, int valorBuscado, int inicio, int fin) {
        if (inicio > fin) {
            return -1; 
        }

        int medio = (inicio + fin) / 2;

        if (arr[medio] == valorBuscado) {
            return medio; 
        } 
        // Dependiendo si está ordenado de forma ascendente o descendente
        // estaremos a la derecha o a la izquierda del intervalo
        else if (arr[medio] < valorBuscado) {
            return busquedaBinariaRecursiva(arr, valorBuscado, inicio, medio - 1); 
        } else {
            return busquedaBinariaRecursiva(arr, valorBuscado, medio + 1, fin); 
        }
    }