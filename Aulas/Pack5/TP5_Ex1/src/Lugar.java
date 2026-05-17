import java.util.List;

public class Lugar {
    private String matricula;
    private String proprietario;
    private String marca;
    private String modelo;
    private double minutos;
    private Estado estado;
    public enum Estado{
        Ocupado, Vazio;
    }

    public Lugar(){
        this.matricula = "";
        this.proprietario = "";
        this.marca = "";
        this.modelo = "";
        this.minutos = 0;
        this.estado = Estado.Vazio;

    }

    public Lugar (String matricula, String proprietario, String marca, String modelo, double minutos,  Estado estado){
        this.matricula = matricula;
        this.proprietario = proprietario;
        this.marca = marca;
        this.modelo = modelo;
        this.minutos = minutos;
        this.estado = estado;
    }

    public Lugar(Lugar other){
        this.matricula = other.getMatricula();
        this.proprietario = other.getProprietario();
        this.marca = other.getMarca();
        this.estado = other.getEstado();
        this.modelo = other.getModelo();
        this.minutos = other.getMinutos();
    }

    public String getMatricula() {
        return this.matricula;
    }

    public double getMinutos() {
        return this.minutos;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getProprietario() {
        return this.proprietario;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Lugar clone(){
        return new Lugar(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getMatricula()).append("\n");
        sb.append(getMarca()).append("\n");
        sb.append(getModelo()).append("\n");
        sb.append(getMinutos()).append("\n");
        sb.append(getProprietario()).append("\n");
        sb.append(getEstado()).append("\n");

        return sb.toString();
    }
}
