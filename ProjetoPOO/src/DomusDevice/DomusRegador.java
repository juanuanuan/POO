package DomusDevice;

public class DomusRegador extends ADomusSimples {

    private int duracaoMinutos; // o que é isto. para que serve

    public DomusRegador(){
        super();
        this.duracaoMinutos = 0;
    }

    public DomusRegador(int idObjeto, String marca, String modelo, double consumo, double consumoAtual, int duracaoMinutos,
        int numAtivacoes, long tempoAcumulado, long momentoLigado, double nivel){
        super(idObjeto, marca, modelo, consumo, Estados.OFF, consumoAtual, numAtivacoes, tempoAcumulado, momentoLigado, nivel);
        this.duracaoMinutos = duracaoMinutos;
    }

    public DomusRegador(DomusRegador other){
        super(other);
        this.duracaoMinutos = other.getDuracaoMinutos();
    }


    public int getDuracaoMinutos(){
        return this.duracaoMinutos;
    }


    public void setDuracaoMinutos(int duracaoMinutos){
        this.duracaoMinutos = duracaoMinutos;
    }

    public DomusRegador clone(){
        return new DomusRegador(this);
    }

    public String toString(){
        return super.toString() + " | Fluxo de água: " + getNivel() +
                                  " | Duração em minutos: " + getDuracaoMinutos();

    }



}






