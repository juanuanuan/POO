package DomusDevice;

public class DomusRegador extends DomusAbstract{
    public void ligaObj(){
        super.setestadoAtual(Estado.ON);
    }

    public void desligaObj(){
        super.setestadoAtual(Estado.OFF);
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




}
