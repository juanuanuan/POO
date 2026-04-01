package Utilizador;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Utilizadores implements Serializable {
    private HashMap<Integer, Utilizador> utilizadores;

    public Utilizadores(){
        this.utilizadores = new HashMap<>();
    }

    public Utilizadores(HashMap<Integer,Utilizador> utilizadores){
        this.utilizadores = utilizadores;
    }

    public HashMap<Integer, Utilizador> getUtilizadores() {
        return this.utilizadores;
    }

    // na dúvida se um setter vale mesmo a pena definir, na minha opinião, só vale a pena se quisermos carregar um estado antigo, i.e., voltar um save atrás



    public String toString() {
       return "Lista de Utilizadores: " + getUtilizadores() + "\n";
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

    // dúvida se vale a pena fazer o método clone"

    public boolean addUser(Utilizador user){
        if(utilizadores.containsKey(user.getIdUtilizador()) && utilizadores.containsKey(user.getNIF())) return false;
        else utilizadores.put(user.getIdUtilizador(), user);
        return true;
    }
}
