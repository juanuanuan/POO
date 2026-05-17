import java.util.*;
import java.util.stream.Collectors;


public class CasaInteligente {
    private Map<String, Divisao> divisoes;



    public CasaInteligente(){
        this.divisoes = new HashMap<>();
    }

    public CasaInteligente(Map<String,Divisao> divisoes){
        this.divisoes = new HashMap<>();
        divisoes.forEach((k,v) -> this.divisoes.put(k, v.clone()));
    }

    public CasaInteligente(CasaInteligente other){
        this.divisoes = new HashMap<>();
        other.divisoes.forEach((k,v) -> this.divisoes.put(k, (Divisao) v.clone()));
    }

    public void setUpL(Collection<String> nomes){
        this.divisoes = new HashMap<>();
        nomes.forEach(k -> this.divisoes.put(k, new Divisao()));
    }

    public void addLampada(Lampada l, String div){
        this.divisoes.values().stream()
                .filter(d -> d.getNome().equals(div))
                .findFirst()
                .ifPresent(d -> d.adicionaL(l));
    }

    public boolean existeDiv(String div){
        return this.divisoes.containsKey(div);
    }

    public Collection<Lampada> lampadaEmDivisao(String div) throws NullPointerException{
        if(!this.divisoes.containsKey(div)){
            throw new NullPointerException();
        }

        return this.divisoes.get(div).getLampadas();
    }

    public void setEstado(String div, Lampada.Estado estado){
       this.divisoes.get(div).getLampadas().stream()
               .findFirst()
               .ifPresent(l -> l.setEstados(estado));

    }

    public String maisIluminada(){
        return this.divisoes.values().stream()
                .max(Comparator.comparingInt(d -> d.getLampadas().size()))
                .map(Divisao::getNome)
                .orElse(null);
    }

    public double consumoCasa(){
        return this.divisoes.values().stream()
                .mapToDouble(Divisao::getConsumoDivisao).sum();
    }

    public double consumoCasa2(){ // versão sem precisar recorrer à classe Lampadas
        return this.divisoes.values().stream()
                .flatMap(d-> d.getLampadas().stream())
                .mapToDouble(Lampada::getConsumo)
                .sum();
    }

    public Lampada removeLamp(int id) throws LampadaNaoExisteException{
        for(Divisao d : this.divisoes.values()){
            Iterator<Lampada> it = d.getLampadas().iterator();
            while(it.hasNext()){
                Lampada l = it.next();
                if(l.getId() == id){
                    it.remove();
                    return l.clone();
                }
            } throw new LampadaNaoExisteException(); //mandei a excessão só naquela :)
        }  return null;


    }

    public LampadaLed maisEconomica(){
        return this.divisoes.values().stream()
                .flatMap((d -> d.getLampadas().stream()))
                .filter(l -> l instanceof LampadaLed)
                .map(l -> (LampadaLed) l)
                .min(Comparator.comparingDouble(LampadaLed::calculaConsumo))
                .map(LampadaLed::clone)
                .orElse(null);

    }




}
