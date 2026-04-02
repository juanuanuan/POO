package Domus;

import java.io.Serializable;
import java.util.HashMap;

public class Casa implements Serializable {
    // Vamos criar um HashMap para ser mais fácil adicionar, remover e até mesmo aceder às divisões.
    // Presumindo que não vai ser necessário iterar todas as divisões com alta precisão e rapidez, é melhor um HashMap do que um ArrayList ou LinkedList.
    private HashMap<Integer, Divisao> divisao;
    private int idHost;

    public Casa (){
        this.divisao = new HashMap<>();
        this.idHost = -1;
    }

    public Casa (HashMap<Integer, Divisao> divisao, int idHost){
        this.divisao = divisao;
        this.idHost = idHost;
    }

    public Casa (Casa other){
        this.divisao = other.getDivisao();
        this.idHost = other.getIdHost();

    }

    public HashMap<Integer, Divisao> getDivisao() {
        return this.divisao;
    }

    public int getIdHost() {
        return this.idHost;
    }

    public void setIdHost(int idHost) {
        this.idHost = idHost;
    }


    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Casa other = (Casa) o;
        return (this.idHost == other.idHost && this.divisao == other.divisao);
    }


}
