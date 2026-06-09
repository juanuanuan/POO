import java.io.Serializable;

public abstract class Carro implements Serializable {
    private String matricula;


    public Carro(){
        this.matricula = "";
    }

    public Carro(Carro other){
        this.matricula = other.getMatricula();
    }


    public String getMatricula() {
        return this.matricula;
    }


    public abstract Carro clone();

    public abstract double valorAPagar();

}
