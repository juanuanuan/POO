package DomusDevice;

public abstract class DomusComplexo extends DomusAbstract implements IDomusComplexo{

    public DomusComplexo(){
        super();
    }

    public DomusComplexo(int idObjeto, String marca, String modelo, double consumo){
        super(idObjeto, marca, modelo, consumo, Estado.OFF);
    }

    public DomusComplexo(DomusComplexo other){
        super(other);
    }



    public abstract void boostObj();

    public abstract void ecoObj();



}

