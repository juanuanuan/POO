package DomusDevice;

public class DomusLampada extends ADomusComplexo {

   // private int intensidade;      // 0 a 100 (percentagem)
    private int temperaturaCorK;  // 2700K a 4000K (0 se não suportar)
    private boolean temCor;       // indica se suporta temperatura de cor

    public DomusLampada() {
        super();
        //this.intensidade = 0;
        this.temperaturaCorK = 0;
        this.temCor = false;
    }

    public DomusLampada(int idObjeto, String marca, String modelo, double consumo, double consumoAtual, int temperaturaCorK, boolean temCor, int numAtivacoes, long tempoAcumulado, long momentoLigado, double nivel) {
        super(idObjeto, marca, modelo, consumo, consumoAtual, numAtivacoes, tempoAcumulado, momentoLigado, nivel);
       // this.intensidade = intensidade;
        this.temperaturaCorK = temperaturaCorK;
        this.temCor = temCor;
    }

    public DomusLampada(DomusLampada other) {
        super(other);
        //this.intensidade = other.getIntensidade();
        this.temperaturaCorK = other.getTemperaturaCorK();
        this.temCor = other.isTemCor();
    }

    // Getters
    /*public int getIntensidade() {
        return this.intensidade;
    }

     */

    public int getTemperaturaCorK() {
        return this.temperaturaCorK;
    }

    public boolean isTemCor() {
        return this.temCor;
    }

    // Setters
    /* public void setIntensidade(int intensidade) {
        if (intensidade >= 0 && intensidade <= 100)  // duvida em meter if aqui ou nao
            this.intensidade = intensidade;
    }

     */

    public void setTemperaturaCorK(int temperaturaCorK) {
        if (this.temCor && temperaturaCorK >= 2700 && temperaturaCorK <= 4000)
            this.temperaturaCorK = temperaturaCorK;
    }

    @Override
    public void boostObj() {
        super.boostObj();
        setNivel(100);
    }

    @Override
    public void ecoObj() {
        super.ecoObj();
        setNivel(30);
    }

    @Override
    public DomusLampada clone() {
        return new DomusLampada(this);
    }

   @Override
    public String toString() {
        String result = super.toString() + "| Intensidade: " + getNivel() + "%";
        if (this.temCor) {
            result += "| Cor: " + getTemperaturaCorK() + "K";
        }
        return result;
    }




}
