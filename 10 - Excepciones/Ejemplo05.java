import java.util.Scanner;

public class Ejemplo05 {
    public static void main(String[] args) {
        int div, x, y, pos;
        int[] v = { 1, 2, 3 };
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Introduce el numerador: ");
            x = in.nextInt();
            System.out.println("Introduce el denominador: ");
            y = in.nextInt();
            div = x / y;
            System.out.println("La división es: " + div);
            System.out.println("Introduce la posición del vector a consultar: ");
            pos = in.nextInt();
            System.out.println("El elemento es: " + v[pos]);
        } catch (ArithmeticException ex) {
            System.out.println("División por cero: " + ex);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Sobrepasado el tamaño del vector: " + ex);
        }
        System.out.println("Fin del programa");
    }
}
