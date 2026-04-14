package DomusDevice;

public class DomusPercianas extends ADomusSimples {

    private int percentagemAbertura; // 0 'e fechado e 100 aberto completo

    public DomusPercianas() {
        super();
        this.percentagemAbertura = 0;
    }

    public DomusPercianas(int idObjeto, String marca, String modelo, double consumo, double consumoAtual, int percentagemAbertura) {
        super(idObjeto, marca, modelo, consumo, Estados.OFF, consumoAtual);
        this.percentagemAbertura = percentagemAbertura;
    }

    public DomusPercianas(DomusPercianas other) {
        super(other);
        this.percentagemAbertura = other.getPercentagemAbertura();
    }

    //getters e setters

    public int getPercentagemAbertura() {
        return this.percentagemAbertura;
    }

    public void setPercentagemAbertura(int percentagemAbertura) {
        if (percentagemAbertura >= 0 && percentagemAbertura <= 100)
            this.percentagemAbertura = percentagemAbertura;
    }

    public DomusPercianas clone() {
        return new DomusPercianas(this);
    }

    public String toString() {
        String result = super.toString();
        if (this.percentagemAbertura == 0) {
            result += "| Perciana Fechada";
        } else {
            result += "| abertura: " + getPercentagemAbertura() + "%";
        }
        return result;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DomusPercianas other = (DomusPercianas) o;
        return super.equals(o); //&& this.percentagemAbertura == other.getPercentagemAbertura();
    }






}



