package Pack1;
import java.util.Scanner;

public class pack1ex3 {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    System.out.println("O programa vai ler N classificacoes, e vai imprimir N em cada um dos intervalos do enunciado\n");
    int classi;
    int[] intervalos = {0,0,0,0};
    System.out.println("Introduza o numero de classificacoes.\n");
    classi = input.nextInt();

    double[] notas = new double[classi];
    for (int i = 0; i < classi; i ++){
        System.out.println("Nota " + (i+1) + ": ");
        notas[i] = input.nextDouble();
    }

    input.close();



    avalia(notas,intervalos);
    for (int elem : intervalos) {
        System.out.printf("{" + "%d" + "}", elem); 
    }



    
    
  }

  public static void avalia(double[] notas, int[] intervalos){

       for (double nota: notas) { // o ":" significa : "em cada nota em notas ..." 
           
        if (nota != 20) {
            intervalos[(int) (nota/5)] += 1;

        } else {
            intervalos[(int) (nota-1)/5] += 1;
        }
        
       }

 }

}