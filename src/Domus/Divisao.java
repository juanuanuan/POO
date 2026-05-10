package Domus;

import DomusDevice.ADomusSimples;
import DomusDevice.ADomusComplexo;
import DomusDevice.IDomusAC;

import java.util.Comparator;
import java.util.stream.Collectors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Divisao implements Serializable {
    // Colocar atributos de uma qualquer divisão.
    // So criar classes de outras divisões quando estritamente necessário. I.e, quando outra divisão
    // apresenta atributos e comportamentos completamente diferentes de outra divisão

    private String divisao;
    private int idDivisao;
    private List<ADomusSimples> dispositivos; // perfeito como está, encaixa a lógica de simples e complexo perfeitamente

    public Divisao() {
        this.divisao = "";
        this.dispositivos = new ArrayList<>();
    }

    public Divisao(String newDivisao, int idDivisao, ArrayList<ADomusSimples> dispositivos) {
        this.divisao = newDivisao;
        this.dispositivos = dispositivos;
        this.idDivisao = idDivisao;
    }

    public Divisao(Divisao other) {
        this.divisao = other.getDivisao();
        this.idDivisao = other.getIdDivisao();
        this.dispositivos = new ArrayList<>();
        other.dispositivos.forEach(d -> this.dispositivos.add(d.clone()));
    }


    public String getDivisao() {
        return this.divisao;
    }

    public int getIdDivisao() {
        return this.idDivisao;
    }

    public List<ADomusSimples> getDispositivos() {
        ArrayList<ADomusSimples> copia = new ArrayList<>();
        this.dispositivos.forEach(d -> copia.add(d.clone()));
        return copia;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }

    public void setIdDivisao(int idDivisao) {
        this.idDivisao = idDivisao;
    }

    public void setDispositivos(List<ADomusSimples> dispositivos) {
        this.dispositivos = new ArrayList<>();
        dispositivos.forEach(d -> this.dispositivos.add(d.clone()));
    }


    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Divisao other = (Divisao) o;
        return (this.idDivisao == other.idDivisao);
    }

    public String toString(){
        return  getDivisao() +
                "ID: " + getIdDivisao() + "\n" +
                "Device list associated: " + getDispositivos() + "\n";
    }

    public int compareTo(Divisao o){
        if(this.idDivisao < o.idDivisao){
            return -1;
        } else if (this.idDivisao > o.idDivisao){
            return 1;
        } return 0;

    }


    public Divisao clone(){
        return new Divisao(this);
    }

    public void addObj(ADomusSimples dispositivo){
        dispositivos.add(dispositivo);
    }

    public void removeObj(ADomusSimples dispositivo){
        dispositivos.remove(dispositivo);
    }

    public void ligaAll(long momentoAtual){
        for(ADomusSimples dispositivo : dispositivos){
            dispositivo.ligaObj(momentoAtual);
        }
    }

    public void desligaAll(long momentoAtual){
        for(ADomusSimples dispositivo : dispositivos){
            dispositivo.desligaObj(momentoAtual);
        }
    }

    public void boostAll(){
        for(ADomusSimples dispositivo : dispositivos){
            if(dispositivo instanceof ADomusComplexo dispositivoComplexo){
                dispositivoComplexo.boostObj();
            }
        } // não sei se está bem, não tocar aqui!
    }

    public void ecoAll(){
        for(ADomusSimples dispositivo : dispositivos){
            if(dispositivo instanceof ADomusComplexo dispositivoComplexo){
                dispositivoComplexo.ecoObj();
            }
        }
    }

    public int getNumDispositivos() {
        return this.dispositivos.size();
    }

    public List<ADomusSimples> top3PorTempoD(long momentoAtual) {
        return this.dispositivos.stream()
            .sorted(Comparator.comparingLong(d -> -d.getTempoTotal(momentoAtual)))
            .limit(3)
                .map(ADomusSimples::clone)
            .collect(Collectors.toList());
    }

    public List<ADomusSimples> top3PorAtivacoesD() {
        return this.dispositivos.stream()
            .sorted(Comparator.comparingInt(d -> -d.getNumAtivacoes()))
            .limit(3)
                .map(ADomusSimples::clone)
            .collect(Collectors.toList());
    }

    public void ecoDevice(int idDevice){
        this.dispositivos.stream()
                .filter(d -> d instanceof ADomusComplexo)
                .filter(d -> d.getIdObjeto() == idDevice)
                .map(d -> (ADomusComplexo) d)
                .findFirst()
                .ifPresent(ADomusComplexo::ecoObj);
    }

    public void boostDevice(int idDevice){
        this.dispositivos.stream()
                .filter(dSimples -> dSimples instanceof ADomusComplexo)
                .filter(dSimples -> dSimples.getIdObjeto() == idDevice)
                .map(dSimples -> (ADomusComplexo) dSimples)
                .findFirst()
                .ifPresent(ADomusComplexo::boostObj);

    }

    public void ligaDispositivo(int idDevice, long tempoAtual) {
        this.dispositivos.stream()
                .filter(d -> d.getIdObjeto() == idDevice)
                .findFirst()
                .ifPresent(d -> d.ligaObj(tempoAtual));
    }

    public void desligaDispositivo(int idDevice, long tempoAtual) {
        this.dispositivos.stream()
                .filter(d -> d.getIdObjeto() == idDevice)
                .findFirst()
                .ifPresent(d -> d.desligaObj(tempoAtual));
    }

    public String listaDispositivos() {
        return this.dispositivos.stream()
                .map(ADomusSimples::toString)
                .collect(Collectors.joining("\n"));

    }




    //FIXME: colocar aqui os metodos que retornam divisoes








}