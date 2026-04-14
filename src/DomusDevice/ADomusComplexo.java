package DomusDevice;

public abstract class ADomusComplexo extends ADomusSimples implements IDomusComplexo{

    public ADomusComplexo(){
        super();
    }

    public ADomusComplexo(int idObjeto, String marca, String modelo, double consumo, double consumoAtual, 
        int numAtivacoes, long tempoAcumulado, long momentoLigado){
        super(idObjeto, marca, modelo, consumo, Estados.OFF, consumoAtual, numAtivacoes, tempoAcumulado, momentoLigado);
    }

    public ADomusComplexo(ADomusComplexo other){
        super(other);
    }

    public abstract ADomusComplexo clone();





    public void boostObj(){
       this.setEstadoAtual(Estados.BOOST);
    }

    public  void ecoObj(){
        this.setEstadoAtual(Estados.ECO);
    }



}

