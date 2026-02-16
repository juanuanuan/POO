import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String operacao;
        System.out.println("----------JAVACalc----------\n");
        System.out.println();
        System.out.println("Welcome to my calculator! Please press enter. \n");
        String scanner = input.nextLine();
        System.out.println("Introduza a expressao aritmetica.\n");
        operacao = input.next();
        Character[] sinais = {'+','-',':','*'};
        Calculadora f = new Calculadora();
        //char sinal = scanner.charAt(0); 
        for (char sinal : sinais){
            if (operacao.contains(String.valueOf(sinal))){
                int posicao = operacao.indexOf(sinal);
                String primeiroNumero = operacao.substring(0,posicao);
                String segundoNumero = operacao.substring(posicao + 1);


                switch (sinal){
                    case '+':
                        double operando1 = Double.parseDouble(primeiroNumero);
                        double operando2 = Double.parseDouble(segundoNumero);
                        System.out.println(f.soma(operando1, operando2));
                        break;
                    case '-':
                        double operando12 = Double.parseDouble(primeiroNumero);
                        double operando22 = Double.parseDouble(segundoNumero);
                        System.out.println(f.subtracao(operando12, operando22));
                        break;
                    case ':':
                        double operando13 = Double.parseDouble(primeiroNumero);
                        double operando23 = Double.parseDouble(segundoNumero);
                        System.out.println(f.divisao(operando13, operando23));
                        break;
                    case '*':
                        double operando14 = Double.parseDouble(primeiroNumero);
                        double operando24 = Double.parseDouble(segundoNumero);
                        System.out.println(f.multiplicacao(operando14, operando24));
                        break;



                            
                }
            }
        }
        





    }
      public double soma(double operando1, double operando2){
        return operando1 + operando2;

      }

      public double subtracao(double operando12, double operando22){
        return operando12 - operando22;
      }

      public double divisao(double operando13, double operando23){
        return operando13 / operando23; 

      }

      public double multiplicacao(double operando14, double operando24){
        return operando14 * operando24;
      }


    
    
}
