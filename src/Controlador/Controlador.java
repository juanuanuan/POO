package Controlador;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import Domus.Casas;
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
    private Casas casas; // FIXME: colocar isto na classe Casas. E trazer as casas para aqui, os menus nao presicam de ser trocados, continuam a chamar o controlador
    private Utilizador user;
    private long tempoAtual;
    private Set<Integer> idUsados;
    private static final Random rand = new Random();
    //private List<Menus> menus;


    public Controlador(){
        this.utilizadores = new Utilizadores();
        this.casas = new Casas();
        this.idUsados = new HashSet<>();
        this.tempoAtual = 0;
        this.user = new Utilizador();
    }

    //não precisamos de contrutor parametrizado, o controlador começa sempre vazio e vai "enchendo" conforme o uso da aplicação

    public Controlador(Controlador other){
        this.utilizadores = other.getUtilizadores();
        this.casas = other.getCasas();
        this.user = other.getUser();
        this.tempoAtual = other.getTempoAtual();
        this.idUsados = other.getIdUsados();
    }

    public Set<Integer> getIdUsados() {
        return this.idUsados;
    }

    public Utilizadores getUtilizadores(){
        return this.utilizadores;
    }

    public Utilizador getUser() {
        return this.user;
    }

    public Casas getCasas(){
        return this.casas;
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

    public void setCasas(Casas casas){
        this.casas = casas;
    }

    public void setTempoAtual(long tempoAtual) {
        this.tempoAtual = tempoAtual;
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
        return this.casas.casaQueMaisConsome();
    }

    public List<Divisao> top3DivisoesComMaisDevices() {
        return this.casas.top3DivisoesComMaisDevices();
    }

    public List<ADomusSimples> top3DevicesPorTempo(int idCasa) {
        return this.casas.top3DevicesPorTempo(idCasa, this.getTempoAtual());
    }

    public List<ADomusSimples> top3DevicesPorAtivacoes(int idCasa) {
        return this.casas.top3DevicesPorAtivacoes(idCasa);
    }

    public void ligaDispositivo(int idCasa, int idDivisao, int idDevice) {
        this.casas.ligaDispositivo(idCasa, idDivisao, idDevice, this.getTempoAtual());
    }

    public void desligaDispositivo(int idCasa, int idDivisao, int idDevice) {
        this.casas.desligaDispositivo(idCasa, idDivisao, idDevice, this.getTempoAtual());
    }

    public String listaDispositivos(int idCasa, int idDivisao) {
        return this.casas.listaDispositivos(idCasa, idDivisao);
    }

    public String listaDivisoes(int idCasa) {
        return this.casas.listaDivisoes(idCasa);
    }

    public String listaCasasUtilizador(int idUtilizador){
        return this.utilizadores.listaCasasUtilizador(idUtilizador, this.casas);
    }

    public double getConsumoCasa(int idCasa) {
        return this.casas.getConsumoCasa(idCasa);
    }

    public void adicionaDivisao(int idCasa, String nomeDivisao, int idDivisao) {
        Divisao div = new Divisao(nomeDivisao, idDivisao, new ArrayList<>());
        this.casas.adicionaDivisao(idCasa, div);
    }

    public void removeDivisao(int idCasa, int idDivisao) {
        this.casas.removeDivisao(idCasa, idDivisao);
    }

    public void adicionaCasa(int idHost, int idCasa, String morada, String nomeCasa) { 
        Casa novaCasa = new Casa(new HashMap<>(), idHost, idCasa, morada, nomeCasa);
        this.casas.adicionaCasa(novaCasa);
        this.utilizadores.adicionaCasaUser(idHost, idCasa);
    }

    public void removeCasa(int idUtilizador, int idCasa) {
        this.casas.removeCasa(idCasa);
        this.utilizadores.removeCasaUser(idUtilizador,idCasa);
    }

    public boolean ehHost(){
        return this.casas.ehHost(this.user);
    }

    public ADomusSimples top1DeviceConsumo(int idCasa){
        return this.casas.top1DeviceConsumo(idCasa);
    }


    public void boostDevice(int idCasa, int idDivisao, int idDevice){
        this.casas.boostDevice(idCasa,idDivisao,idDevice);

    }

    public void ecoDevice(int idCasa, int idDivisao, int idDevice){
        this.casas.ecoDevice(idCasa, idDivisao, idDevice);
    }

    public void desligaAllDevice(int idCasa){
        this.casas.desligaAllDevice(idCasa, this.getTempoAtual());
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
        this.casas.adicionaGuest(idCasa, idGuest);
        this.utilizadores.adicionaGuestU(idCasa, idGuest);
    }

    public void removeGuest(int idCasa, int idGuest){
        this.casas.removeGuest(idCasa, idGuest);
        this.utilizadores.removeGuestU(idCasa, idGuest);
    }

    public String listaGuests(int idCasa){
        return this.casas.getCasas().get(idCasa).getIdGuests().stream()
        .map(id -> this.utilizadores.getUtilizadores().get(id).toString())
        .collect(Collectors.joining("\n")); // a casa não tem informação sobre os utilizadores. este método fica aqui
    }

    public String listaHost(int idCasa){
        int idHost = this.casas.getCasas().get(idCasa).getIdHost();
        return this.utilizadores.getUtilizadores().get(idHost).toString();
    }

    public double getConsumoMensalCasa(int idCasa) {
        return this.casas.getConsumoMensalCasa(idCasa, this.getTempoAtual());
    }

    public void adicionaDispositivo(int idCasa, int idDivisao, ADomusSimples device){
        device.setIdObjeto(geradorId());
        this.casas.adicionaDispositivo(idCasa, idDivisao, device);
    }



    public int geradorId(){
        int id;
        do{
            id = rand.nextInt(Integer.MAX_VALUE);
        } while(idUsados.contains(id));
        idUsados.add(id);
        return id;
    }

    public void aquecerAC(int idCasa, int idDivisao, int idDevice){
        this.casas.aquecerAC(idCasa, idDivisao, idDevice);
    }

    public void arrefecerAC(int idCasa, int idDivisao, int idDevice){
        this.casas.arrefecerAC(idCasa, idDivisao, idDevice);
    }

    public void ventilarAC(int idCasa, int idDivisao, int idDevice){
        this.casas.ventilarAC(idCasa, idDivisao, idDevice);
    }
}
