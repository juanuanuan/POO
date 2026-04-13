package Domus;

import DomusDevice.ADomusSimples;
import DomusDevice.ADomusComplexo;

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
        this.dispositivos = new ArrayList<>(other.getDispositivos()); // FAZER CICLO FOR EACH para copiar todos os objetos.
    }


    public String getDivisao() {
        return this.divisao;
    }

    public int getIdDivisao() {
        return this.idDivisao;
    }

    public List<ADomusSimples> getDispositivos() {
        return this.dispositivos;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }

    public void setIdDivisao(int idDivisao) {
        this.idDivisao = idDivisao;
    }

    public void setDispositivos(List<ADomusSimples> dispositivos) {
        this.dispositivos = dispositivos;
    }


    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Divisao other = (Divisao) o;
        return (this.idDivisao == other.idDivisao);
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
    } // incompleto

    public void addObj(ADomusSimples dispositivo){
        dispositivos.add(dispositivo);
    }

    public void removeObj(ADomusSimples dispositivo){
        dispositivos.remove(dispositivo);
    }

    public void ligaAll(){
        for(ADomusSimples dispositivo : dispositivos){
            dispositivo.ligaObj();
        }
    }

    public void desligaAll(){
        for(ADomusSimples dispositivo : dispositivos){
            dispositivo.desligaObj();
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








}