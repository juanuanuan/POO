import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TP2_Ex2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Quantas datas quer inserir?");
        int quantidade = input.nextInt();
        TP2_Ex2Helper helper = new TP2_Ex2Helper(5); // max de 5 datas

        for(int i = 0; i < quantidade; i++) {
            System.out.println("Insira a data (DD MM AAAA):");
            int dia = input.nextInt();
            int mes = input.nextInt();
            int ano = input.nextInt();
            helper.insereData(dia, mes, ano);
            System.out.println("Data adicionada!\n");
        }


        LocalDate[] datasSaved = helper.getDatas();
        for (int i = 0; i < datasSaved.length; i ++){
            System.out.println((i+1) + "º data: " + datasSaved[i]);
        }

        System.out.println("Adicione agora, outra data (DD MM AAAA).\n");
        int lastd = input.nextInt();
        int lastm = input.nextInt();
        int lasta = input.nextInt();
        LocalDate newDate = LocalDate.of(lasta, lastm, lastd);
        LocalDate proxima = helper.dataMaisProxima(newDate);
        System.out.println("A data mais proxima, pertencente ao array, e: " + proxima);

        String resposta = helper.toString(datasSaved);
        System.out.println("As suas datas convertidas em .txt -> " + newDate + " | " + resposta);
    }

}







