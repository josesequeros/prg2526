import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Dime un numero para hacer magia y pasarlo a binario: ");
        int numero = reader.nextInt();
        String binario = "";
        if (numero < 0) {
            System.out.println("Illo tiene que ser mayor o igual que 0");
        } else {   
            convertirABinario(numero, binario);
        }
    }

    public static void convertirABinario(int numero, String binario) {
       
        if (numero == 0) {
            System.out.println("Tadaaaan");
            System.out.println("El numero en binario es: " + binario);
        } else {
            binario = numero % 2 + binario;
            numero = numero / 2;
            convertirABinario(numero , binario);
        }
    }

}
