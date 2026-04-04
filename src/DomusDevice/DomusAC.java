package DomusDevice;

public class DomusAC extends DomusAbstract implements DomusComplexo, DomusDevice{
    public void ligaObj(){
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


}
