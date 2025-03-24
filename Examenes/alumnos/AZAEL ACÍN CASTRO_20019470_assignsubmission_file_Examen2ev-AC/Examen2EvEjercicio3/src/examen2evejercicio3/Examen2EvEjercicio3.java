package examen2evejercicio3;

public class Examen2EvEjercicio3 {
    
        public static int Ackermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return Ackermann(m - 1, 1);
        } else {
            return Ackermann(m - 1, Ackermann(m, n - 1));
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 12;

        int resultado = Ackermann(m, n);
        System.out.println("El resultado es: " + resultado);
    }

}

