package Controller;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import Model.Domus.Casas;
import Model.Domus.Divisao;
import Model.DomusDevice.ADomusSimples;

import Model.Domus.Casa;
import Model.Utilizador.Utilizador;
import Model.Utilizador.Utilizadores;
import Model.*;

public class Controlador implements Serializable {
    // Recebe métodos que salvam e carregam o estado da aplicação
    // lê ficheiros, recebe os metodos DomusDevice para criação de duplicatos.

    private Utilizadores utilizadores; 
    private Casas casas; 
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
        return this.user.clone();
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

    public List<ADomusSimples> top3DevicesPorTempoCasa(int idCasa) {
        return this.casas.top3DevicesPorTempoCasa(idCasa, this.getTempoAtual());
    }

    public List<ADomusSimples> top3DevicesPorAtivacoesCasa(int idCasa) {
        return this.casas.top3DevicesPorAtivacoesCasa(idCasa);
    }

    public List<ADomusSimples> top3DevicesPorTempoDivisao(int idCasa, int idDivisao) {
        return this.casas.top3DevicesPorTempoDivisao(idCasa, idDivisao);
    }

    public List<ADomusSimples> top3DevicesPorAtivacoesDivisao(int idCasa, int idDivisao) {
        return this.casas.top3DevicesPorAtivacoesDivisao(idCasa, idDivisao);
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

    public boolean ehHost(int idCasa, int idUtilizador){
        return this.casas.ehHost(idCasa, idUtilizador);
    }

    public boolean ehGuest(int idCasa, int idUtilizador){
        return this.casas.ehGuest(idCasa, idUtilizador);
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

    public boolean existeConta(Utilizador user) {
        return this.utilizadores.getUtilizadores().values().stream()
                .anyMatch(u -> u.getNIF() == user.getNIF() || u.getEmail().equals(user.getEmail()));

    }

    public boolean criarConta(Utilizador user){
        if(existeConta(user)){
            System.out.println("User with this credentials already exists.\n");
            return false;
        }
        this.utilizadores.addUser(user);
        return true;
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

    public void aquecer(int idCasa, int idDivisao, int idDevice){
        this.casas.aquecer(idCasa, idDivisao, idDevice);
    }

    public void arrefecer(int idCasa, int idDivisao, int idDevice){
        this.casas.arrefecer(idCasa, idDivisao, idDevice);
    }

    public void ventilar(int idCasa, int idDivisao, int idDevice){
        this.casas.ventilar(idCasa, idDivisao, idDevice);
    }

    public void setTemperatura(int idCasa, int idDivisao, int idDevice, int temperatura){
        this.casas.setTemperatura(idCasa, idDivisao, idDevice, temperatura);
    }

    public void setNivelDevice(int idCasa, int idDivisao, int idDevice, double nivel){
        this.casas.setNivelDevice(idCasa, idDivisao, idDevice, nivel);
    }

    public ADomusSimples getDispositivo(int idCasa, int idDivisao, int idDevice) {
        return this.casas.getDispositivo(idCasa, idDivisao, idDevice);
    }





}
