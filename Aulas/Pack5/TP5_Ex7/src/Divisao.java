import java.util.ArrayList;
import java.util.List;

public class Divisao {
    private List<Lampada> lampadas;
    private String nome;

    public Divisao(){
        this.lampadas = new ArrayList<>();
        this.nome = "";
    }

    public Divisao(List<Lampada> lampadas, String nome){
        this.lampadas = new ArrayList<>();
        lampadas.forEach(l -> this.lampadas.add(l.clone()));
        this.nome = nome;
    }

    public Divisao(Divisao other){
        this.lampadas = new ArrayList<>();
        other.lampadas.forEach(l -> this.lampadas.add(l.clone()));
        this.nome = other.getNome();

    }


    public void adicionaL(Lampada l){
        this.lampadas.add(l);
    }

    public String getNome() {
        return this.nome;
    }

    public List<Lampada> getLampadas() {
        return this.lampadas;
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Divisao other = (Divisao) o;
        return (this.lampadas.equals(other.lampadas) && this.nome.equals(other.nome));
    }


    public Divisao clone() {
        return new Divisao(this);
    }


    public double getConsumoDivisao(){
        return this.lampadas.stream()
                .mapToDouble(Lampada::getConsumo).sum();
    }


}
