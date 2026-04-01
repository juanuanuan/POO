package Domus;

import DomusDevice.DomusAbstract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Divisao implements Serializable {
    // Colocar atributos de uma qualquer divisão.
    // So criar classes de outras divisões quando estritamente necessário. I.e, quando outra divisão
    // apresenta atributos e comportamentos completamente diferentes de outra divisão

    private String Divisao;
    private int idDivisao;
    private List<DomusAbstract> dispositivos;

    public Divisao() {
        this.Divisao = "";
        this.dispositivos = new ArrayList<>();
    }

    public Divisao(String newDivisao, int idDivisao, ArrayList<DomusAbstract> dispositivos) {
        this.Divisao = newDivisao;
        this.dispositivos = dispositivos;
        this.idDivisao = idDivisao;
    }

    public Divisao(Divisao other) {
        this.Divisao = other.getDivisao();
        this.idDivisao = other.getIdDivisao();
        // this.dispositivos = new ArrayList<>(other.getDispositivos()); // !!Duvida!!
        this.dispositivos = new ArrayList<>();
         for( DomusAbstract d : other.getDispositivos()){
             this.dispositivos.add(d.duplicate());
         }
    }


    public String getDivisao() {
        return this.Divisao;
    }

    public int getIdDivisao() {
        return this.idDivisao;
    }

    public List<DomusAbstract> getDispositivos() {
        return this.dispositivos;
    }

    public void setDivisao(String divisao) {
        Divisao = divisao;
    }

    public void setIdDivisao(int idDivisao) {
        this.idDivisao = idDivisao;
    }

    public void setDispositivos(List<DomusAbstract> dispositivos) {
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

    public Divisao duplicate(){
        return new Divisao(this);
    }

    public void addObj(DomusAbstract dispositivo){
        dispositivos.add(dispositivo);
    }

    public void removeObj(DomusAbstract dispositivo){
        dispositivos.remove(dispositivo);
    }

    public void ligaAll(){
        for(DomusAbstract dispositivo : dispositivos){
            dispositivo.ligaObj();
        }
    }

    public void desligaAll(){
        for(DomusAbstract dispositivo : dispositivos){
            dispositivo.desligaObj();
        }
    }






}