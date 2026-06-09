public class CarroHibrido extends CarroCombustao implements Eletrico {
    private double nivelBateria;


    public double getNivelBateria() {
        return this.nivelBateria;
    }

    @Override
    public CarroHibrido clone() {
        return null;
    }

    @Override
    public double valorAPagar() {
        return 0;
    }


    public CarroHibrido(){
        super();
    }

    // a ideia desta classe e idêntica à classe CarroCombustao. clones mal definidos (apenas feitos para serem chamados noutras classes), getters, setters, etc...


}
