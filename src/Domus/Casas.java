package Domus;

import DomusDevice.ADomusSimples;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Casas implements Serializable {
    private HashMap<Integer, Casa> casas;

    public Casas(){
        this.casas = new HashMap<>();
    }

    public Casas (HashMap<Integer, Casa> casas){
        this.casas = new HashMap<>();
        casas.forEach((id, c) -> this.casas.put(id, c.clone()));
    }

    public Casas (Casas other){
        this.casas = new HashMap<>();
        other.casas.forEach((id,c) -> this.casas.put(id, c.clone()));
    }

    public HashMap<Integer, Casa> getCasas() {
        HashMap<Integer, Casa> copia = new HashMap<>();
        this.casas.forEach((id,c) -> copia.put(id, c.clone()));
        return copia;
    }

    public void setCasas(HashMap<Integer, Casa> casas) {
        this.casas = new HashMap<>();
        casas.forEach((id,c) -> this.casas.put(id, c.clone()));
    }

    public Casas clone(){
        return new Casas(this);
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Casas other = (Casas) o;
        return (this.casas.equals(other.casas));
    }

    public List<Divisao> top3DivisoesComMaisDevices() {
        return this.casas.values().stream()
                .flatMap(c -> c.getDivisao().values().stream())
                .sorted(Comparator.comparingInt(d -> -d.getNumDispositivos()))
                .limit(3)
                .map(Divisao::clone)
                .collect(Collectors.toList());
    }

    public Casa casaQueMaisConsome() {
        return this.casas.values().stream()
                .max(Comparator.comparingDouble(Casa::getConsumoTotal))
                .map(Casa::clone)
                .orElse(null);
    }

    public List<ADomusSimples> top3DevicesPorTempoCasa(int idCasa, long tempoAtual) {
        return this.casas.get(idCasa).clone().top3DevicesPorTempoCasa(tempoAtual);
    }

    public List<ADomusSimples> top3DevicesPorAtivacoesCasa(int idCasa) {
        return this.casas.get(idCasa).clone().top3DevicesPorAtivacoesCasa();
    }

    public ADomusSimples top1DeviceConsumo(int idCasa){
        return this.casas.get(idCasa).top1DeviceConsumo().clone();
    }

    public boolean ehHost(int idCasa, int idUtilizador){
        return this.casas.get(idCasa).getIdHost() == idUtilizador;
    }

    public boolean ehGuest(int idCasa, int idUtilizador){
        return this.casas.get(idCasa).ehGuest(idUtilizador);
    }

    public void desligaAllDevice(int idCasa, long tempoAtual){
        this.casas.get(idCasa).desligaAllDevice(tempoAtual);
    }

    public void ecoDevice(int idCasa, int idDivisao, int idDevice){
        this.casas.get(idCasa).ecoDevice(idDivisao, idDevice);
    }

    public void boostDevice(int idCasa, int idDivisao, int idDevice){
        this.casas.get(idCasa).boostDevice(idDivisao, idDevice);
    }

    public void ligaDispositivo(int idCasa, int idDivisao, int idDevice, long tempoAtual) {
        this.casas.get(idCasa).ligaDispositivo(idDivisao, idDevice, tempoAtual);
    }

    public void desligaDispositivo(int idCasa, int idDivisao, int idDevice, long tempoAtual) {
        this.casas.get(idCasa).desligaDispositivo(idDivisao, idDevice, tempoAtual);
    }

    public void removeCasa(int idCasa) {
        this.casas.remove(idCasa);

    }

    public void adicionaCasa(Casa casa) {
        this.casas.put(casa.getIdCasa(), casa.clone());
    }

    public String listaDivisoes(int idCasa) {
        return this.casas.get(idCasa).listaDivisoes();
    }

    public String listaDispositivos(int idCasa, int idDivisao) {
        return this.casas.get(idCasa).listaDispositivos(idDivisao);
    }

    public double getConsumoCasa(int idCasa) {
        return this.casas.get(idCasa).getConsumoTotal();
    }

    public void adicionaDivisao(int idCasa, Divisao div) {
        this.casas.get(idCasa).adicionaDivisao(div);
    }

    public void removeDivisao(int idCasa, int idDivisao) {
        this.casas.get(idCasa).removeDiv(idDivisao);
    }

    public void adicionaGuest(int idCasa, int idGuest) {
        this.casas.get(idCasa).addGuest(idGuest);
    }

    public void removeGuest(int idCasa, int idGuest){
        this.casas.get(idCasa).removeGuest(idGuest);
    }

    public double getConsumoMensalCasa(int idCasa, long tempoAtual) {
        return this.casas.get(idCasa).getConsumoMensal(tempoAtual);
    }

    public void adicionaDispositivo(int idCasa, int idDivisao, ADomusSimples device){
        this.casas.get(idCasa).adicionaDispositivo(idDivisao, device);
    }

    public void aquecer(int idCasa, int idDivisao, int idDevice){
        this.casas.get(idCasa).aquecer(idDivisao, idDevice);
    }

    public void arrefecer(int idCasa, int idDivisao, int idDevice){
        this.casas.get(idCasa).arrefecer(idDivisao, idDevice);
    }

    public void ventilar(int idCasa, int idDivisao, int idDevice){
        this.casas.get(idCasa).ventilar(idDivisao, idDevice);
    }

    public void setTemperatura(int idCasa, int idDivisao, int idDevice, int temperatura){
        this.casas.get(idCasa).setTemperatura(idDivisao, idDevice, temperatura);
    }

    public List<ADomusSimples> top3DevicesPorTempoDivisao(int idCasa, int idDivisao) {
        return this.casas.get(idCasa).top3DevicesPorTempoDivisao(idDivisao);
    }

    public List<ADomusSimples> top3DevicesPorAtivacoesDivisao(int idCasa, int idDivisao) {
        return this.casas.get(idCasa).top3DevicesPorAtivacoesDivisao(idDivisao);
    }

    public void setNivelDevice(int idCasa, int idDivisao, int idDevice, double nivel){
        this.casas.get(idCasa).setNivelDevice(idDivisao, idDevice, nivel);
    }

    public ADomusSimples getDispositivo(int idCasa, int idDivisao, int idDevice) {
        return this.casas.get(idCasa).getDispositivo(idDivisao, idDevice);
    }











    //FIXME: colocar aqui os metodos que retornam casas.
}
