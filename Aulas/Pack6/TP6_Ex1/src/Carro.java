import java.util.ArrayList;
import java.util.List;


public abstract class Carro implements Comparable<Carro>{
    private String matricula;
    private String marca;
    private String modelo;
    private int anoFabrico;
    private float velMedia;
    private float autonomia;
    private float totalKms;

    public Carro() {
        this.matricula = "";
        this.marca = "";
        this.modelo = "";
        this.anoFabrico = 0;
        this.velMedia = 0;
        this.autonomia = 0;
        this.totalKms = 0;
    }

    public Carro(String matricula, String marca, String modelo, int anoFabrico, float velMedia, float autonomia, float totalKms) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabrico = anoFabrico;
        this.velMedia = velMedia;
        this.autonomia = autonomia;
        this.totalKms = totalKms;
    }

    public Carro(Carro other) {
        this.matricula = other.getMatricula();
        this.marca = other.getMarca();
        this.modelo = other.getModelo();
        this.anoFabrico = other.getAnoFabrico();
        this.velMedia = other.getVelMedia();
        this.autonomia = other.getAutonomia();
        this.totalKms = other.getTotalKms();
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getAnoFabrico() {
        return this.anoFabrico;
    }

    public float getVelMedia() {
        return this.velMedia;
    }

    public float getAutonomia() {
        return this.autonomia;
    }

    public float getTotalKms() {
        return this.totalKms;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoFabrico(int anoFabrico) {
        this.anoFabrico = anoFabrico;
    }

    public void setVelMedia(float velMedia) {
        this.velMedia = velMedia;
    }

    public void setAutonomia(float autonomia) {
        this.autonomia = autonomia;
    }

    public void setTotalKms(float totalKms) {
        this.totalKms = totalKms;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Carro other = (Carro) o;
        return this.matricula.equals(other.matricula); // só usei a matrícula porque um carro é apenas distinguível pela sua matrícula, podem usar todas as instâncias(não está errado!)
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getMatricula()).append(" | ");
        sb.append(this.getMarca()).append(" | ");
        sb.append(this.getModelo()).append(" | ");
        sb.append(this.getAnoFabrico()).append(" | ");
        sb.append(this.getVelMedia()).append(" | ");
        sb.append(this.getAutonomia()).append(" | ");
        sb.append(this.getTotalKms()).append(" | ");

        return sb.toString();

    }

    public abstract Carro clone();

    public abstract int custoRealKm();


    public boolean existeCarro() {
        return this.getMatricula() != null;
    }

    public int compareTo(Carro other){
       return Float.compare(this.getTotalKms(), other.getTotalKms());
    }







}
