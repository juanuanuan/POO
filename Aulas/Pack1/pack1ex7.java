package Pack1;
import java.time.LocalDateTime;
import java.util.Scanner;

public class pack1ex7 {
    public static void main(String [] args){ 
         Scanner scanner = new Scanner(System.in);
         Scanner input = new Scanner(System.in);
         LocalDateTime now = LocalDateTime.now();
         int dia, mes, ano;
         int somaDia, somaMes, somaAno;
         System.out.println();
         System.out.println("Este programa efetua o calculo aproximado idade em horas de um individuo, dada a sua data de nascimento (ignorando o calculo de anos bisextos,etc... . Da para ter uma nocao de calculo.).\n");
         System.out.println("Insira o dia.");
         int bdia = input.nextInt();
         System.out.println("Insira o mes.");
         int bmes = input.nextInt();
         System.out.println("Insira, por ultimo, o ano.");
         int bano = input.nextInt();
         input.close();
         if (bdia > 31 | bmes > 12 | bano > 2026) {
            System.out.println("Formato invalido!");
            return; 
         } 
        
         dia = now.getDayOfMonth();
         mes = now.getMonthValue();
         ano = now.getYear();
         

         somaDia = dia - bdia;
         somaDia *= 24; // 24 horas em cada dia

         somaMes = mes - bmes;
         somaMes *= 730; // 730 horas em cada mes !!!GENERALIZANDO!!!
         
         somaAno = ano - bano;
         somaAno *= 8766; // horas em cada ano, novamente, de modo geral.

         System.out.println();
         System.out.println("Calculo efetuado com sucesso!\n");
         System.out.println("A sua idade em horas é de: " + (somaAno + somaMes + somaDia));


    }
}
