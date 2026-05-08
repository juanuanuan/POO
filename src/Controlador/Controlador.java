package Controlador;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import Domus.Divisao;
import DomusDevice.ADomusComplexo;
import DomusDevice.ADomusSimples;
import DomusDevice.DomusLampada;

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
    //private List<Menus> menus;


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

    public static Controlador carregaEstado(String ficheiro)  {
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
                .map(Casa::clone)
            .orElse(null);
    }

    public List<Divisao> top3DivisoesComMaisDevices() {
        return this.casas.values().stream()
            .flatMap(c -> c.getDivisao().values().stream())
            .sorted(Comparator.comparingInt(d -> -d.getNumDispositivos()))
            .limit(3)
                .map(Divisao::clone)
            .collect(Collectors.toList());
    }

    public List<ADomusSimples> top3DevicesPorTempo(int idCasa) {
        return this.casas.get(idCasa).clone().top3DevicesPorTempo(this.tempoAtual);
    }

    public List<ADomusSimples> top3DevicesPorAtivacoes(int idCasa) {
        return this.casas.get(idCasa).clone().top3DevicesPorAtivacoes();
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

    public String listaDispositivos(int idCasa, int idDivisao) {
        return this.casas.get(idCasa).getDivisao().get(idDivisao).getDispositivos().toString();
    }

    public String listaDivisoes(int idCasa) {
        return this.casas.get(idCasa).getDivisao().toString();
    }

    public String listaCasasUtilizador(int idUtilizador){
        return this.utilizadores.getUtilizadores().get(idUtilizador).getIdCasas().stream()
            .map(id -> this.casas.get(id).toString())
            .collect(Collectors.joining("\n"));
    }

    public double getConsumoCasa(int idCasa) {
        return this.casas.get(idCasa).getConsumoTotal();
    }

    public void adicionaDivisao(int idCasa, String nomeDivisao, int idDivisao) {
        Divisao div = new Divisao(nomeDivisao, idDivisao, new ArrayList<>());
        this.casas.get(idCasa).addDiv(div);
    }

    public void removeDivisao(int idCasa, int idDivisao) {
        this.casas.get(idCasa).removeDiv(idDivisao);
    }

    public void adicionaCasa(int idHost, int idCasa, String morada, String nomeCasa) { 
        Casa novaCasa = new Casa(new HashMap<>(), idHost, idCasa, morada, nomeCasa);
        this.casas.put(idCasa, novaCasa);
        this.utilizadores.getUtilizadores().get(idHost).addCasa(idCasa);
    }

    public void removeCasa(int idUtilizador, int idCasa) {
        this.casas.remove(idCasa);
        this.utilizadores.getUtilizadores().get(idUtilizador).removeCasa(idCasa);
    }

    public boolean ehHost(){
        return this.casas.values().stream()
                .anyMatch(c -> c.getIdHost() == user.getIdUtilizador());
    }

    public ADomusSimples top1DeviceConsumo(int idCasa){
        return this.casas.get(idCasa).top1DeviceConsumo().clone();
    }


    public void boostDevice(int idCasa, int idDivisao, int idDevice){
        this.casas.get(idCasa).getDivisao().get(idDivisao)
                .getDispositivos().stream()
                .filter(dSimples -> dSimples instanceof ADomusComplexo)
                .filter(dSimples -> dSimples.getIdObjeto() == idDevice)
                .map(dSimples -> (ADomusComplexo) dSimples)
                .findFirst()
                .ifPresent(ADomusComplexo::boostObj);

    }

    public void ecoDevice(int idCasa, int idDivisao, int idDevice){
        this.casas.get(idCasa).getDivisao().get(idDivisao)
                .getDispositivos().stream()
                .filter(dSimples -> dSimples instanceof ADomusComplexo)
                .filter(dSimples -> dSimples.getIdObjeto() == idDevice)
                .map(dSimples -> (ADomusComplexo) dSimples)
                .findFirst()
                .ifPresent(ADomusComplexo::ecoObj);
    }

    public void desligaAllDevice(int idCasa){
        this.casas.get(idCasa).getDivisao().values().stream() // perguntar ao stor porque é que o intellij diz para tirar o stream.
                .forEach(d -> d.desligaAll(this.getTempoAtual()));
    }

    public boolean existeConta(Utilizador user){
        boolean existentUser = this.utilizadores.getUtilizadores().values().stream()
                .anyMatch(u -> u.getNIF() == user.getNIF() || u.getEmail().equals(user.getEmail()));

        if(!existentUser){
            this.utilizadores.getUtilizadores().put(user.getIdUtilizador(), user);
            return true;
        }

        System.out.println("User with this credentials already exists.\n");
        return false;
    }

    public void adicionaGuest(int idCasa, int idGuest) {
        this.casas.get(idCasa).addGuest(idGuest);
        this.utilizadores.getUtilizadores().get(idGuest).addCasa(idCasa);
    }

    public void removeGuest(int idCasa, int idGuest){
        this.casas.get(idCasa).removeGuest(idGuest);
        this.utilizadores.getUtilizadores().get(idGuest).removeCasa(idCasa);
    }

    public String listaGuests(int idCasa){
        return this.casas.get(idCasa).getIdGuests().stream()
        .map(id -> this.utilizadores.getUtilizadores().get(id).toString())
        .collect(Collectors.joining("\n")); // nao sei se isto esta bem tho
    }

    public String listaHost(int idCasa){
        int idHost = this.casas.get(idCasa).getIdHost();
        return this.utilizadores.getUtilizadores().get(idHost).toString();
    }

    public double getConsumoMensalCasa(int idCasa) {
        return this.casas.get(idCasa).getConsumoMensal(this.tempoAtual);
    }

    public void adicionaDispositivo(int idCasa, int idDivisao, ADomusSimples device){
        this.casas.get(idCasa).getDivisao().get(idDivisao).addObj(device);
    }





  











public void instantTest() {
    DomusLampada l1 = new DomusLampada(1, "Philips", "HUE",     10.0, 10.0, 2700, true,  0, 0, 0, 50.0);
    DomusLampada l2 = new DomusLampada(2, "Ikea",    "Tradfri",  8.0,  8.0,    0, false, 0, 0, 0, 30.0);
    DomusLampada l3 = new DomusLampada(3, "Xiaomi",  "Yeelight", 9.0,  9.0, 4000, true,  0, 0, 0, 70.0);
    DomusLampada l4 = new DomusLampada(4, "Philips", "HUE2",    12.0, 12.0, 3000, true,  0, 0, 0, 80.0);
    DomusLampada l5 = new DomusLampada(5, "Osram",   "Smart+",   7.0,  7.0,    0, false, 0, 0, 0, 40.0);
    DomusLampada l6 = new DomusLampada(6, "Ikea",    "Tradfri2", 6.0,  6.0,    0, false, 0, 0, 0, 20.0);
    DomusLampada l7 = new DomusLampada(7, "Philips", "HUE3",    11.0, 11.0, 2700, true,  0, 0, 0, 60.0);

    Divisao sala1      = new Divisao("Sala",       1, new ArrayList<>());
    Divisao quarto1    = new Divisao("Quarto",     2, new ArrayList<>());
    Divisao cozinha    = new Divisao("Cozinha",    3, new ArrayList<>());
    Divisao escritorio = new Divisao("Escritório", 4, new ArrayList<>());

    sala1.addObj(l1); sala1.addObj(l2); sala1.addObj(l3);
    quarto1.addObj(l4);
    cozinha.addObj(l5); cozinha.addObj(l6);
    escritorio.addObj(l7);

    Casa casa1 = new Casa(new HashMap<>(), 1, 1, "Rua A", "Casa Principal");
    casa1.addDiv(sala1); casa1.addDiv(quarto1);
    this.casas.put(1, casa1);

    Casa casa2 = new Casa(new HashMap<>(), 1, 2, "Rua B", "Casa de Ferias");
    casa2.addDiv(cozinha); casa2.addDiv(escritorio);
    this.casas.put(2, casa2);

    l1.ligaObj(0); l2.ligaObj(0); l3.ligaObj(0); l4.ligaObj(0);
    this.tempoAtual = 120;
    l1.desligaObj(120); l2.desligaObj(120); l3.desligaObj(120); l4.desligaObj(120);

    l5.ligaObj(120); l6.ligaObj(120);
    this.tempoAtual = 150;
    l5.desligaObj(150); l6.desligaObj(150);

    l1.ligaObj(150);
    this.tempoAtual = 200;
    l3.ligaObj(200);

    Utilizador u1 = new Utilizador("joao", 267316020, 938756690, "joao@gmail.com", "1234", 50098, new ArrayList<>(List.of(1, 2)));
    Utilizador u2 = new Utilizador("zeca", 987654321, 923456789, "zeca@gmail.com", "4321", 2, new ArrayList<>());
    this.utilizadores.addUser(u1);
    this.utilizadores.addUser(u2);
    }
}
