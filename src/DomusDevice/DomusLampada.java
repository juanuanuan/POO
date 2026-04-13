package DomusDevice;

public class DomusLampada extends ADomusComplexo {

    private int intensidade;      // 0 a 100 (percentagem)
    private int temperaturaCorK;  // 2700K a 4000K (0 se não suportar)
    private boolean temCor;       // indica se suporta temperatura de cor

    public DomusLampada() {
        super();
        this.intensidade = 0;
        this.temperaturaCorK = 0;
        this.temCor = false;
    }

    public DomusLampada(int idObjeto, String marca, String modelo, double consumo, int intensidade, int temperaturaCorK, boolean temCor) {
        super(idObjeto, marca, modelo, consumo);
        this.intensidade = intensidade;
        this.temperaturaCorK = temperaturaCorK;
        this.temCor = temCor;
    }

    public DomusLampada(DomusLampada other) {
        super(other);
        this.intensidade = other.getIntensidade();
        this.temperaturaCorK = other.getTemperaturaCorK();
        this.temCor = other.isTemCor();
    }

    // Getters
    public int getIntensidade() {
        return this.intensidade;
    }

    public int getTemperaturaCorK() {
        return this.temperaturaCorK;
    }

    public boolean isTemCor() {
        return this.temCor;
    }

    // Setters
    public void setIntensidade(int intensidade) {
        if (intensidade >= 0 && intensidade <= 100)  // duvida em meter if aqui ou nao
            this.intensidade = intensidade;
    }

    public void setTemperaturaCorK(int temperaturaCorK) {
        if (this.temCor && temperaturaCorK >= 2700 && temperaturaCorK <= 4000)
            this.temperaturaCorK = temperaturaCorK;
    }

    @Override
    public void boostObj() {
        //super.setEstadoAtual(Estado.BOOST);
        this.intensidade = 100;
    }

    @Override
    public void ecoObj() {
        //super.setEstadoAtual(Estados.ECO);
        this.intensidade = 30;
    }

    @Override
    public DomusLampada clone() {
        return new DomusLampada(this);
    }

   @Override
    public String toString() {
        String result = super.toString() + " | Intensidade: " + this.intensidade + "%";
        if (this.temCor) {
            result += " | Cor: " + this.temperaturaCorK + "K";
        }
        return result;
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        DomusLampada other = (DomusLampada) o;
        return super.equals(o); //&&
                //this.intensidade == other.intensidade &&
                //this.temperaturaCorK == other.temperaturaCorK &&
                //this.temCor == other.temCor;
}




}


// deixei isto em comentario, nao sei se precisavas disto ou nao

/*     public void boostObj(){
        super.setestadoAtual(Estado.BOOST);
    public void boostObj(){
        super.setEstadoAtual(Estado.BOOST);
    }

    public void ecoObj(){
        super.setEstadoAtual(Estado.ECO);
    }

    public DomusLampada(){
        super();
    }

    public DomusLampada(DomusLampada other){
        super(other); // na duvida se esta certo.
    }

    public DomusLampada clone(){
        return new DomusLampada(this);
    } */




