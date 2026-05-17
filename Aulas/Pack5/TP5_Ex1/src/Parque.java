import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Parque {
    private Map<String, Lugar> lugares;
    private String nome;
    private String morada;

    public Parque(){
        this.lugares = new HashMap<>();
        this.nome = "";
        this.morada = "";
    }

    public Parque(Map<String, Lugar> lugares, String nome, String morada){
        this.lugares = new HashMap<>();
        lugares.forEach((k,v) -> this.lugares.put(k, v.clone()));
        this.nome = nome;
        this.morada = morada;
    }

    public Parque(Parque other){
        this.lugares = new HashMap<>();
        other.lugares.forEach((k,v) -> this.lugares.put(k, v.clone()));
        this.nome = other.getNome();
        this.morada = other.getMorada();
    }

    public Map<String, Lugar> getLugares() {
        HashMap<String, Lugar> copia = new HashMap<>();
        this.lugares.forEach((k,v) -> copia.put(k, v.clone()));
        return copia;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public Parque clone(){
        return new Parque(this);
    }

    public List<String> matriculasOcupadas(){
            return this.lugares.keySet().stream().toList();
    }

    public void registaOcupacao(Lugar l){
        if(!this.lugares.containsKey(l.getMatricula())){
            this.lugares.put(l.getMatricula(), l);
            l.setEstado(Lugar.Estado.Ocupado);
        }
    }

    public void removeOcupacao(String m){
        this.lugares.remove(m);
        this.lugares.get(m).setEstado(Lugar.Estado.Vazio);
    }

    public void alteraTempo(String m, int minutos){
         this.lugares.get(m).setMinutos(minutos);
    }

    public double minutosLeft(String m){
        return this.lugares.values().stream()
                .filter(l -> l.getMatricula().equals(m))
                .mapToDouble(Lugar::getMinutos)
                .sum();
    }

    public double minutosLeft2(String m)throws NullPointerException{
        double contador = 0;
        if(!this.lugares.containsKey(m)){
            throw new NullPointerException();
        }

        Iterator<Lugar> it = this.lugares.values().iterator();
        while(it.hasNext()){
            Lugar l = it.next();
            if(l.getMatricula().equals(m)){
                contador += l.getMinutos();
            }
        }   return contador;
    }

    public boolean existeLugar(String m){
       return this.lugares.values().stream()
                .anyMatch(l -> l.getMatricula().equals(m));
    }


    public String informacao(String m){
        return this.lugares.values().stream()
                .filter(l -> l.getMatricula().equals(m))
                .findFirst()
                .map(Lugar::toString)
                .orElse(null);
    }


}
