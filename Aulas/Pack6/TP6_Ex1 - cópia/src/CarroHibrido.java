public class CarroHibrido extends Carro implements Combustao, Eletrico, PontosPorKm{

    private double autonomiaEletrica;
    private double autonomiaCombustao;
    private double capCarga;
    private double capDeposito;


    public CarroHibrido(){
        this.autonomiaEletrica = 0;
        this.autonomiaCombustao = 0;
    }

    @Override
    public Carro clone() {
        return null;
    }
}
