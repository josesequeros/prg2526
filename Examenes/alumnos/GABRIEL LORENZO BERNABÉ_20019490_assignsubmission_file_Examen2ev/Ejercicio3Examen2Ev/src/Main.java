public class Main {
    public static String decimalABinario(int n) {
        if (n == 0) return "0";
        if (n == 1) return "1";
        return decimalABinario(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        System.out.println(decimalABinario(32));
    }
}
