package Pack2;
import java.util.Scanner;

public class pack2ex1 {
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual é o tamanho do array?\n");
        int tamanho = input.nextInt();
        int [] numeros = new int[tamanho];
        for (int i = 0; i < tamanho; i ++){
            System.out.print("Elemento " + (i+1) + ": ");
            numeros[i] = input.nextInt();

        }

        pack2ex1Helper helper = new pack2ex1Helper(numeros, tamanho);

        int minimum = helper.minimo();
        System.out.println("O menor valor do array é: \n" + minimum);

        System.out.println("Introduza dois indices do array: \n");
        System.out.println("I1 = ");
        int i1 = input.nextInt();
        System.out.println("I2 = ");
        int i2 = input.nextInt();
        int[] newArray = helper.intervalo(i1, i2);
        System.out.println("O array formado pelo intervalo de índices é: {" );
        for (int nums : newArray){
            System.out.println(nums + " ");

        } System.out.println("}"); System.out.println();

        System.out.println("Introduza agora outro array.\n");
        System.out.println("Qual o tamanho do novo array");
        int len = input.nextInt();
        int[] arr = new int[len];
        for(int k = 0; k < len; k++ ){
            System.out.println("Elemento " + (k + 1) + " ");
            arr[k] = input.nextInt();
        } 

        int[] common = helper.comuns(numeros, arr);
        System.out.println("O array com os elementos em comum: " );
        for(int elems : common){
            System.out.println(elems + " ");

           
        }

    }
}