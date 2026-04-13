package DomusDevice;


public abstract class DomusAbstract implements DomusDevice, Comparable<DomusAbstract> {
    private int idObjeto;
    private double consumoObjeto; // consumo em kW/h
    private Estado estadoAtual;
    private String marca;
    private String modelo; // o enunciado pede estes dois atributos

    protected enum Estado{
        ON, OFF, ECO, BOOST
    } // aceitável se apenas os devices herdarem este enum, o que acho que seja o lógico a fazer.

    public DomusAbstract(){
        this.idObjeto      = -1;
        this.consumoObjeto = 0.0;
        this.estadoAtual   = Estado.OFF;
        this.marca         = "";
        this.modelo        = "";
    }

    public DomusAbstract(int idObjeto, String marca, String modelo, double consumoObjeto, Estado estadoAtual){
        this.idObjeto      = idObjeto;
        this.marca         = marca;
        this.modelo        = modelo;
        this.consumoObjeto = consumoObjeto;
        this.estadoAtual   = estadoAtual;

    }

    public DomusAbstract (DomusAbstract other){
        this.idObjeto = other.getIdObjeto();
        this.consumoObjeto = other.getConsumoObjeto();
        this.estadoAtual   = other.getEstadoAtual();
        this.marca = other.getMarca();
        this.modelo = other.getModelo();
    }


    public int getIdObjeto() {
        return this.idObjeto;
    }

    public double getConsumoObjeto() {
        return this.consumoObjeto;
    }

    public Estado getEstadoAtual() {
        return this.estadoAtual;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public void setConsumoObjeto(double consumoObjeto) {
        this.consumoObjeto = consumoObjeto;
    }

    public void setEstadoAtual(Estado estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }


    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        DomusAbstract other = (DomusAbstract) o;
        return (this.idObjeto == other.idObjeto);
    }

    public String toString() {
        return "ID: " + this.idObjeto + " | Marca: " + this.marca +
                " | Modelo: " + this.modelo + " | Consumo: " + this.consumoObjeto +
                "Wh | Estado: " + this.estadoAtual;
}

    public int compareTo(DomusAbstract o) {
        if (this.idObjeto < o.idObjeto) {
            return -1;
        } else if (this.idObjeto > o.idObjeto) {
            return 1;
        } return 0;
    }

    public void ligaObj(){
        this.estadoAtual = Estado.ON;
    }

    public void desligaObj(){
        this.estadoAtual = Estado.OFF;
    }

    @Override
    public abstract DomusAbstract clone();
}




    





