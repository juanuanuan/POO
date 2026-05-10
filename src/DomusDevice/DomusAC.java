package DomusDevice;

public class DomusAC extends ADomusComplexo implements IDomusAC{

    private int temperaturaAC; // entre 16 e 30
    private ModoAC modoAC;

    public enum ModoAC{
        ARREFECER, AQUECER, VENTILAR
    }

    public DomusAC(){
        super();
        this.temperaturaAC = 0;
        this.modoAC = ModoAC.VENTILAR;
    }

    public DomusAC(int idObjeto, String marca, String modelo, double consumo, double consumoAtual, int numAtivacoes, long tempoAcumulado, long momentoLigado, double nivel, int temperaturaAC, ModoAC modoAC){
        super(idObjeto, marca, modelo, consumo, consumoAtual,numAtivacoes, tempoAcumulado, momentoLigado, nivel);
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



    public DomusAC clone(){
        return new DomusAC(this);
    }


    public String toString(){
        return super.toString() + " | temperatura: " + this.temperaturaAC + " graus " +
                                           " | modo: " + this.modoAC;
    }















}
