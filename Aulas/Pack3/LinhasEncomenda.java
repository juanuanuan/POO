public class LinhasEncomenda {
    private String referencia;
    private String descricao;
    private float preco;
    private float quantidade;
    private float imposto;
    private float desconto;

    public LinhasEncomenda(String referencia, String descricao, float preco,
                           float quantidade, float imposto, float desconto) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    }

    public String toString() {
        return "(" + referencia + " " + descricao + " " + preco + "EUR " + quantidade + "Kg " + imposto + "% " + desconto + "% " + ")";
    }

    public LinhasEncomenda(LinhasEncomenda other){
        this.referencia = other.referencia;
        this.descricao = other.descricao;
        this.preco = other.preco;
        this.quantidade = other.quantidade;
        this.imposto = other.imposto;
        this.desconto = other.desconto;
    }

    public String getReferencia(){
        return this.referencia;

    }

    public String getDescricao(){
        return this.descricao;
    }

    public float getPreco(){
        return this.preco;

    }

    public float getQuantidade(){
        return this.quantidade;
    }

    public float getImposto(){
        return this.imposto;

    }

    public float getDesconto(){
        return this.desconto;
    }

    public void setReferencia(String referencia){
        this.referencia = referencia;

    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImposto(float imposto) {
        this.imposto = imposto;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        LinhasEncomenda lE = (LinhasEncomenda) o;
        return (this.referencia == lE.referencia && this.descricao == lE.descricao && this.preco == lE.preco &&
        this.quantidade == lE.quantidade && this.imposto == lE.imposto && this.desconto == lE.desconto);

    }

    public LinhasEncomenda clone(){
        return new LinhasEncomenda(this);
    }

    // ate aqui, estao definidos todos os metodos especiais que eram obrigatorios definir.
    // passamos a definir os metodos auxiliares para a resolucao do programa.

    public double calculaValorLinhaEnc() {
        if(this.desconto != 0) {
            return this.preco * this.quantidade + (this.preco * this.quantidade * (this.imposto/100)) - (this.preco * this.quantidade * (this.desconto/100));// supondo o preco por kilo.
        } else return this.preco * this.quantidade + (this.preco * this.quantidade * (this.imposto/100));
    }


    public double calculaValorDesconto(){
        return this.preco * this.desconto/100; // desconto por unidade
    }


}
