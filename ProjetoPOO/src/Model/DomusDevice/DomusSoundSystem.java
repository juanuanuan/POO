package Model.DomusDevice;

public class DomusSoundSystem extends ADomusSimples {

    private String estacao; 

    public DomusSoundSystem(){
        super();
        this.estacao = "";
    }

    public DomusSoundSystem(int idObjeto, String marca, String modelo, double consumo, double consumoAtual, String estacao,
        int numAtivacoes, long tempoAcumulado, long momentoLigado, double nivel){
        super(idObjeto, marca, modelo, consumo, Estados.OFF, consumoAtual, numAtivacoes, tempoAcumulado, momentoLigado, nivel);
        this.estacao = estacao; 
    }

    public DomusSoundSystem (DomusSoundSystem other){
        super(other);
        this.estacao = other.getEstacao(); 
    }

    public String getEstacao(){
        return this.estacao; 
    }


    public void setEstacao(String estacao){
        this.estacao = estacao; 
    }

    public DomusSoundSystem clone(){
        return new DomusSoundSystem(this);
    }

    public String toString(){
        return super.toString() + " | Volume: " + getNivel() +
                                  " | Estacao: " + getEstacao();
    }

}
