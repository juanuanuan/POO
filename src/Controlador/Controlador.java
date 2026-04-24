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
import DomusDevice.DomusLampada;
import java.util.ArrayList;

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

    public void instantTest() {
        DomusLampada l1 = new DomusLampada(1, "Philips", "HUE", 10.0, 10.0, 50, 2700, true, 0, 0, 0);
        DomusLampada l2 = new DomusLampada(2, "Ikea", "Tradfri", 8.0, 8.0, 30, 0, false, 0, 0, 0);
        DomusLampada l3 = new DomusLampada(3, "Xiaomi", "Yeelight", 9.0, 9.0, 70, 4000, true, 0, 0, 0);
        DomusLampada l4 = new DomusLampada(4, "Philips", "HUE2", 12.0, 12.0, 80, 3000, true, 0, 0, 0);
        DomusLampada l5 = new DomusLampada(5, "Osram", "Smart+", 7.0, 7.0, 40, 0, false, 0, 0, 0);
        DomusLampada l6 = new DomusLampada(6, "Ikea", "Tradfri2", 6.0, 6.0, 20, 0, false, 0, 0, 0);
        DomusLampada l7 = new DomusLampada(7, "Philips", "HUE3", 11.0, 11.0, 60, 2700, true, 0, 0, 0);

        // Casa 1 - 2 divisões
        Divisao sala1 = new Divisao("Sala", 1, new ArrayList<>());
        Divisao quarto1 = new Divisao("Quarto", 2, new ArrayList<>());
        sala1.addObj(l1);
        sala1.addObj(l2);
        sala1.addObj(l3);
        quarto1.addObj(l4);

        Casa casa1 = new Casa(new HashMap<>(), 1, 1, "Rua A", "Casa Principal");
        casa1.addDiv(sala1);
        casa1.addDiv(quarto1);
        this.casas.put(1, casa1);
// Casa 2 - 2 divisões
        Divisao cozinha = new Divisao("Cozinha", 3, new ArrayList<>());
        Divisao escritorio = new Divisao("Escritorio", 4, new ArrayList<>());
        cozinha.addObj(l5);
        cozinha.addObj(l6);
        escritorio.addObj(l7);

        Casa casa2 = new Casa(new HashMap<>(), 1, 2, "Rua B", "Casa de Ferias");
        casa2.addDiv(cozinha);
        casa2.addDiv(escritorio);
        this.casas.put(2, casa2);

        // Simular uso - casa1 consome mais
        l1.ligaObj(0); l2.ligaObj(0); l3.ligaObj(0); l4.ligaObj(0);
        this.tempoAtual = 120;
        l1.desligaObj(120); // 120 min, 3 ativacoes no total da casa1
        l2.desligaObj(120);
        l3.desligaObj(120);
        l4.desligaObj(120);

        // l5 e l6 ligam menos tempo
        l5.ligaObj(120); l6.ligaObj(120);
        this.tempoAtual = 150;
        l5.desligaObj(150); // 30 min
        l6.desligaObj(150);

        // l1 liga outra vez - mais ativacoes
        l1.ligaObj(150);
        l1.ligaObj(150); // mais uma ativacao
        this.tempoAtual = 200;
        l3.ligaObj(200); // l3 tem menos tempo total mas mais ativacoes
        l3.ligaObj(200);
        l3.ligaObj(200);
    } // isto nao pode ficar assim!!!!!!!!!! MUDAR DEPOIS




}
