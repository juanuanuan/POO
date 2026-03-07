import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TP2_Ex2Helper {
    private LocalDate[] datas;
    private int contador;

    public TP2_Ex2Helper(int numDatas){
        this.datas = new LocalDate[numDatas];
        this.contador = 0;
    }

    public void insereData(int dia, int mes, int ano){
        if(contador < datas.length){
            datas[contador] = LocalDate.of(ano, mes, dia);
            contador++;
        }
    }

    public LocalDate[] getDatas(){
        return datas;
    }
    public LocalDate getProxima(){
        return datas[contador - 1];
    }

    public int getContador(){
        return contador;
    }

    public LocalDate dataMaisProxima(LocalDate date) {
        if (contador == 0) return null; // ou seja se a data nao existir, nao deve retornar nada


        LocalDate maisProxima = datas[0];
        long menorDiferenca = Math.abs(ChronoUnit.DAYS.between(date, datas[0]));

        for (int i = 1; i < contador; i++) {
            long diferenca = Math.abs(ChronoUnit.DAYS.between(date, datas[i]));
            if (diferenca < menorDiferenca) {
                diferenca = menorDiferenca;
                maisProxima = datas[i]; // ou seja, a data mais proxima passa a ser a data do array cuja a valor absoluto da diferenca da data introduzida, e a data do array, e menor.
            }

        } return maisProxima;


    }

    public String toString(LocalDate[] datas){
        if(contador == 0) return null;

        String toS = "";

        for(LocalDate date : datas){
            toS += date + ",";
        } return toS;
    }


}





