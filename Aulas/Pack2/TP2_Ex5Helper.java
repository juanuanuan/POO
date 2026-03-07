public class TP2_Ex5Helper {
    private int aluno; // total de alunos
    private int uCurricular; // total de UC
    private int[][] turma; // pauta da turma

    public TP2_Ex5Helper(int[][] turma, int alunos, int uCurricular) {
        this.turma = turma; // nao sei se esta certo o construtor da turma. penso que deveria sr feito com um ciclo for e com clone, mas depois vejo isso.
        this.uCurricular = uCurricular;
        this.aluno = alunos;
    }

    public void setNota(int alunos, int uc, int nota){
        this.turma[alunos][uc] = nota;
    }

    public int somaNotas(int aluno){
        int total = 0;
        for(int uc = 0; uc < uCurricular; uc++){
            total += turma[aluno][uc];
        } return total;
    }

    public double mediaNotas(int aluno){
        double total = 0;
        for(int uc = 0; uc < uCurricular; uc++){
            total = somaNotas(aluno);
        } return total/uCurricular;
    }

    public double mediaUC(int uc){
        double total = 0;
        for(int i = 0; i < aluno; i ++ ){
            total += turma[i][uc];

        } return total/aluno;

    }

    public int notaMaisAltaUC(int uc){
        int maior = turma[0][uc];
        for(int i = 0; i < aluno - 1; i ++){
            if(turma[i][uc] < turma[i + 1][uc]){ // para a nota mais baixa basta troca o sinal.
                maior = turma[i + 1][uc];
            }
        } return maior;
    }

    public int maiorNotaAluno(int aluno){
        int maior = turma[aluno][0];
        for(int i = 0; i < uCurricular - 1 ; i ++){
            if(turma[aluno][i] < turma[aluno][i + 1]){
                maior = turma[aluno][i + 1];
            }
        } return maior;
    }
     // para obter o array a partir de uma certa nota, é necessário realizar uma procura binária no array turma.

     public int[] notasAcimaDe(int uc, int notaMinima){
        int contador = 0;
        for(int i = 0; i < aluno; i ++){
            if(turma[i][uc] >= notaMinima) contador ++; // criamos o tamanho do array consoante as notas
        }
        int[] novoarray = new int[contador];
        int posicao = 0;
        for(int j = 0; j < aluno; j ++){
            if(turma[j][uc] >= notaMinima){
                novoarray[posicao] = turma[j][uc]; // se a nota for maior, guardá-mo-la no array.
                posicao ++; // incrementamos para analizar a proxima posicão.
            }
        } return novoarray;
    }










}
