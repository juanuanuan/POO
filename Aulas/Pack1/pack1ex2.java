package Pack1;
import java.util.Scanner;

public class pack1ex2 {
    public static void main(String[] args) {
         
      Scanner scanner = new Scanner(System.in);
      Scanner input = new Scanner(System.in);
      System.out.println("Este programa determina a soma de duas datas no formato (DD/HH/SS)\n");
      System.out.println("Insira o dia, seguido das horas, dos minutos e, finalmente, dos segundos\n");
      int dia1 = input.nextInt();
      int horas1 = input.nextInt();
      int minutos1 = input.nextInt();
      int segundos1 = input.nextInt();
      System.out.println("Introduza agora, do mesmo modo, a segunda data.\n");
      int dia2 = input.nextInt();
      int horas2 = input.nextInt();
      int minutos2 = input.nextInt();
      int segundos2 = input.nextInt();
      input.close(); 
      

      String response = somaDatas(dia1,dia2,horas1,horas2,minutos1,minutos2,segundos1,segundos2);
      System.out.println(response);










    }
    public static String somaDatas(int dia1, int dia2, int horas1, int horas2, int minutos1, int minutos2, int segundos1, int segundos2){
        int somaDias = dia1 + dia2, somaHoras = horas1 = horas2;
        int somaMinutos = minutos1 + minutos2, somaSegundos = segundos1 + segundos2;
        int diasExtra, horasExtra, minutosExtra;


        minutosExtra = somaSegundos / 60;
        somaSegundos %= 60;
        somaMinutos += minutosExtra;

        horasExtra = somaMinutos / 60;
        somaMinutos %= 60;
        somaHoras += horasExtra;

        diasExtra = somaHoras / 24;
        somaHoras %= 24;
        somaDias += diasExtra;

        return (somaDias + "D " + somaHoras + "H " + somaMinutos + "M " + somaSegundos + "S.");










        }
    
}
