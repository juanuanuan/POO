package Domus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import DomusDevice.ADomusSimples;

public class Casa implements Serializable {

    private HashMap<Integer, Divisao> divisao;
    private int idHost;
    private int idCasa;
    private String morada;
    private String nomeCasa;

    private List<Integer> idGuests; // faltava isto para os guests, implementei os respetivos metodos e tunste tuntse

    public Casa (){
        this.divisao = new HashMap<>();
        this.idHost = -1;
        this.idCasa = -1;
        this.morada = "";
        this.nomeCasa = "";
        this.idGuests = new ArrayList<>();
    }

    public Casa (HashMap<Integer, Divisao> divisao, int idHost, int idCasa, String morada, String nomeCasa){
        this.divisao = divisao;
        this.idHost = idHost;
        this.idCasa = idCasa;
        this.morada = morada;
        this.nomeCasa = nomeCasa;
        this.idGuests = new ArrayList<>(); // uma casa comeca sempre sem hosts 
    }

    public Casa (Casa other){
        this.divisao = new HashMap<>();
        other.divisao.forEach((k,v) -> this.divisao.put(k, v.clone())); // copiar aqui defensivamente
        this.idHost = other.getIdHost();
        this.idCasa = other.getIdCasa();
        this.morada = other.getMorada();
        this.nomeCasa = other.getNomeCasa();
        this.idGuests = new ArrayList<>(other.getIdGuests());

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

    public List<Integer> getIdGuests(){
        return new ArrayList<>(this.idGuests);
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

    public void addGuest(int idGuest){
        this.idGuests.add(idGuest);
    }

    public void removeGuest(int idGuest){
        System.out.println("Antes: " + this.idGuests);
        this.idGuests.remove(Integer.valueOf(idGuest));
        System.out.println("Depois: " + this.idGuests);
    }

    public boolean ehGuest(int idUtilizador){
        return this.idGuests.contains(idUtilizador);
    }

    public double getConsumoMensal(long momentoAtual) {
        return this.divisao.values().stream()
            .flatMap(d -> d.getDispositivos().stream())
            .mapToDouble(d -> d.getConsumoObjeto() * d.getTempoTotal(momentoAtual) / 60.0)
            .sum();
    }

    //FIXME: colocar aqui os metodos que retornam uma casa quaquer


}
