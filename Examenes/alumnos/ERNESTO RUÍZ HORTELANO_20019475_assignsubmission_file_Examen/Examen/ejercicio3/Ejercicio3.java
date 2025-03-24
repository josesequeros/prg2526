package ejercicio3;

public class Ejercicio3 {

    public static void main(String[] args) {
        System.out.println(AckermannNumber(3, 3));
        System.out.println(ToBinary(12));
    }
    
    public static int ToBinary(int number){
        if(number <= 1){
            return number;
        }
        
        if(number % 2 == 0){
            return 10 * ToBinary(number / 2);
        }else{
            return 10 * ToBinary(number / 2) + 1;
        }
    }
    
    public static int AckermannNumber(int m, int n){
        if(m == 0){
            return n+1;
        }
        if(m > 0 && n == 0){
            return AckermannNumber(m -1, 1);
        }
            return AckermannNumber(m-1, AckermannNumber(m, n-1));
        
    }
}
