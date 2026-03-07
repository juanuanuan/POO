import java.util.Scanner;
import java.util.Arrays;

public class TP2_Ex3{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tamanho;
        System.out.println("Qual o tamanho do array?\n");
        tamanho = input.nextInt();
        int[] arr = new int[tamanho];
        TP2_Ex3Helper helper = new TP2_Ex3Helper(arr);
        System.out.println("Digite os elementos do array.\n");
        int[] arraySalvo = helper.getArray();
        for(int i = 0; i < arr.length; i ++){
            arr[i] = input.nextInt();
            System.out.println("Elemento guardado, digite o proximo.\n");

        } System.out.println("O seu array foi salvo como: " + Arrays.toString(arr));

        System.out.println("Digite 1 para ordenar o array ou 2 para fazer procura binaria.");
        int digito = input.nextInt();
        switch (digito){
            case 1:
                System.out.println("O seu foi ordenado com sucesso! (BBSort)\n");
                System.out.println(Arrays.toString(helper.bbsort(arr)));
                break;

            case 2:
                int[] newarr = helper.bbsort(arr);
                System.out.println("O array foi ordenado, para que a procura seja feita com sucesso. " + Arrays.toString(newarr));
                System.out.println("Qual o numero que deseja procurar?\n");
                int inpt = input.nextInt();
                System.out.println("O numero foi encontrado no indice: {" + helper.binaryS(arr,inpt) + "}\n");
                break;




        }


    }
}