package DomusDevice;

public class DomusAC extends ADomusComplexo {

    private int temperaturaAC; // entre 16 e 30
    private ModoAC modoAC;

    public enum ModoAC{
        ARREFECER, AQUECER, VENTILAR
    } // penso seriamente em criar uma classe chamada Estados.java para estados de objetos.

    public DomusAC(){
        super();
        this.temperaturaAC = 0;
        this.modoAC = ModoAC.VENTILAR;
    }

    public DomusAC(int idObjeto, String marca, String modelo, double consumo, double consumoAtual, int temperaturaAC, ModoAC modoAC, int numAtivacoes, long tempoAcumulado, long momentoLigado, double nivel){
        super(idObjeto, marca, modelo, consumo, consumoAtual,numAtivacoes, tempoAcumulado, momentoLigado, nivel );
        this.temperaturaAC = temperaturaAC;
        this.modoAC = modoAC;
    }

    public DomusAC (DomusAC other){
        super(other);
        this.temperaturaAC = other.getTemperaturaAC();
        this.modoAC = other.getModoAC();
    }

    //getters e setters

    public int getTemperaturaAC(){
        return this.temperaturaAC;
    }

    public ModoAC getModoAC(){
        return this.modoAC;
    }

    public void setTemperaturaAC(int temperaturaAC){
        if (temperaturaAC >= 16 && temperaturaAC <= 30){
            this.temperaturaAC = temperaturaAC;
        }
    }

    public void setModoAC(ModoAC modoAC){
        this.modoAC = modoAC;
    }





    // nao sei se aqui a logica das temperaturas faz muito sentido

    // acho que as funções eco e boost não podem estar definidas nem aqui, nem desta maneira

    public DomusAC clone(){
        return new DomusAC(this);
    }

    /* public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        DomusAC other = (DomusAC) o;
        return super.equals(o) &&
                this.temperaturaAC == other.temperaturaAC &&
                this.modoAC == other.modoAC; !!! SEM SENTIDO !!!
    }

     */

    public String toString(){
        return super.toString() + " | temperatura: " + this.temperaturaAC + " graus " +
                                           " | modo: " + this.modoAC;
    }


    public void aquecerAC(){
        this.modoAC = ModoAC.AQUECER;
    }

    public void arrefecerAC(){
        this.modoAC = ModoAC.ARREFECER;
    }












}
