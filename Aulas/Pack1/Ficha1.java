
package Pack1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Ficha1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Ficha1 exercicio = new Ficha1();
        int questao;

        System.out.println("Qual das questoes deseja selecionar? (1-7)\n ");
        questao = input.nextInt();

        switch (questao){

            case 1:
                double cel, far;
                System.out.println("Qual e o valor, em graus celsius, que deseja introduzir?\n");
                cel  = input.nextDouble();
                far = exercicio.celsiusParaFahrenheit(cel);
                System.out.println("A temperatura " + cel + " graus Celsius equivale a " + far + "Fahrenheit.\n"); 


            case 2:
                int a, b;
                int resultado;
                System.out.println("Digite dois numeros inteiros.\n");
                a = input.nextInt();
                b = input.nextInt();
                resultado = exercicio.maximoNumeros(a, b);
                System.out.println("O maximo entre os dois numeros, e : " + resultado + "\n");


            case 3: 
                String nome;
                System.out.println("Bem-vindo/(a) ao BES MB-Mobile! Digite em baixo o seu nome e currente saldo.");
                nome = input.next();
                double saldo = input.nextDouble();
                System.out.println(exercicio.criaDescricaoConta(nome, saldo));

            case 4:
                double euros;
                double taxa;
                double resposta; 
                System.out.println("Introduza abaixo o montante a converter, seguido pela a taxa atual de conversao. (EUR) \n ");
                euros = input.nextDouble();
                taxa = input.nextDouble();
                resposta = exercicio.eurosParaLibras(euros, taxa);
                System.out.println("A conversao foi efetuada com sucesso!\n");
                System.out.println("O valor convertido e igual a: " + resposta + " GBP.\n");
                

            case 5:
                int num1, num2;
                System.out.println("Digite dois numeros inteiros.\n");
                num1 = input.nextInt();
                num2 = input.nextInt();
                System.out.println(exercicio.crescenteMedia(num1,num2)); 
                
            case 6:
                int fac;
                System.out.println("Digite um numero inteiro. \n");
                fac = input.nextInt();
                System.out.println(exercicio.factorial(fac));
            case 7:

            int mS, mF, fatorial;
            System.out.println("Introduza um inteiro. \n");
            fatorial = input.nextInt();
            long resposta1 = exercicio.factorial(fatorial);
            long resposta2 = exercicio.tempoGasto();
            System.out.println("O resultado do fatorial e: " + resposta1 + ". E a duracao do programa e de: " + resposta2 + "\n");

            


        }

        input.close();




     

    }

    public double celsiusParaFahrenheit(double graus){
        return ((graus * 1.8) + 32);
    }
    

    public int maximoNumeros (int a, int b){
        int greaterThen, lesserThen;

        if (a >= b){
            greaterThen = a;
            lesserThen = b;

        } else {
            lesserThen = a;
            greaterThen = b;
        }
        return greaterThen;

    }


    public String criaDescricaoConta(String nome, double saldo){
        return "Nome: " + nome + " Saldo: " + saldo;

    }

    public double eurosParaLibras (double valor, double taxaConversao){
        return valor * taxaConversao;
    }

    public String crescenteMedia(int a, int b){
        System.out.println("O valor maximo e: " + Math.max(a,b) + " ");
        System.out.println("O valor minimo e: " + Math.min(a,b) + "");
        return "A media e igual a: " + (a+b)/2;

    
    }

    public long factorial(int num){
        int fac = num;
        for (int i = num -1; i > 0; i --){
            fac *= i;
        } return fac;
    }


    public long tempoGasto(){
        int milisecondS, milisecondF;
        LocalDateTime now = LocalDateTime.now();
        milisecondS = now.getNano();
        System.out.println(milisecondS);
        milisecondF = now.getNano();
        System.out.println(milisecondF);

        long duracao = milisecondF - milisecondS;
        return duracao;  
        

        
    }

    


    

    
    
}
