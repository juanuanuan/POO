public class LinhaEncomendaEficiente {
    private String referencia;
    private String descricao;
    private double preco;
    private double quantidade;
    private double imposto;
    private double desconto;
    /** Vamos seguir a estrutura básica da criação de uma aplicação orientada aos objetos **/

    //Construtor por Omissão
    public LinhaEncomendaEficiente(){
        this.referencia = "";
        this.descricao = "";
        this.preco = 0;
        this.quantidade = 0;
        this.imposto = 0;
        this.desconto = 0;
    }
    //Construtor por parâmetros
    public LinhaEncomendaEficiente (String referencia, String descricao, double preco, double quantidade,
                                    double imposto, double desconto ){

        this.referencia = referencia;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    }

    //Construtor de cópia
    public LinhaEncomendaEficiente(LinhaEncomendaEficiente other){
        this.referencia = other.referencia;
        this.descricao = other.descricao;
        this.preco = other.preco;
        this.quantidade = other.quantidade;
        this.imposto = other.imposto;
        this.desconto = other.desconto;
    }

    //Getters e Setters


    public String getReferencia() {
        return referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getImposto() {
        return imposto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public LinhaEncomendaEficiente clone(){
        return new LinhaEncomendaEficiente (this);
    }

    public boolean equals(Object o){
       if(this == o) return true;
       if( o == null || this.getClass() != o.getClass()) return false;
       LinhaEncomendaEficiente other = (LinhaEncomendaEficiente) o;
       return (this.referencia == other.referencia && this.descricao == other.descricao && this.preco == other.preco
               && this.quantidade == other.quantidade && this.imposto == other.imposto && this.desconto == other.desconto);
    }

    public double calculaValorLinhaEnc() {
        if(this.desconto != 0) {
            return this.preco * this.quantidade + (this.preco * this.quantidade * (this.imposto/100)) - (this.preco * this.quantidade * (this.desconto/100));// supondo o preco por kilo.
        } else return this.preco * this.quantidade + (this.preco * this.quantidade * (this.imposto/100));
    }


    public double calculaValorDesconto(){
        return this.preco * this.desconto/100; // desconto por unidade
    }

    // as funcoes acabam por ser iguais, porque como aqui nao trabalhamos com array e ArraysList, nao ha nada a acrescentar


}
