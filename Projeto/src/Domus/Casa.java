package Domus;

import java.io.Serializable;
import java.util.HashMap;

public class Casa implements Serializable {
    // Vamos criar um HashMap para ser mais fácil adicionar, remover e até mesmo aceder às divisões.
    // Presumindo que não vai ser necessário iterar todas as divisões com alta precisão e rapidez, é melhor um HashMap do que um ArrayList ou LinkedList.
    private HashMap<Integer, Divisao> divisao;

}
