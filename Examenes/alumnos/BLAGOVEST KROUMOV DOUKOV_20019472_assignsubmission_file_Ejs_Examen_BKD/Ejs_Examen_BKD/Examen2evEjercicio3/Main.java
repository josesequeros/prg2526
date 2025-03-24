public class Main {

    // Decimal a binario
    public static String decBin(int num) {
        if (num == 0) {
            return "0";
        }
        if (num == 1) {
            return "1";
        }
        return decBin(num / 2) + (num % 2);
    }

    // Funcion de Ackerman
    public static int ack(int a, int b) {
        if (a == 0) {
            return b + 1;
        } else if (a > 0 && b == 0) {
            return ack(a - 1, 1);
        } else {
            return ack(a - 1, ack(a, b - 1));
        }
    }

    public static void main(String[] args) {
        // Ver si funciona decimal a binario
        int numD = 10;
        System.out.println("El número " + numD + " en binario es: " + decBin(numD));

        // Ver si funciona Ackerman
        int a = 3, b = 4;
        System.out.println("Ackermann(" + a + ", " + b + ") = " + ack(a, b));
    }
}