import java.util.Random;
import java.util.Scanner;

public class testing2 {
    public static void main(String[] args) {
        //String regiao;
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Este programa atribui um IP a um usuario dado a sua região (A-Z). \n ");
        System.out.println("A atribuição de IP´s está pre-establecida. Supondo o alcance pré-definido: A -> n.n.20.n e Z -> n.n.45.n\n");
        System.out.println("Digite a sua região (A-Z).\n");
        String input = scanner.nextLine();
        boolean[][] ocupados = new boolean[26][254];
        if (input.length() == 1){
            char regiao = Character.toUpperCase(input.charAt(0));
            int indice = regiao - 'A';
            int octeto3 = 20 + indice; 
            int octeto4 = 1;
            int octeto1 = rand.nextInt(223 - 192 + 1) + 192;
            int octeto2 = rand.nextInt(252) + 1;
            


            if (regiao >= 'A' && regiao <= 'Z') {
                do { 
                    
                    
                    try {
                        
                    System.out.println("Digite a sua preferência de host.\n");
                    octeto4 = scanner.nextInt();

                } catch (Exception e) {
                    System.out.println("Digite apneas números.\n");
                    scanner.nextInt();
                    continue;
                }
                    if (octeto4 >= 1 && octeto4 <= 253) {
                      

                    
                      if (ocupados[indice][octeto4] == true){
                        System.out.println("Definição host inválida. Digite outro número.");
                        continue;


                    } else {
                        ocupados[indice][octeto4] = true;
                        System.out.println("IP atribuido: " + octeto1 + "." + octeto2 + "." + octeto3 + "." + octeto4);
                        break;
                    }
                } else {
                    System.out.println("Fora dos limites computacionais.\n");
                    continue;
                }
                 
                    
                } while (true);
            }

        } else System.out.println("Região inválida. Por favor tente mais tarde.\n");
    
    }
    
}



