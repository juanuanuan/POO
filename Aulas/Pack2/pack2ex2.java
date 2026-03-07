package Pack2;


import java.time.LocalDateTime;
import java.util.Scanner;

public class pack2ex2{
    public static void main(String[] args) {
        int tamanho = 3;
        int[] data = new int [tamanho];
        Scanner input = new Scanner(System.in);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Insira o dia, mes e ano. "); // só para iniciar o programa

        pack2ex2Helper helper = new pack2ex2Helper(data);
        helper.insereData(data);

        
    }
    

}
