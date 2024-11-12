/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package borrar;

/**
 *
 * @author jabue
 */
public class Borrar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el número que quieres convertir: ");
        String numero = input.nextLine();
        System.out.println("Introduce la base que quieres utilizar: ");
        int base = input.nextInt();
        if (!(base == 10 || base == 2 || base == 8 || base == 16)) {
            System.out.println("Error");
            return;
        }
        switch (base) {
            case 10:
                //System.out.println("La conversion de este numero es:  " + numero + " es " + BinarioDecimal());
                break;
            case 2:
                System.out.println("La conversion de este numero es:  " + numero + " es " + DecimalBinario(numero));
                break;
            case 8:
                System.out.println("La conversion de este numero es:  " + numero + " es " + DecimalOctal(numero));
                break;
            case 16:
                System.out.println("La conversion de este numero es:  " + numero + " es " + DecimalHexadecimal(numero));
                break;
        }
    }

    private static String DecimalBinario(String num) {
        long numero = Long.parseLong(num);
        if (numero == 0) {
            return "0";
        } else {
            return DecimalBinario(Long.toString(numero / 2)) + (numero % 2);
        }

    }

    private static String DecimalOctal(String n) {
        long numero = Long.parseLong(n);
        if (numero < 8) {
            return numero + "";
        } else {

            return DecimalOctal(Long.toString(numero / 8)) + (numero % 8);
        }
    }

    private static String DecimalHexadecimal(String n) {
        long numero = Long.parseLong(n);
        if (numero == 0) {
            return "0";
        } else {
            char[] numerosHex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            return DecimalHexadecimal(Long.toString(numero / 16)) + numerosHex[(int) (numero % 16)];
        }
    }

    private static int BinarioDecimal(int n) {
        String nBinario = String.valueOf(n);
        int decimal = 0;
        for (int i = 0; i < nBinario.length(); i++) {
            decimal += (nBinario.charAt(i) - '0') * Math.pow(2, nBinario.length() - 1 - i);
        }
        return decimal;
    }

    System.out.println ("Seleccione de que a que quieres coonvertir");
        int numeroConvertir = sc.nextInt();
    int destino = sc.nextInt();

    System.out.println (
            
    "Ingrese el número a convertir:");
        int numero = sc.nextInt();

    switch (numeroConvertir) {
        case 1:

            switch (destino) {
                case 1:
                    System.out.println("El número ya está en decimal.");
                    break;
                case 2:
                    System.out.println(decimalABinario(numero));
                    break;
                case 3:
                    System.out.println(decimalAOctal(numero));
                    break;
                case 4:
                    System.out.println(decimalAHexadecimal(numero));
                    break;
            }
        case 2:

            switch (numero) {
                case 1:
                    System.out.println(binarioADecimal(numero));
                    break;
                case 2:

                    System.out.println("El número ya está en binario.");
                    break;
                case 3:
                    System.out.println(binarioAOctal(numero));
                    break;
                case 4:
                    System.out.println(binarioAHexadecimal(numero));
                    break;
            }
            break;
        case 3:

            switch (numero) {
                case 1:
                    System.out.println(octalADecimal(numero));
                    break;
                case 2:
                    System.out.println(octalABinario(numero));
                    break;
                case 3:
                    System.out.println("El número ya está en octal.");
                    break;
                case 4:
                    System.out.println(octalAHexadecimal(numero));
                    break;
            }
            break;
        case 4:

            switch (numeroConvertir) {
                case 1:
                    System.out.println(hexadecimalADecimal("" + numero));
                    break;
                case 2:
                    System.out.println(hexadecimalABinario("" + numero));
                    break;
                case 3:
                    System.out.println(hexadecimalAOctal("" + numero));
                    break;
                case 4:
                    System.out.println("El número ya está en hexadecimal.");
                    break;
            }
            break;
    }

    private static String decimalABinario(int numero) {
        if (numero == 0) {
            return "0";
        } else {
            return decimalABinario(numero / 2) + (numero % 2);
        }
    }

    private static String decimalAOctal(int numero) {
        if (numero == 0) {
            return "0";
        } else {
            return decimalAOctal(numero / 8) + (numero % 8);
        }
    }

    private static String decimalAHexadecimal(int numero) {
        if (numero == 0) {
            return "0";
        } else {
            char[] numerosHex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            return decimalAHexadecimal(numero / 16) + numerosHex[numero % 16];
        }
    }

    private static int binarioADecimal(int numero) {
        String binary = String.valueOf(numero);
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal += (binary.charAt(i) - '0') * Math.pow(2, binary.length() - 1 - i);
        }
        return decimal;
    }

    private static String binarioAOctal(int numero) {
        int decimal = binarioADecimal(numero);
        return decimalAOctal(decimal);
    }

    private static String binarioAHexadecimal(int numero) {
        int decimal = binarioADecimal(numero);
        return decimalAHexadecimal(decimal);
    }

    private static int octalADecimal(int numero) {
        String octal = String.valueOf(numero);
        int decimal = 0;
        for (int i = 0; i < octal.length(); i++) {
            decimal += (octal.charAt(i) - '0') * Math.pow(8, octal.length() - 1 - i);
        }
        return decimal;
    }

    private static String octalABinario(int numero) {
        int decimal = octalADecimal(numero);
        return decimalABinario(decimal);
    }

    private static String octalAHexadecimal(int numero) {
        int decimal = octalADecimal(numero);
        return decimalAHexadecimal(decimal);
    }

    private static int hexadecimalADecimal(String numero) {
        int decimal = 0;
        for (int i = 0; i < numero.length(); i++) {
            char c = numero.charAt(i);
            if (c >= '0' && c <= '9') {
                decimal += (c - '0') * Math.pow(16, numero.length() - 1 - i);
            } else if (c >= 'A' && c <= 'F') {
                decimal += (c - 'A' + 10) * Math.pow(16, numero.length() - 1 - i);
            }
        }
        return decimal;
    }

    private static String hexadecimalAOctal(String numero) {
        int decimal = hexadecimalADecimal(numero);
        return decimalAOctal(decimal);
    }

    private static String hexadecimalABinario(String numero) {
        int decimal = hexadecimalADecimal(numero);
        return decimalABinario(decimal);
    }
}
