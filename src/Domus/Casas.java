package Domus;

import DomusDevice.ADomusComplexo;
import DomusDevice.ADomusSimples;
import DomusDevice.IDomusAC;
import Utilizador.Utilizador;

import java.io.Serializable;
import java.util.ArrayList;
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

    public List<ADomusSimples> top3DevicesPorTempo(int idCasa, long tempoAtual) {
        return this.casas.get(idCasa).clone().top3DevicesPorTempo(tempoAtual);
    }

    public List<ADomusSimples> top3DevicesPorAtivacoes(int idCasa) {
        return this.casas.get(idCasa).clone().top3DevicesPorAtivacoes();
    }

    public ADomusSimples top1DeviceConsumo(int idCasa){
        return this.casas.get(idCasa).top1DeviceConsumo().clone();
    }

    public boolean ehHost(Utilizador user){
        return this.casas.values().stream()
                .anyMatch(c -> c.getIdHost() == user.getIdUtilizador());
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








    //FIXME: colocar aqui os metodos que retornam casas.
}
