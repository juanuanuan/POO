package DomusDevice;


public abstract class DomusAbstract implements DomusDevice, Comparable<DomusAbstract> {
    private int idObjeto;
    private double consumoObjeto; // consumo em kW/h
    private Estado estadoAtual;
    
    protected enum Estado{
        ON, OFF, ECO, BOOST
    }

    

    public DomusAbstract(){
        this.consumoObjeto = 0;
        this.estadoAtual = Estado.OFF;
    }

    public DomusAbstract(int idObjeto, double consumoObjeto, Estado estadoAtual){
        this.idObjeto = idObjeto;
        this.consumoObjeto = consumoObjeto;
        this.estadoAtual = estadoAtual;

    }

    public DomusAbstract (DomusAbstract other){
        this.idObjeto = other.getIdObjeto();
        this.consumoObjeto = other.getConsumoObjeto();
        this.estadoAtual = other.getestadoAtual();
    }

    public int getIdObjeto() {
        return this.idObjeto;
    }

    public double getConsumoObjeto() {
        return this.consumoObjeto;
    }

    public Estado getestadoAtual() {
        return this.estadoAtual;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public void setConsumoObjeto(double consumoObjeto) {
        this.consumoObjeto = consumoObjeto;
    }

    public void setestadoAtual(Estado estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        DomusAbstract other = (DomusAbstract) o;
        return (this.idObjeto == other.idObjeto);
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







    




}
