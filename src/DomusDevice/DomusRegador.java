package DomusDevice;

public class DomusRegador extends ADomusSimples {

    //private int fluxoAgua;
    private int duracaoMinutos; // o que é isto. para que serve

    public DomusRegador(){
        super();
        //this.fluxoAgua = 0;
        this.duracaoMinutos = 0;
    }

    public DomusRegador(int idObjeto, String marca, String modelo, double consumo, double consumoAtual, int fluxoAgua, int duracaoMinutos,
        int numAtivacoes, long tempoAcumulado, long momentoLigado, double nivel){
        super(idObjeto, marca, modelo, consumo, Estados.OFF, consumoAtual, numAtivacoes, tempoAcumulado, momentoLigado, nivel);
        //this.fluxoAgua = fluxoAgua;
        this.duracaoMinutos = duracaoMinutos;
    }

    public DomusRegador(DomusRegador other){
        super(other);
        //this.fluxoAgua = other.getFluxoAgua();
        this.duracaoMinutos = other.getDuracaoMinutos();
    }

    //getters e setters

    /*public int getFluxoAgua(){
        return this.fluxoAgua;
    }

     */

    public int getDuracaoMinutos(){
        return this.duracaoMinutos;
    }

    /*public void setFluxoAgua(int fluxoAgua){
        this.fluxoAgua = fluxoAgua;
    }

     */

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

  /*   public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        DomusRegador other = (DomusRegador) o;
        return super.equals(o);
    } */


}




















    /* public void ligaObj(){
        super.setestadoAtual(Estado.ON);
    public void ligaObj(){
        super.setEstadoAtual(Estado.ON);
    }

    public void desligaObj(){
        super.setEstadoAtual(Estado.OFF);
    }

    public DomusRegador(){
        super();
    }

    public DomusRegador(DomusRegador other){
        super(other);
    }

    public DomusRegador clone(){
        return new DomusRegador(this);
    }

     */





