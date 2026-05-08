package Utilizador;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;


public class Utilizadores implements Serializable {
    private HashMap<Integer, Utilizador> utilizadores; // para não haver erros na Heap, ºe melhor colocar a chave do mapa para um ID fixo e imutável

    public Utilizadores(){
        this.utilizadores = new HashMap<>();
    }


    public Utilizadores(HashMap<Integer,Utilizador> utilizadores){
        this.utilizadores = utilizadores;
    }

    public Utilizadores(Utilizadores other){
        this.utilizadores = new HashMap<>(other.getUtilizadores());
    }


    public HashMap<Integer, Utilizador> getUtilizadores() {
        return this.utilizadores;
    }

    // na dúvida se um setter vale mesmo a pena definir, na minha opinião, só vale a pena se quisermos carregar um estado antigo, i.e., voltar um save atrás



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
        utilizadores.put(user.getIdUtilizador(), user);
    }

    public void removeUser(Utilizador user){
        utilizadores.remove(user.getIdUtilizador(), user);
    }

    public Utilizador efetuaLogin(String novoEmail, String novaPass){
        for(Utilizador currentUser : utilizadores.values()){
            if(currentUser.login(novoEmail,novaPass)){
                return currentUser;
            }
        } return null;
    }

     //FIXME: ha metodos a colocar aqui tambem.
}
