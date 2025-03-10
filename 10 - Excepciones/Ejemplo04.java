public class Ejemplo04 {
    public static void main(String[] args) {
        int div, x, y;

        x = 3;
        y = 0;
        try {
            div = x / y;
            System.out.println("La ejecución no llegará hasta aquí");
        } catch (ArithmeticException ex) {
            System.out.println("Ha intentado dividir entre 0");
        }
        // System.out.println("el resultado es " + div);
        System.out.println("Fin del programa");
    }
}
