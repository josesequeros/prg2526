public class Main {
    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println("Ackermann(" + m + ", " + n + ") = " + ackermann(m, n));
    }

    public static int ackermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return ackermann(m - 1, 1);
        } else {
            return ackermann(m - 1, ackermann(m, n - 1));
        }
    }
}
