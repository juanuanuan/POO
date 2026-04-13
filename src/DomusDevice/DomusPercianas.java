package DomusDevice;

public class DomusPercianas extends DomusAbstract{

    private int percentagemAbertura; // 0 'e fechado e 100 aberto completo

    public DomusPercianas(){
        super();
        this.percentagemAbertura = 0; 
    }

    public DomusPercianas(int idObjeto, String marca, String modelo, double consumo, int percentagemAbertura){
        super(idObjeto, marca, modelo, consumo, Estado.OFF);
        this.percentagemAbertura = percentagemAbertura; 
    }

    public DomusPercianas(DomusPercianas other){
        super(other);
        this.percentagemAbertura = other.getPercentagemAbertura();
    }

    //getters e setters 

    public int getPercentagemAbertura(){
        return this.percentagemAbertura; 
    }

    public void setPercentagemAbertura(int percentagemAbertura){
        if(percentagemAbertura >= 0 && percentagemAbertura <= 100)
        this.percentagemAbertura = percentagemAbertura;
    }

    public DomusPercianas clone(){
        return new DomusPercianas(this);
    }

    public String toString(){
        String result = super.toString();
            if(this.percentagemAbertura == 0){
                result += " | fechada!";
            } else {
                result += " | abertura: " + this.percentagemAbertura + "%";
            }
        return result;
}
        
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        DomusPercianas other = (DomusPercianas) o;
        return super.equals(o) && this.percentagemAbertura == other.getPercentagemAbertura();
    }

}




/* public void ligaObj(){
        super.setestadoAtual(Estado.ON);
    }

    public void desligaObj(){
        super.setestadoAtual(Estado.OFF);
    }

    public DomusPercianas(){
        super();
    }

    public DomusPercianas(DomusPercianas other){
        super(other);
    }

    public DomusPercianas clone(){
        return new DomusPercianas(this);
    } */
