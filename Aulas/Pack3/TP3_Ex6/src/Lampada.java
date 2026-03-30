public class Lampada {
        private String marca;
        private double consumo; // medido em KiloWatts (kW)
        private String corLampada;
        private double precoLampada;
        private Estado estado;
        private double consumoAcumulado;

        public enum Estado{
            ON, OFF, ECO, BOOST;
        }

        public Lampada(){
            this.marca = "";
            this.consumo = 0;
            this.corLampada = "";
            this.precoLampada = 0;
            this.estado = Estado.OFF;
            this.consumoAcumulado = 0;
        }

        public Lampada(String marca, double consumo, String corLampada, double precoLampada, Estado estado, double consumoAcumulado){
            this.marca = marca;
            this.consumo = consumo;
            this.corLampada = corLampada;
            this.precoLampada = precoLampada;
            this.estado = estado;
            this.consumoAcumulado = consumoAcumulado;
        }

        public Lampada (Lampada other){
            this.marca = other.getMarca();
            this.consumo = other.getConsumo();
            this.corLampada = other.getCorLampada();
            this.precoLampada = other.getPrecoLampada();
            this.estado = other.getEstado();
            this.consumoAcumulado = other.getConsumoAcumulado();
        }

    public String getMarca() {
        return this.marca;
    }

    public double getConsumo() {
        return this.consumo;
    }

    public String getCorLampada() {
        return this.corLampada;
    }

    public double getPrecoLampada() {
        return this.precoLampada;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public double getConsumoAcumulado() {
        return this.consumoAcumulado;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public void setCorLampada(String corLampada) {
        this.corLampada = corLampada;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setPrecoLampada(double precoLampada) {
        this.precoLampada = precoLampada;
    }

    public void setConsumoAcumulado(double consumoAcumulado) {
        this.consumoAcumulado = consumoAcumulado;
    }

    public boolean equals(Object o){
            if(o == this) return true;
            if(o == null || this.getClass() != o.getClass()) return false;
            Lampada other = (Lampada) o;
            return (this.marca == other.marca && this.consumo == other.consumo && this.corLampada == other.corLampada &&
                    this.estado == other.estado && this.precoLampada == other.precoLampada);
    }

    public String toString() {
       return "Marca da Lâmpada: " + getMarca() + "\n" +
               "Consumo: " + getConsumo() + "\n" +
               "Cor da Lâmpada: " + getCorLampada() + "\n" +
               "Preço da Lâmpada: " + getPrecoLampada() + "\n" +
               "Estado da Lâmpada: " + getEstado() + "\n" +
               "Consumo acumulado após o último reset: " + getConsumoAcumulado() + "\n";
    }

    public Lampada clone(){
            return new Lampada(this);
    }

    public void lampON(){
            this.estado = Estado.ON;
    }

    public void lampOFF(){
            this.estado = Estado.OFF;
    }

    public void lampBOOST(){
            this.estado = Estado.BOOST;
    }

    public void lampECO(){
            this.estado = Estado.ECO;
    }

    public double totalConsumo() throws InterruptedException {
            while (this.estado != Estado.OFF){
                Thread.sleep(1000);
                double gasto = contadorW();
                this.consumo += gasto;
                this.consumoAcumulado += gasto;
                System.out.println("Consumo feito: " + this.consumo + "\n");
            } return consumo;
    }

    private double contadorW(){
            if(this.estado == Estado.ON){
               return 0.5;
            } else if (this.estado == Estado.BOOST){
                return 0.5 * 3;
            } else if(this.estado == Estado.ECO){
                return 0.5 / 2;
            } else return 0;
    }

    public void resetConsumo(){
            setConsumoAcumulado(0);
    }

    public double periodoConsumo() throws InterruptedException{
            return this.consumoAcumulado;
    }

    





}
