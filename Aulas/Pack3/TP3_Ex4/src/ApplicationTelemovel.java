import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationTelemovel{
    public static void main(String[] args){
         Telemovel movelVazio = new Telemovel();
         Telemovel movelFabrica = new Telemovel("Iphone", "17", 6, 9, 10, 256d, 200d, 56d, 0d, 0, 10, new ArrayList<>(), 0d);
         Telemovel movelPessoal = new Telemovel(movelFabrica.clone());
         movelPessoal.instalaApp("Definições", 1.2d);
         movelPessoal.instalaApp("AppStore", 0.8d);
         movelPessoal.instalaApp("iOS 26.3", 10d);
         System.out.println(movelPessoal.toString());
         System.out.println("Atualização do Sistema disponível, deseja instalar agora?\n");
         System.out.println();
         System.out.println("Pressione 1 para atualizar\n");
         Scanner input = new Scanner(System.in);
         int digi = input.nextInt();
         if(digi == 1){
             System.out.println("A atualizar o sistema.\n");
             movelPessoal.removeApp("iOS 26.3", 10d);
             movelPessoal.instalaApp("iOS 26.4", 13.4d);
             try {
                 Thread.sleep(5000);
             } catch (InterruptedException e){
                 e.printStackTrace();
             }
             System.out.println("Atualização concluída");
             System.out.println("iOS 26.4 instalado com sucesso.\n");
         } else return;

         movelPessoal.setFotos(10); // era interessante fazer um metodo que mexe se com o espaco das fotos e o setFotos
         System.out.println(movelPessoal.toString());

    }
}