public class Ejemplo06 {
    public static void main(String[] args) {
        try {
            metodo(1);
            metodo(20);
        } catch (ExcepcionPropia e) {
            System.out.println("capturada: " + e);
        }
    }

    static void metodo(int n) throws ExcepcionPropia {
        System.out.println("Llamado por método (" + n + ") ");
        if (n > 10)
            throw new ExcepcionPropia(n);
        System.out.println("fINALIZACIÓN NORMAL");
    }
}

class ExcepcionPropia extends Exception {
    private int num;

    ExcepcionPropia(int n) {
        this.num = n;
    }

    public String toString() {
        return "Excepción Propia[" + this.num + "]";
    }
}
