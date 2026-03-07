import java.util.Arrays;
import java.util.Scanner;
public class TP2_Ex5 {
    public static void main(String[] args){
        int alunos = 5;
        int uc = 5;
        int[][] turma = {{19,13,18,13,5},
                         {12,7,9,15,16},
                         {10,11,3,9,20},
                         {2,4,19,13,12},
                         {14,15,12,16,10}};
         Scanner input = new Scanner(System.in);

         TP2_Ex5Helper helper = new TP2_Ex5Helper(turma,alunos,uc);

         System.out.println("A pauta da turma e dada por: \n");
         for(int i = 0; i < 5; i++){
             for(int j = 0; j < 5; j ++){
                 System.out.println(turma[i][j] + " ");
             } System.out.println(" ");
         }
         int ucTrocar = 1;
         int alunoATrocar = 1;
         helper.setNota(alunoATrocar,ucTrocar,17); // trocamos a nota de um determinado aluno numa determinada UC.
         System.out.println("Qual aluno que deseja somar as notas e calcular a media?\n");
         int aSomar = input.nextInt();
         System.out.println("A soma e dada por: " + helper.somaNotas(aSomar));
         System.out.println("A media do aluno e dada por: " + helper.mediaNotas(aSomar));
         System.out.println("Qual a UC que deseja ver a media de notas?\n");
         int ucSoma = input.nextInt();
         System.out.println("A media da Unidade Curricular e dada por: " + helper.mediaUC(ucSoma));
         System.out.println("A maior nota da UC escolhida é: " + helper.notaMaisAltaUC(ucSoma));
         System.out.println("Para ver a melhor nota do aluno, prima de 0-4.\n");
         int al = input.nextInt();
         System.out.println("A melhor nota do aluno foi " + helper.maiorNotaAluno(al));
         System.out.println("A partir de que nota quer criar um novo array?.\n");
         int pos = input.nextInt();
         int nota = input.nextInt();
         System.out.println(Arrays.toString(helper.notasAcimaDe(pos, nota))); // poderíamos ter feito a nossa versão de toString, mas para já, não é preciso.
    }
}
