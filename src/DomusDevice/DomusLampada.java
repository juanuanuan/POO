package DomusDevice;

public class DomusLampada extends DomusAbstract implements DomusComplexo, DomusDevice{

    public void boostObj(){
        super.setestadoAtual(Estado.BOOST);
    }

    public void ecoObj(){
        super.setestadoAtual(Estado.ECO);
    }

}
