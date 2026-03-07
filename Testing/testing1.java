import java.util.Scanner;

public class testing1 {

    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Este programa vai ler IPs (hosts) inseridos pelo usuario, e vai devolver o IP se pertencer a classe C (/24).\n");
        System.out.println("Insira o IP no formato (x.x.x.x)\n");
        String ipString = input.nextLine();
        String[] partes = ipString.split("\\."); // usamos "\\" como notacao para separar uma string quando chega a um determinado carater. 
                                                       // neste caso, o carater e o "." 
                                                       // e pareciso ao takeWhile/dropWhile em haskell ou ate mesmo o splitAt. 

        if (partes.length == 4){ 
             try {
                int o1 = Integer.parseInt(partes[0]); // introduzimos as variaveis para cada um dos 4 octetos, dando a cada uma delas, uma parte da string do IP.
                int o2 = Integer.parseInt(partes[1]); // lembrando que o IP foi transformado num array, que consequentemente foi dividido em 4.
                int o3 = Integer.parseInt(partes[2]); // a primeira porcao do array fica em partes[0], e assim sucessivamente para o resto das porcoes.
                int o4 = Integer.parseInt(partes[3]); 
                if (ehValido(o1,o2,o3,o4)) { // chamamos uma auxiliar para determinar se qualquer IP e valido. I.e, como estamos a falar de enderecos host, os bits a host nao podem ser tudo a 0 ou tudo a 1 (Privado/Broadcast).
                    if (o1 >=192 && o1 <=223) { 
                        System.out.println("O IP " + ipString + " e valido e pertence a classe C.\n");
                        
                    } else System.out.println("O IP nao pertence a classe C.\n");

                }else System.out.println("O IP nao e valido. Provavelmente inseriu um endereco privado ou Broadcast!\n");
                    
                } catch (NumberFormatException e) {
                    System.out.println("Insira o IP apenas separado por pontos (.).\n");
                  }
            } else System.out.println("Formato IP invalido! Tente x.x.x.x\n"); input.close();



        
    }
     public static boolean ehValido(int o1, int o2, int o3, int o4){
              return o1 >= 0 && o1 <= 255 && o2 >= 0 && o2 <= 255 && o3 >= 0 && o3 <= 255 && o4 > 0 && o4 < 255; 
            
            }   
}
            