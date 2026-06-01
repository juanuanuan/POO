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
        HashMap<Integer, Divisao> copia = new HashMap<>();
        this.divisao.forEach((id, d) -> copia.put(id, d.clone()));
        return copia;
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

    public void setNomeCasa(String nomeCasa) {
        this.nomeCasa = nomeCasa;
    }

    public void setIdGuests(List<Integer> idGuests) {
        this.idGuests = idGuests;
    }

    public void setDivisao(HashMap<Integer, Divisao> divisao) {
        this.divisao = new HashMap<>();
        divisao.forEach((id, d) -> this.divisao.put(id, d.clone()));
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Casa other = (Casa) o;
        return (this.idCasa == other.idCasa);
    }

    public String toString(){
        return  "ID do Host: " + getIdHost() + "\n" +
                "ID da Casa: " + getIdCasa() + "\n" +
                "Morada: " + getMorada() + "\n" +
                "Nome Associado: " + getNomeCasa() + "\n" +
                "Lista de Divisões Associadas: " + "\n" + getDivisao();


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

    public List<ADomusSimples> top3DevicesPorTempoCasa(long momentoAtual) {
        return this.divisao.values().stream()
            .flatMap(d -> d.getDispositivos().stream())
            .sorted(Comparator.comparingLong(d -> -d.getTempoTotal(momentoAtual)))
            .limit(3)
                .map(ADomusSimples::clone)
            .collect(Collectors.toList());
    }

    public List<ADomusSimples> top3DevicesPorAtivacoesCasa() {
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


    public void desligaAllDevice(long momentoAtual){
        this.divisao.values().stream()
                .flatMap(d -> d.getDispositivos().stream())
                .forEach(d -> d.desligaObj(momentoAtual));
    }

    public void addGuest(int idGuest){
        this.idGuests.add(idGuest);
    }

    public void removeGuest(int idGuest){
        this.idGuests.remove(Integer.valueOf(idGuest));
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

    public void ecoDevice(int idDivisao, int idDevice){
        this.divisao.get(idDivisao).ecoDevice(idDevice);
    }

    public void boostDevice(int idDivisao, int idDevice){
        this.divisao.get(idDivisao).boostDevice(idDevice);

    }

    public void ligaDispositivo(int idDivisao, int idDevice, long tempoAtual) {
        this.divisao.get(idDivisao).ligaDispositivo(idDevice, tempoAtual);
    }

    public void desligaDispositivo(int idDivisao, int idDevice, long tempoAtual) {
        this.divisao.get(idDivisao).desligaDispositivo(idDevice, tempoAtual);
    }

    public String listaDivisoes() {
        return this.divisao.values().stream()
                .map(Divisao::toString)
                .collect(Collectors.joining("\n"));
    }

    public String listaDispositivos(int idDivisao) {
        return this.divisao.get(idDivisao).listaDispositivos();
    }

    public void adicionaDivisao(Divisao div) {
        this.divisao.put(div.getIdDivisao(), div.clone());
    }

    public void removeDiv(int idDivisao) {
        this.divisao.remove(idDivisao);
    }

    public void adicionaDispositivo(int idDivisao, ADomusSimples device){
        this.divisao.get(idDivisao).addObj(device.clone());
    }

    public void aquecer(int idDivisao, int idDevice){
        this.divisao.get(idDivisao).aquecer(idDevice);
    }

    public void arrefecer(int idDivisao, int idDevice){
        this.divisao.get(idDivisao).arrefecer(idDevice);
    }

    public void ventilar(int idDivisao, int idDevice){
        this.divisao.get(idDivisao).ventilar(idDevice);
    }

    public void setTemperatura(int idDivisao, int idDevice, int temperatura){
        this.divisao.get(idDivisao).setTemperatura(idDevice, temperatura);
    }

    public List<ADomusSimples> top3DevicesPorTempoDivisao(int idDivisao) {
        return this.divisao.get(idDivisao).top3DevicesPorTempoDivisao();
    }

    public List<ADomusSimples> top3DevicesPorAtivacoesDivisao(int idDivisao) {
        return this.divisao.get(idDivisao).top3DevicesPorAtivacoesDivisao();
    }

    public void setNivelDevice(int idDivisao, int idDevice, double nivel){
        this.divisao.get(idDivisao).setNivelDevice(idDevice, nivel);
    }

    public ADomusSimples getDispositivo(int idDivisao, int idDevice) {
        return this.divisao.get(idDivisao).getDispositivo(idDevice);
    }









    //FIXME: colocar aqui os metodos que retornam uma casa quaquer


}
