package Controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import Domus.Divisao;
import DomusDevice.ADomusSimples;

import Domus.Casa;
import Utilizador.Utilizador;
import Utilizador.Utilizadores;

public class Controlador implements Serializable {
    // Recebe métodos que salvam e carregam o estado da aplicação
    // lê ficheiros, recebe os metodos DomusDevice para criação de duplicatos.

    // nao sei bem o propósito desta classe, se fica so para gestão do estado da aplicação, ou se lhe passamos métodos de controlo sobre os utilizadores, i.e., login registo, etc

    private Utilizadores utilizadores; 
    private HashMap<Integer, Casa> casas;
    private Utilizador user;
    private long tempoAtual;


    public Controlador(){
        this.utilizadores = new Utilizadores();
        this.casas = new HashMap<>();
    }

    //não precisamos de contrutor parametrizado, o controlador começa sempre vazio e vai "enchendo" conforme o uso da aplicação

    public Controlador(Controlador other){
        this.utilizadores = other.getUtilizadores();
        this.casas = new HashMap<>(other.getCasas());
    }

    public Utilizadores getUtilizadores(){
        return this.utilizadores;
    }

    public HashMap <Integer, Casa> getCasas(){
        return new HashMap<>(this.casas);
    }

    public long getTempoAtual() {
        return this.tempoAtual;
    }

    public void avancaTempo(long minutos) {
        this.tempoAtual += minutos;
    }


    public void setUtilizadores(Utilizadores utilizadores){
        this.utilizadores = utilizadores;
    }

    public void setCasas(HashMap<Integer, Casa> hashMap){
        this.casas = new HashMap<>(hashMap);
    }



    // um pouco confusas de entender mas funcionam
    public void guardaEstado(String ficheiro) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheiro));
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Controlador carregaEstado(String ficheiro) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheiro));
            Controlador c = (Controlador) ois.readObject();
            ois.close();
            return c;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Controlador clone(){
        return new Controlador(this);
    }

    public String toString(){
        return "";
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Controlador other = (Controlador) o;
        return this.utilizadores.equals(other.utilizadores) &&
               this.casas.equals(other.casas);
    }

    public Casa casaQueMaisConsome() {
        return this.casas.values().stream()
            .max(Comparator.comparingDouble(Casa::getConsumoTotal))
            .orElse(null);
    }

    public List<Divisao> top3DivisoesComMaisDevices() {
        return this.casas.values().stream()
            .flatMap(c -> c.getDivisao().values().stream())
            .sorted(Comparator.comparingInt(d -> -d.getNumDispositivos()))
            .limit(3)
            .collect(Collectors.toList());
    }

    public List<ADomusSimples> top3DevicesPorTempo(int idCasa) {
        return this.casas.get(idCasa).top3DevicesPorTempo(this.tempoAtual);
    }

    public List<ADomusSimples> top3DevicesPorAtivacoes(int idCasa) {
        return this.casas.get(idCasa).top3DevicesPorAtivacoes();
    }

    public void ligaDispositivo(int idCasa, int idDivisao, int idDevice) {
        this.casas.get(idCasa).getDivisao().get(idDivisao)
            .getDispositivos().stream()
            .filter(d -> d.getIdObjeto() == idDevice)
            .findFirst()
            .ifPresent(d -> d.ligaObj(this.tempoAtual));
    }

    public void desligaDispositivo(int idCasa, int idDivisao, int idDevice) {
        this.casas.get(idCasa).getDivisao().get(idDivisao)
            .getDispositivos().stream()
            .filter(d -> d.getIdObjeto() == idDevice)
            .findFirst()
            .ifPresent(d -> d.desligaObj(this.tempoAtual));
    }




}
