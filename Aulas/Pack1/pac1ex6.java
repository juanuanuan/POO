package Pack1;
import java.util.Scanner;

public class pac1ex6 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um numero.");
        int n = input.nextInt();
         for (int i = n; i > 0; i --) {
             if (isPrime (i)) System.out.println(i);
             
        }
      
    } 
    






public static Boolean isPrime(int n) {
    int num; 
    if (n <= 1) return false;
    else {
        for (num = 2; num < n; num ++) {
            if (n % num == 0) return false; 
        } 

        return true;
    }
 }
} 