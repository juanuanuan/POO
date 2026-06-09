import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class UbersPOO {
    private Map<String, Carro> carros; // para o ultimo exercicio é necessário apagar daqui esta instancia
    private String nomeCompanhia;
    private Map<Integer, Utilizador> users;
    private Map<String, Registo> registo;

    //para o ultimo exercicio
    private List<Carro> carrosFornecidos;

    public UbersPOO(){
        this.carros = new TreeMap<>();
        this.nomeCompanhia = "";
        this.users = new HashMap<>();
        this.carrosFornecidos = new ArrayList<>();
        this.registo = new HashMap<>();
    }

    public UbersPOO(Collection<Carro> carrosS){
        this.carros = new TreeMap<>();
        carrosS.forEach(c -> this.carros.put(c.getMatricula(), c.clone()));
        this.nomeCompanhia = "";
        this.users = new HashMap<>();
    }

    public UbersPOO (UbersPOO other){
        this.carros = new TreeMap<>();
        other.carros.forEach((m, c) -> this.carros.put(m, c.clone()));
    }


    public UbersPOO clone(){
        return new UbersPOO(this);
    }

    public List<Carro> getCarrosFornecidos() {
        List<Carro> copia = new ArrayList<>();
        this.carrosFornecidos.forEach(c -> copia.add(c.clone()));
        return copia;
    }

    public void adicionaCarroFornecido(Carro c){
        this.carrosFornecidos.add(c);
    }

    public String getNomeCompanhia() {
        return this.nomeCompanhia;
    }

    public void adicionaRegisto(LocalDate inicio, LocalDate fim, String matricula, int idUser) throws UserNaoEsisteException{
        if(idUser == 0){
            throw new UserNaoEsisteException();
        }

        // Fazer Excessão para a matrícula também

        Registo r = new Registo(inicio, fim, idUser);

        this.registo.put(matricula, r);

    }



    public Utilizador utilizadorMaisGastador(){
        return this.users.values().stream()
                .max(Comparator.comparingDouble(Utilizador::getDinheiroGasto)
                        .thenComparing(Utilizador::getNumRegistos))
                .map(Utilizador::clone)
                .orElse(null);

    }

    public List<CarroHibrido> getHibridos(){
        return this.carros.values().stream()
                .filter(c -> c instanceof CarroHibrido)
                .map(c -> (CarroHibrido) c)
                .map(c -> (CarroHibrido) c.clone())
                .sorted(Comparator.comparingDouble(CarroHibrido::getNivelBateria))
                .toList();
    }


}
