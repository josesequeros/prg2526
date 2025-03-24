public class Examen2EvEjercicio3 {
    public static void main(String[] args) {
        int numero = 10;
        System.out.println("El número " + numero + " en binario es: " + convertirABinario(numero));
    }

    public static String convertirABinario(int numero) {
        if (numero == 0) {
            return "0";
        } else if (numero == 1) {
            return "1";
        } else {
            return convertirABinario(numero / 2) + (numero % 2);
        }
    }
}
