package Model.DomusDevice;

public class DomusPercianas extends ADomusSimples {


    public DomusPercianas() {
        super();
    }

    public DomusPercianas(int idObjeto, String marca, String modelo, double consumo, double consumoAtual,
        int numAtivacoes, long tempoAcumulado, long momentoLigado, double nivel) {
        super(idObjeto, marca, modelo, consumo, Estados.OFF, consumoAtual, numAtivacoes, tempoAcumulado, momentoLigado, nivel);
    }

    public DomusPercianas(DomusPercianas other) {
        super(other);
    }




    public DomusPercianas clone() {
        return new DomusPercianas(this);
    }

    public String toString() {
        String result = super.toString();
        if (getNivel()== 0) {
            result += "| Perciana Fechada";
        } else {
            result += "| abertura: " + getNivel() + "%";
        }
        return result;
    }

}



