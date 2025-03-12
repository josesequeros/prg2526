/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioadicional01_2;

/**
 *
 * @author jabue
 */
public class EjercicioAdicional01_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String num1 = "10110011";
        String num2 = "01010101";
        String num3 = "10000002";
        try {
            System.out.println(bin2Dec(num1));
            System.out.println(bin2Dec(num2));
            System.out.println(bin2Dec(num3));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int bin2Dec(String binaryString) throws NumberFormatException {
        int decimal = 0;
        for (int i = 0, j = binaryString.length() - 1; i < binaryString.length(); i++, j--) {
            char digito = binaryString.charAt(i);
            if (digito < '0' || digito > '1') {
                throw new BinaryFormatException(binaryString);
            }
            // decimal += (Integer.parseInt(String.valueOf(digito))) * Math.pow(2, j);
            decimal += (digito - '0') * Math.pow(2, j);
        }
        return decimal;
    }
}

class BinaryFormatException extends NumberFormatException {
    private String binario; // valor binario de la excepcion

    
    public BinaryFormatException(String binario) {
        super(binario + " No es una string binaria");
        this.binario = binario;
    }
    
    public String getBinario() {
        return binario;
    }
}