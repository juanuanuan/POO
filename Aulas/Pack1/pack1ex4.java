package Pack1;
import java.util.Scanner;


public class pack1ex4 {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos dias?"); 
        int n = scanner.nextInt();
        if (n<2){
            System.out.println("Preciso de dois ou mais dias");
        
        return; 
        
    }
    int tempoOntem = 0; 
    int maiorVariacao = 0; 
    int diaMVariacao1 = 0;
    int diaMVariacao2 = 0; 
    int total = 0;
    int i = 0;
    while (i < n) {
        int temp = scanner.nextInt();
        total += temp;  
        if (i >= 1) {
            int variacao = temp - tempoOntem;
            if (Math.abs (variacao) > Math.abs (maiorVariacao)) {
               maiorVariacao = variacao; 
               diaMVariacao1 = i;
               diaMVariacao2 = i + 1;
              
            } 

        } tempoOntem = temp;
          i ++;

    } int media = total / n;   
      System.out.printf("A média das %d temperaturas foi : %d graus. \n", n, media); 
      if (maiorVariacao != 0) { 
        String mudanca; 
        if (maiorVariacao > 0) {
            mudanca = "subido";


        } else {
            mudanca = "descido";
        }
      System.out.printf("A maior variação registou-se entre os dias %d e %d, tendo a temperatura %s %d graus. \n", diaMVariacao1, diaMVariacao2, mudanca, Math.abs (maiorVariacao)); {
        
      }
      
      } else {
        System.out.println("Diferenca de temperatura inexistente.");
      }

      scanner.close();
    

    }
 }




















