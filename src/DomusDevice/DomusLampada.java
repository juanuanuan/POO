package DomusDevice;

public class DomusLampada extends DomusAbstract implements DomusComplexo, DomusDevice{

    public void boostObj(){
        super.setestadoAtual(Estado.BOOST);
    }

    public void ecoObj(){
        super.setestadoAtual(Estado.ECO);
    }

    public DomusLampada(){
        super();
    }

    public DomusLampada(DomusLampada other){
        super(other); // na duvida se esta certo.
    }

    public DomusLampada clone(){
        return new DomusLampada(this);
    }


}
