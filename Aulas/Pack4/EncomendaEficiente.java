import java.time.LocalDate;
import java.util.ArrayList;

public class EncomendaEficiente {
    private String nome;
    private long nif;
    private String morada;
    private int numEnc;
    private LocalDate data;
    private ArrayList<LinhaEncomendaEficiente> encomenda;
    //Construtores por Omissão
    public EncomendaEficiente(){
        this.nome = "";
        this.nif = 0;
        this.morada = "";
        this.numEnc = 0;
        this.data = null;
        this.encomenda = new ArrayList<>();
    }

    //Construtor por Paramentos
    public EncomendaEficiente(String nome, long nif, String morada, int numEnc, LocalDate data, ArrayList<LinhaEncomendaEficiente> encomenda){
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.numEnc = numEnc;
        this.data = data;
        this.encomenda = encomenda;
    }

    //Construtor de copia
    public EncomendaEficiente(EncomendaEficiente other){
        this.nome = other.nome;
        this.nif = other.nif;
        this.morada = other.morada;
        this.numEnc = other.numEnc;
        this.data = other.data;
        this.encomenda = other.encomenda;
    }

    //Getters e Setters

    public String getNome() {
        return this.nome;
    }

    public long getNif() {
        return this.nif;
    }

    public String getMorada() {
        return this.morada;
    }

    public int getNumEnc() {
        return this.numEnc;
    }

    public LocalDate getData() {
        return this.data;
    }

    public ArrayList<LinhaEncomendaEficiente> getEncomenda() {
        return this.encomenda;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNif(long nif){
        this.nif = nif;
    }

    public void setMorada(String morada){
        this.morada = morada;
    }

    public void setNumEnc(int numEnc){
        this.numEnc = numEnc;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public void setEncomenda(ArrayList<LinhaEncomendaEficiente> encomenda){
        this.encomenda = encomenda;
    }

    //Clone, Equals e toString
    public EncomendaEficiente clone(){
        return new EncomendaEficiente(this);
    }

    public boolean equalsE(Object o){
        if(o == this) return true;
        if(o == null || this.getClass() == o.getClass()) return false;
        EncomendaEficiente other = (EncomendaEficiente) o;
        return (this.nome == other.nome && this.nif == other.nif && this.morada == other.morada &&
                this.numEnc == other.numEnc && this.data == other.data && this.encomenda == other.encomenda);
    }

    public String toString(){
        return "Nome:" + this.nome + "\n" +
                "NIF: " + this.nif + "\n" +
                "Morada: " + this.morada + "\n" +
                "Numero de Encomenda: " + this.numEnc + "\n" +
                "Data de concenso: " + this.data + "\n" +
                "Encomenda: " + this.encomenda.toString() + "\n";
    }

    //Passamos para as funções auxiliares
     public double calculaValorTotal(EncomendaEficiente encomenda){
        double total = 0;
        for(LinhaEncomendaEficiente linha : this.encomenda){
            total += linha.calculaValorLinhaEnc();
        } return total;
     }

     public double calculaValorDescontoTotal(EncomendaEficiente encomenda){
        double total = 0;
        for(LinhaEncomendaEficiente linha : this.encomenda){
            total += linha.calculaValorDesconto();
        } return total;
     }

     public double totalProdutos(EncomendaEficiente encomenda){
        double total = 0;
        for(LinhaEncomendaEficiente linha : this.encomenda){
            total += linha.getQuantidade();
        } return total;
     }

     public boolean existeProdutoEncomenda(String ref){
        for(LinhaEncomendaEficiente linha : this.encomenda){
            if(linha != null && ref == linha.getReferencia()) return true;
        } return false;
     }

     public void adicionaLinha (LinhaEncomendaEficiente le){
        this.encomenda.add(le);
     }

     public void removeLinha(LinhaEncomendaEficiente le){
        this.encomenda.remove(le);
     }


}
