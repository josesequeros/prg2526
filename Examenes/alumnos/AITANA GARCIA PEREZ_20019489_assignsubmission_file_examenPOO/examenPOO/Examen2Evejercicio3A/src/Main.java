public class Main {
    public static void main(String[] args) {
        int numero = 10;
        System.out.println("El número " + numero + " en binario es: " + binario(numero));
    }
    private static String binario(int numero) {
        if (numero == 0) {
            return "";
        }
        return binario(numero / 2) + (numero % 2);
    }
}
