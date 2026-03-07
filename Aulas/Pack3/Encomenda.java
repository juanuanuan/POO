import java.time.LocalDate;

public class Encomenda {
    private LinhasEncomenda[] le;
    private String nome;
    private String morada;
    private int nif;
    private long numEnc;
    private LocalDate data;

    public Encomenda(LinhasEncomenda[] le, String nome, String morada, int nif, long numEnc, LocalDate data){
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.numEnc = numEnc;
        this.data = data;
        this.le = new LinhasEncomenda[le.length];
        for(int i = 0; i < le.length; i++){
            this.le[i] = le[i].clone();
        }
    }

    public String getNome(){
        return this.nome;
    }
    public int getNif(){
        return this.nif;
    }
    public long getNumEnc(){
        return this.numEnc;
    }
    public LocalDate getData() {
        return this.data;
    }
    public String getMorada() {
        return morada;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumEnc(long numEnc) {
        this.numEnc = numEnc;
    }
    public void setLe(LinhasEncomenda[] le) {
        this.le = new LinhasEncomenda[le.length];
        for(int i = 0; i < le.length; i ++){
            this.le[i] = (LinhasEncomenda) le[i].clone();
        }
    }

    public Encomenda(Encomenda other){
        this.nome = other.nome;
        this.data = other.data;
        this.nif = other.nif;
        this.numEnc = other.numEnc;
        this.nome = other.nome;
        this.morada = other.morada;
        this.le = new LinhasEncomenda [other.le.length];
        for(int i = 0; i < other.le.length; i++){
            this.le[i] = other.le[i].clone();
        }
    }

    public LinhasEncomenda[] getLe(){
        LinhasEncomenda[] copia = new LinhasEncomenda[this.le.length];
        for(int i = 0; i < this.le.length; i++){
            copia[i] = this.le[i].clone();
        } return copia;
    }


    public Encomenda cloneE(){
        return new Encomenda(this);
    }

    public String toStringA(){
        return "(" + nome + " " + morada + " " + nif + " " + numEnc + " " + data + ")";
    }


    public boolean equalsE(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Encomenda enc = (Encomenda) o;
        if(this.le.length != enc.le.length) return false;
        for(int i = 0; i < this.le.length; i ++){
            if(!this.le[i].equals(enc.le[i])) return false;
        }
        return (this.nome == enc.nome && this.morada == enc.morada && this.nif == enc.nif && this.numEnc == enc.numEnc && this.data == enc.data); // podiamos usar o ".equals()" para uma maior estabilidade do programa, mm assim usei o "==".
    }

    public double calculaOValorTotal(){
        double total = 0;
        for(LinhasEncomenda l : this.le){
            total += l.calculaValorLinhaEnc();
        } return total;
    }

    public double somaDescontos(){
        double totalDesconto = 0;
        for(LinhasEncomenda desconto : this.le){
            totalDesconto += desconto.calculaValorDesconto();

        }
        return totalDesconto;
    }

    public float totalProdutos(){
        float totalProdutos = 0;
        for(LinhasEncomenda produtos : this.le){
            totalProdutos += produtos.getQuantidade();
        } return totalProdutos;
    }

    public boolean existeProduto(String ref){
        for(LinhasEncomenda referencia : this.le){
            if(referencia.getReferencia().equals(ref)) return true;
        } return false;
    }

    public void adicionaLinha(LinhasEncomenda novaLinha){
        LinhasEncomenda[] newarr = new LinhasEncomenda[le.length + 1];
        for(int i = 0; i < le.length + 1; i ++){
            newarr[i] = this.le[i].clone();
        }
        newarr[this.le.length] = novaLinha.clone();
        this.le = newarr;
    }




}
