
import java. util. stream. Collector;
import java.util.stream.Collectors;
import java.util.stream.BaseStream;

public class CarroCombustao extends Carro implements PontosPorKm, Combustao{

    private float capDeposito;
    private float consumo100;
    private float precoLitro;


    public CarroCombustao(){
        super();
        this.capDeposito = 0;
        this.consumo100 = 0;
        this.precoLitro = 0;
    }

    public CarroCombustao(String matricula, String marca, String modelo, int anoFabrico, float velMedia, float autonomia, float totalKms, float capDeposito, float consumo100, float precoLitro){
        super(matricula, marca, modelo, anoFabrico, velMedia, autonomia, totalKms);
        this.capDeposito = capDeposito;
        this.consumo100 = consumo100;
        this.precoLitro = precoLitro;
    }

    public CarroCombustao(CarroCombustao other){
        super(other);
        this.capDeposito = other.getCapDeposito();
        this.consumo100 = other.getConsumo100();
        this.precoLitro = other.getPrecoLitro();
    }

    public float getCapDeposito() {
        return this.capDeposito;
    }

    public float getConsumo100() {
        return this.consumo100;
    }

    public float getPrecoLitro() {
        return this.precoLitro;
    }

    public void setCapDeposito(float capDeposito) {
        this.capDeposito = capDeposito;
    }

    public Carro clone(){
        return new CarroCombustao(this);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(this.getCapDeposito()).append(" | ");
        sb.append(this.getConsumo100()).append(" | ");
        sb.append(this.getPrecoLitro()).append(" | ");

        return sb.toString();
    }


    public int custoRealKm(){
        float res = (this.consumo100 / 100) * this.precoLitro;
        return Math.round(res);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Carro other = (Carro) o;
        return super.equals(o);
    }


    public double pontosPorKm(){
        return this.getTotalKms() / PONTOS;
    }

    public double pontosPorCarro(){
        return this.getTotalKms() * PONTOS;
    }










}
