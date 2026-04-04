package DomusDevice;

public class DomusPercianas extends DomusAbstract{

    public void ligaObj(){
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
    }




}
