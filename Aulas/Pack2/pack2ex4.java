package Pack2;
import java.util.Arrays;

public class pack2ex4 {
    public static void main(String[] args){
        String[] a = {"b","d","b","c","c","a"};
        
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        dupsp2e4 duplicado = new dupsp2e4();
        String[] semRepeticoes = duplicado.semRepeticoes(a);
        System.out.println("Array sem repeticoes: " + Arrays.toString(semRepeticoes) + "\n");
    


    }
    
}
