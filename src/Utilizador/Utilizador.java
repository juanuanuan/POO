package Utilizador;

import Domus.Casa;
import java.util.List;
import java.util.ArrayList;

public class Utilizador {
    private String nome;
    private int NIF;
    private int tlm;
    private String email;
    private String passWord;
    private int idUtilizador;
    private List<Integer> idCasas;

    public Utilizador() {
        this.nome = "";
        this.NIF = 0;
        this.tlm = 0;
        this.email = "";
        this.passWord = "";
        this.idUtilizador = 0;
        this.idCasas = new ArrayList<>();
    }

    public Utilizador(String nome, int NIF, int tlm, String email, String passWord, int idUtilizador, List<Integer> idCasas) {
        this.nome = nome;
        this.NIF = NIF;
        this.tlm = tlm;
        this.email = email;
        this.passWord = passWord;
        this.idUtilizador = idUtilizador;
        this.idCasas = idCasas;
    }

    public Utilizador(Utilizador other) {
        this.nome = other.getNome();
        this.NIF = other.getNIF();
        this.tlm = other.getTlm();
        this.email = other.getEmail();
        this.passWord = other.getPassWord();
        this.idUtilizador = other.getIdUtilizador();
        this.idCasas = new ArrayList<>(other.getIdCasas());
    }

    public String getNome() {
        return this.nome;
    }

    public int getNIF() {
        return this.NIF;
    }

    public int getTlm() {
        return this.tlm;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public int getIdUtilizador() {
        return this.idUtilizador;
    }

    public List<Integer> getIdCasas() {
        return new ArrayList<>(this.idCasas);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public void setTlm(int tlm) {
        this.tlm = tlm;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public void setIdCasas(List<Integer> idCasas) {
        this.idCasas = idCasas;
    }


    public Utilizador clone() {
        return new Utilizador(this);
    }

    public String toString() {
        return "As informações sobre o utilizador são: " + "\n" +
                "Nome: " + getNome() + "\n" +
                "NIF: " + getNIF() + "\n" +
                "Número de Telemóvel: " + getTlm() + "\n" +
                "Email associado: " + getEmail() + "\n" +
                "ID DomusControl: " + getIdUtilizador() + "\n";
        //(ehHost(casa, user) ? "Palavra-Passe " + getPassWord() + "\n" : "Palavra-passe:" + "******" + "\n");// fazer verificação se é o dono da casa
    } // Assim o host tem controlo total de quem está na aplicação da casa dele

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Utilizador other = (Utilizador) o;
        return (this.NIF == other.NIF && this.email.equals(other.email) && this.tlm == other.tlm && this.idUtilizador == other.idUtilizador);
    }

    public boolean ehHost(Casa casa, Utilizador user) {
        return casa.getIdHost() == user.getIdUtilizador();
    }

    public boolean login(String eemail, String ppassWord) {
        return eemail.equals(this.getEmail()) && ppassWord.equals(this.getPassWord());
    } // na duvida se coloco isto na classe controlador

    //procurei isto em todo lado e nao encontrei, nao esta a dar conflito por isso deixo estar
    public void addCasa(int idCasa) {
        this.idCasas.add(idCasa);
    }

    public void removeCasa(int idCasa) {
        this.idCasas.remove(Integer.valueOf(idCasa));
    }
}

