package Utilizador;

import Domus.Casa;
import Domus.Casas;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;


public class Utilizadores implements Serializable {
    private HashMap<Integer, Utilizador> utilizadores; // para não haver erros na Heap, ºe melhor colocar a chave do mapa para um ID fixo e imutável

    public Utilizadores(){
        this.utilizadores = new HashMap<>();
    }


    public Utilizadores(HashMap<Integer,Utilizador> utilizadores){
        this.utilizadores = new HashMap<>();
        utilizadores.forEach((id, u) -> this.utilizadores.put(id, u.clone()));
    }

    public Utilizadores(Utilizadores other){
        this.utilizadores = new HashMap<>();
        other.utilizadores.forEach((id, u) -> this.utilizadores.put(id, u.clone()));
    }


    public HashMap<Integer, Utilizador> getUtilizadores() {
        HashMap<Integer, Utilizador> copia = new HashMap<>();
        this.utilizadores.forEach((id, u) -> copia.put(id, u.clone()));
        return copia;
    }




    public String toString() {
        String result = "Lista de Utilizadores:\n";
        for (Utilizador u : this.utilizadores.values()) {
            result += u.toString() + "\n";
            }
        return result;
    }

    public boolean equals(Object o){ // para ser útil na classe Controlador em questões de save e load e verificação do estado do ficheiro. Ainda não sei se vale a pena
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Utilizadores other = (Utilizadores) o;
        return this.utilizadores.equals(other.utilizadores);
    }


    public int hashCode() {
        return Objects.hash(utilizadores);
    }

    

    public boolean existeUser(int id){
        return utilizadores.containsKey(id);
    }

    public void addUser(Utilizador user){
        this.utilizadores.put(user.getIdUtilizador(), user.clone());
    }

    public void removeUser(Utilizador user){
        this.utilizadores.remove(user.getIdUtilizador(), user);
    }

    public Utilizador efetuaLogin(String novoEmail, String novaPass){
        for(Utilizador currentUser : utilizadores.values()){
            if(currentUser.login(novoEmail,novaPass)){
                return currentUser;
            }
        } return null;
    }

    public void removeCasaUser(int idUtilizador, int idCasa) {
        this.utilizadores.get(idUtilizador).removeCasa(idCasa);

    }

    public void adicionaCasaUser(int idUtilizador, int idCasa) {
        this.utilizadores.get(idUtilizador).addCasa(idCasa);
    }

    public String listaCasasUtilizador(int idUtilizador, Casas casas){
        return this.utilizadores.get(idUtilizador).getIdCasas().stream()
                .map(id -> casas.getCasas().toString())
                .collect(Collectors.joining("\n"));
    }

    public void adicionaGuestU(int idCasa, int idGuest) {
        this.utilizadores.get(idGuest).addCasa(idCasa);
    }

    public void removeGuestU(int idCasa, int idGuest){
        this.utilizadores.get(idGuest).removeCasa(idCasa);
    }


}
