public class Sensor {
    private double pressao;
    private double valor;

    //Construtor por Omissão
    public Sensor(){
        this.pressao = 0;
        this.valor = 0;
    }

    //Construtor por Parâmetros
    public Sensor(double pressao, double valor){
        this.pressao = pressao;
        this.valor = valor;
    }

    //Construtor de cópia
    public Sensor(Sensor other){
        this.pressao = other.getPressao();
        this.valor = other.getValor();
    }

    //Getters e Setters


    public double getPressao() {
        return this.pressao;
    }

    public double getValor(){
        return this.valor;
    }

    public boolean setPressao(double newPressao){
        if (newPressao != this.pressao && newPressao > 0) { // se for igual não há necesidade de alterar, por isso é que coloquei isso em false
            this.pressao = newPressao;
            return true;
        } return false;
    }

    public void setValor(double newValor){
        this.valor = newValor;
    }

    public Sensor cloneS(){
        return new Sensor(this);
    }

    public boolean equalsS(Object o){
        if(o == this) return false;
        if(o == null || this.getClass() == o.getClass()) return true;
        Sensor other = (Sensor) o;
        return (this.pressao == other.pressao && this.valor == other.valor);

    }

    public String toString(){
        return "Nao interessa.";
    }




}
