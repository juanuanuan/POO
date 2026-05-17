public class Lampada implements Lamp{
    private String marca;
    private String modelo;
    private int id;
    private double consumo;
    private Estado estados;

    public enum Estado{
        ON, OFF, ECO
    }

    public Lampada(){
        this.marca = "";
        this.modelo = "";
        this.id = -1;
        this.consumo = 0;
        this.estados = Estado.OFF;
    }

    public Lampada (String modelo, String marca, int id, double consumo, Estado estados){
        this.modelo = modelo;
        this.marca = marca;
        this.id = id;
        this.consumo = consumo;
        this.estados = estados;
    }

    public Lampada (Lampada other){
        this.marca = other.getMarca();
        this.modelo = other.getModelo();
        this.id = other.getId();
        this.consumo = other.getConsumo();
        this.estados = other.getEstados();
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getId() {
        return this.id;
    }

    public double getConsumo() {
        return this.consumo;
    }

    public Estado getEstados() {
        return this.estados;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public void setEstados(Estado estados) {
        this.estados = estados;
    }

    @Override
    public double calculaConsumo() {
        if (this.estados.equals(Estado.ON))
            return this.consumo * 2.5;
        else if (this.estados.equals(Estado.ECO))
            return this.consumo * 2;
        else
            return 0;
    }

    public Lampada clone(){
        return new Lampada(this);
    }
}
