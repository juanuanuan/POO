package DomusDevice;


import DomusDevice.Estados;

public abstract class ADomusSimples implements IDomusSimples, Comparable<ADomusSimples> {
    private int idObjeto;
    private double consumoObjeto; // consumo em kW/h
    private double consumoAtual;
    private Estados estadoAtual;
    private String marca;
    private String modelo; // o enunciado pede estes dois atributos
    // adicionar um private nivel que serviria de volume da coluna, intensidade de uma lampada, fluxo de agua do regador, etc



    public ADomusSimples(){
        this.idObjeto      = -1;
        this.consumoObjeto = 0;
        this.consumoAtual = 0;
        this.estadoAtual = Estados.OFF;
        this.marca         = "";
        this.modelo        = "";
    }

    public ADomusSimples(int idObjeto, String marca, String modelo, double consumoObjeto, Estados estadoAtual, double consumoAtual){
        this.idObjeto      = idObjeto;
        this.marca         = marca;
        this.modelo        = modelo;
        this.consumoObjeto = consumoObjeto;
        this.consumoAtual = consumoAtual;
        this.estadoAtual   = estadoAtual;

    }

    public ADomusSimples(ADomusSimples other){
        this.idObjeto = other.getIdObjeto();
        this.consumoObjeto = other.getConsumoObjeto();
        this.consumoAtual = other.getConsumoAtual();
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

    public double getConsumoAtual() {
        return this.consumoAtual;
    }

    public Estados getEstadoAtual() {
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

    public void setConsumoAtual(double consumoAtual) {
        this.consumoAtual = consumoAtual;
    }

    public void setEstadoAtual(Estados estadoAtual) {
        this.estadoAtual = estadoAtual;
    }



    public void ligaObj() {
        this.estadoAtual = Estados.ON;
    }

    public void desligaObj() {
        this.estadoAtual = Estados.OFF;
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
        ADomusSimples other = (ADomusSimples) o;
        return (this.idObjeto == other.idObjeto);
    }

    public String toString() {
        return "\n" + "| ID: " + getIdObjeto() + "\n" + "| Marca: " + getMarca() + "\n" +
                "| Modelo: " + getModelo() + "\n" + "| Consumo: " + getConsumoObjeto() +
                "Wh " + "\n" + "| Consumo Atual: " + getConsumoAtual() + "Wh/h " + "\n" +
                "| Estado: " + getEstadoAtual() + "\n";
}

    public int compareTo(ADomusSimples o) {
        if (this.idObjeto < o.idObjeto) {
            return -1;
        } else if (this.idObjeto > o.idObjeto) {
            return 1;
        } return 0;
    }



    public abstract ADomusSimples clone();
}




    





