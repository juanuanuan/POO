package DomusDevice;


public abstract class ADomusSimples implements IDomusSimples, Comparable<ADomusSimples> {
    private int idObjeto;
    private double consumoObjeto; // consumo em kW/h
    private double consumoAtual;
    private Estados estadoAtual;
    private String marca;
    private String modelo;
    private int numAtivacoes;
    private long tempoAcumulado; // tempo total
    private long momentoLigado; // momento em que foi ligado
    private double nivel;



    public ADomusSimples(){
        this.idObjeto       = -1;
        this.consumoObjeto  = 0;
        this.consumoAtual   = 0;
        this.estadoAtual    = Estados.OFF;
        this.marca          = "";
        this.modelo         = "";
        this.numAtivacoes   = 0; 
        this.tempoAcumulado = 0;
        this.momentoLigado  = 0;
        this.nivel = 0;
    }

    public ADomusSimples(int idObjeto, String marca, String modelo, double consumoObjeto, Estados estadoAtual, 
                         double consumoAtual, int numAtivacoes, long tempoAcumulado, long momentoLigado, double nivel){
        
        this.idObjeto      = idObjeto;
        this.marca         = marca;
        this.modelo        = modelo;
        this.consumoObjeto = consumoObjeto;
        this.consumoAtual  = consumoAtual;
        this.estadoAtual   = estadoAtual;
        this.numAtivacoes  = numAtivacoes;
        this.tempoAcumulado = tempoAcumulado; 
        this.momentoLigado = momentoLigado;
        this.nivel = nivel;

    }

    public ADomusSimples(ADomusSimples other){
        this.idObjeto = other.getIdObjeto();
        this.consumoObjeto = other.getConsumoObjeto();
        this.consumoAtual = other.getConsumoAtual();
        this.estadoAtual   = other.getEstadoAtual();
        this.marca = other.getMarca();
        this.modelo = other.getModelo();
        this.numAtivacoes  = other.getNumAtivacoes();
        this.tempoAcumulado = other.getTempoAcumulado(); 
        this.momentoLigado = other.getMomentoLigado();
        this.nivel = other.getNivel();
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

    public int getNumAtivacoes() {
        return this.numAtivacoes;
    }

    public long getTempoAcumulado(){
        return this.tempoAcumulado;
    }

    public long getMomentoLigado(){
        return this.momentoLigado;
    }

    public double getNivel() {
        return this.nivel;
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

    public void setNumAtivacoes(int numAtivacoes){
        this.numAtivacoes = numAtivacoes;
    }

    public void setTempoAcumulado(long tempoAcumulado){
        this.tempoAcumulado = tempoAcumulado;
    }

    public void setMomentoLigado(long momentoLigado){
        this.momentoLigado = momentoLigado;
    }

    public void setNivel(double nivel) {
        if(nivel >= 0 && nivel <= 100) {
            this.nivel = nivel;
        }
    }

    public void ligaObj(long momentoAtual) {
        this.estadoAtual = Estados.ON;
        this.momentoLigado = momentoAtual;
        numAtivacoes++;

    }

    public void desligaObj(long momentoAtual) {
        if (this.estadoAtual != Estados.OFF && this.momentoLigado >= 0) {
            this.tempoAcumulado += momentoAtual - this.momentoLigado;
        }
        this.momentoLigado = -1;
        this.estadoAtual = Estados.OFF;
    }

    public long getTempoTotal(long momentoAtual) {
        if (this.estadoAtual != Estados.OFF && this.momentoLigado > 0) {
            return this.tempoAcumulado + (momentoAtual - this.momentoLigado);
        }
        return this.tempoAcumulado;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    @Override
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


    public double getMultiplicadorConsumo(){
        switch(this.estadoAtual){
            case OFF -> {return 0.0;}
            case ON -> {return 1.0;}
            case ECO -> {return 0.6;}
            case BOOST -> {return 1.5;}
            default -> {return 1.0;}
        }
    }
}




    





