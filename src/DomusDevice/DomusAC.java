package DomusDevice;

public class DomusAC extends DomusComplexo{
    
    private int temperaturaAC; // entre 16 e 30
    private ModoAC modoAC;

    protected enum ModoAC{
        ARREFECER, AQUECER, VENTILAR
    }

    public DomusAC(){
        super();
        this.temperaturaAC = 0;
        this.modoAC = ModoAC.VENTILAR;
    }

    public DomusAC(int idObjeto, String marca, String modelo, double consumo, int temperaturaAC, ModoAC modoAC){
        super(idObjeto, marca, modelo, consumo);
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

    public void boostObj(){
        super.setestadoAtual(Estado.BOOST);
        if(this.modoAC == ModoAC.AQUECER){
            this.temperaturaAC = 30;
        } else if(this.modoAC == ModoAC.ARREFECER) {
            this.temperaturaAC = 16;
        }
    }


    // nao sei se aqui a logica das temperaturas faz muito sentido
    public void ecoObj(){ 
        super.setestadoAtual(Estado.ECO);
        if(this.modoAC == ModoAC.AQUECER){
            this.temperaturaAC = 21;
        } else if(this.modoAC == ModoAC.ARREFECER) {
            this.temperaturaAC = 18;
        }
    }

    public DomusAC clone(){
        return new DomusAC(this);
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        DomusAC other = (DomusAC) o;
        return super.equals(o) && 
                this.temperaturaAC == other.temperaturaAC &&
                this.modoAC == other.modoAC;
    }

    public String toString(){
        String result = super.toString() + " | temperatura: " + this.temperaturaAC + " graus " +
                                           " | modo: " + this.modoAC;
        return result; 
    }

    



}  
    /* public void ligaObj(){
        super.setestadoAtual(Estado.ON);
    }

    public void desligaObj(){
        super.setestadoAtual(Estado.OFF);
    }

    public void boostObj(){
        super.setestadoAtual(Estado.BOOST);
    }

    public void ecoObj(){
        super.setestadoAtual(Estado.ECO);
    }

    public DomusAC(){
        super();
    }

    public DomusAC(DomusAC other){
        super(other);
    }

    public DomusAC clone(){
        return new DomusAC(this);
    }
 */



