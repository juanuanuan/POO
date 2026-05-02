package Domus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import DomusDevice.ADomusSimples;

public class Casa implements Serializable {
    // Vamos criar um HashMap para ser mais fácil adicionar, remover e até mesmo aceder às divisões.
    // Presumindo que não vai ser necessário iterar todas as divisões com alta precisão e rapidez, é melhor um HashMap do que um ArrayList ou LinkedList.
    private HashMap<Integer, Divisao> divisao;
    private int idHost;
    private int idCasa;
    private String morada;
    private String nomeCasa;

    public Casa (){
        this.divisao = new HashMap<>();
        this.idHost = -1;
        this.idCasa = -1;
        this.morada = "";
        this.nomeCasa = "";
    }

    public Casa (HashMap<Integer, Divisao> divisao, int idHost, int idCasa, String morada, String nomeCasa){
        this.divisao = divisao;
        this.idHost = idHost;
        this.idCasa = idCasa;
        this.morada = morada;
        this.nomeCasa = nomeCasa;
    }

    public Casa (Casa other){
        this.divisao = new HashMap<>();
        other.divisao.forEach((k,v) -> this.divisao.put(k, v.clone())); // copiar aqui defensivamente
        this.idHost = other.getIdHost();
        this.idCasa = other.getIdCasa();
        this.morada = other.getMorada();
        this.nomeCasa = other.getNomeCasa();

    }

    public HashMap<Integer, Divisao> getDivisao() {
        return new HashMap<>(this.divisao); // alterei para nao devolver a referencia direta 
    }

    public int getIdHost() {
        return this.idHost;
    }

    public int getIdCasa() {
        return this.idCasa;
    }

    public String getMorada() {
        return this.morada;
    }

    public String getNomeCasa() {
        return this.nomeCasa;
    }

    public void setIdHost(int idHost) {
        this.idHost = idHost;
    }

    public void setIdCasa(int idCasa){
        this.idCasa = idCasa;
    }


    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Casa other = (Casa) o;
        return (this.idHost == other.idHost && this.divisao.equals(other.divisao));
    }

    public String toString(){
        return  "ID do Host: " + getIdHost() + "\n" +
                "ID da Casa: " + getIdCasa() + "\n" +
                "Morada: " + getMorada() + "\n" +
                "Nome Associado: " + getNomeCasa() + "\n" +
                "Lista de Divisões Associadas: " + "\n" + getDivisao();


    }

    public void addDiv(Divisao div){
        divisao.put(div.getIdDivisao(), div);

    }

    public Casa clone(){
        return new Casa(this);
    }

    public double getConsumoTotal() {
        return this.divisao.values().stream()
            .flatMap(d -> d.getDispositivos().stream())
            .mapToDouble(d -> d.getConsumoAtual() * d.getMultiplicadorConsumo())
            .sum();
    }

    public List<ADomusSimples> top3DevicesPorTempo(long momentoAtual) {
        return this.divisao.values().stream()
            .flatMap(d -> d.getDispositivos().stream())
            .sorted(Comparator.comparingLong(d -> -d.getTempoTotal(momentoAtual)))
            .limit(3)
                .map(ADomusSimples::clone)
            .collect(Collectors.toList());
    }

    public List<ADomusSimples> top3DevicesPorAtivacoes() {
        return this.divisao.values().stream()
            .flatMap(d -> d.getDispositivos().stream())
            .sorted(Comparator.comparingInt(d -> -d.getNumAtivacoes()))
            .limit(3)
                .map(ADomusSimples::clone)
            .collect(Collectors.toList());
    }

    public ADomusSimples top1DeviceConsumo(){
        return this.divisao.values().stream()
                .flatMap(d -> d.getDispositivos().stream())
                .max(Comparator.comparingDouble(ADomusSimples::getConsumoAtual))
                .map(ADomusSimples::clone)
                .orElse(null);
    }

    public void removeDiv(int idDivisao) {
        this.divisao.remove(idDivisao);
    }

    public void desligaAllDevice(long momentoAtual){
        this.divisao.values().stream()
                .flatMap(d -> d.getDispositivos().stream())
                .forEach(d -> d.desligaObj(momentoAtual));
    }


}
