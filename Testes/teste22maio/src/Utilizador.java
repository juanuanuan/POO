import java.util.Map;

public class Utilizador {
    private int id;
    private String nome;
    private String morada;
    private int numViagens;
    private int dinheiroGasto;
    private int numRegistos;


    public Utilizador(Utilizador other){
        this.id = other.getId(); // só fiz este para funcionar o clone
    }


    public int getId() {
        return this.id;
    }

    public int getNumViagens() {
        return this.numViagens;
    }

    public int getDinheiroGasto() {
        return this.dinheiroGasto;
    }

    public int getNumRegistos() {
        return this.numRegistos;
    }


    public Utilizador clone(){
        return new Utilizador(this);
    }



}
