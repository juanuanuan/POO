package DomusDevice;

public abstract class ADomusComplexo extends ADomusSimples implements IDomusComplexo{

    public ADomusComplexo(){
        super();
    }

    public ADomusComplexo(int idObjeto, String marca, String modelo, double consumo){
        super(idObjeto, marca, modelo, consumo, Estados.OFF);
    }

    public ADomusComplexo(ADomusComplexo other){
        super(other);
    }



    public abstract void boostObj();

    public abstract void ecoObj();



}

