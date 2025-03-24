package examen2evejercicio3;

import java.util.Scanner;

public class Examen2evEjercicio3 {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner esc = new Scanner(System.in);
        System.out.print("Dime el numero: ");
        int num = esc.nextInt();
        int resultado = funcionBinario(num, 0, 0);
        System.out.println(resultado);
        System.out.println("AKERMANN");
        double num1 = 3;
        double num2 = 4;
        //double akm = funcionRecursivaAckermann(num1, num2);
        //System.out.println("Num ack: " + akm);
        
    }
    
    public static int funcionBinario(int num, int numBin, int i) {
        int elevado;
        if (num <= 0) {
            return numBin;
        } else {
            elevado = (int) Math.pow(10, i);
            numBin = numBin + (num % 2 * elevado);
            num = num / 2;
            i++;
            return funcionBinario(num, numBin, i);
        }
    }
    

    
}
