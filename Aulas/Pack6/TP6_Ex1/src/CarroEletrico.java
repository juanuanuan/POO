public class CarroEletrico extends Carro{
    private float capCarga;
    private float consumo100;
    private float precoKW;

    public CarroEletrico(){
        super();
        this.capCarga = 0;
        this.consumo100 = 0;
        this.precoKW = 0;
    }

    public CarroEletrico(String matricula, String marca, String modelo, int anoFabrico, float velMedia, float autonomia, float totalKms, float capCarga, float consumo100, float precoKW){
        super(matricula, marca, modelo, anoFabrico, velMedia, autonomia, totalKms);
        this.capCarga = capCarga;
        this.consumo100 = consumo100;
        this.precoKW = precoKW;
    }

    public CarroEletrico(CarroEletrico other){
        super(other);
        this.capCarga = other.getCapCarga();
        this.consumo100 = other.getConsumo100();
        this.precoKW = other.getPrecoKW();
    }

    public float getCapCarga() {
        return this.capCarga;
    }

    public float getConsumo100() {
        return this.consumo100;
    }

    public float getPrecoKW() {
        return this.precoKW;
    }

    public void setCapCarga(float capCarga) {
        this.capCarga = capCarga;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(this.getCapCarga()).append(" | ");
        sb.append(this.getConsumo100()).append(" | ");
        sb.append(this.getPrecoKW()).append(" | ");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Carro other = (Carro) o;
        return super.equals(o);
    }

    @Override
    public CarroEletrico clone(){
        return new CarroEletrico(this);
    }

    public int custoRealKm(){
        float res = (this.consumo100 / 100) * this.precoKW;
        return Math.round(res);
    }



}
