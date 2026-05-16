
import java.util.*;
import java.util.stream.Collectors;


public class CarRental implements Comparable<CarroEletrico> {
    private String nomeEmpresa;
    private Map<String, Carro> carros;

    public CarRental(){
        this.nomeEmpresa = "";
        this.carros = new HashMap<>();
    }

    public CarRental(String nomaEmpresa, HashMap<String,Carro> carros){
        this.nomeEmpresa = nomaEmpresa;
        this.carros = carros; // ??
    }

    public CarRental(CarRental other){
        this.nomeEmpresa = other.getNomeEmpresa();
        this.carros = new HashMap<>();
        for(Carro c : other.carros.values()){
            this.carros.put(c.getMatricula(), c.clone());

        }
    }

    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    public Map<String, Carro> getCarros() {
        return this.carros;
    }


    public CarRental clone(){
        return new CarRental(this);
    }

    public boolean equals (Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        CarRental other = (CarRental) o;
        return (this.nomeEmpresa.equals(other.nomeEmpresa) && this.carros == other.carros);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getNomeEmpresa()).append(" | ");
        sb.append(this.getCarros()).append(" | ");

        return sb.toString();
    }

    public int quantos(String marca){
        return (int) this.carros.values().stream()
                .filter(c -> c.getMarca().equals(marca))
                .count();

    }

    public void adicionaCarro(Carro v){
        this.carros.putIfAbsent(v.getMatricula(), v.clone());
    }

    public List<Carro> getAllCarros(){
        return this.carros.values().stream()
                .map(Carro::clone)
                .toList();
    }

    public void adiciona(Set<Carro> vs){
        for(Carro c : vs){
            this.carros.put(c.getMatricula(), c); // versao 1
        }
    }

    public void adiciona2(Set<Carro> vvs){
        vvs.stream()
                .map(Carro::clone)
                .forEach(c -> this.carros.put(c.getMatricula(), c)); //versao 2 mais segura com clone

    }

    public int quantosC(){
        int contador = 0;
        for(Carro c : this.carros.values()){
            if(c.existeCarro()){
                contador ++;
            }

        } return contador;  // versao 1 mais simples, mas menos eficiente
    }


    public int quantosC2(){
        return (int) this.carros.values().stream()
                .filter(Carro::existeCarro)
                .count(); // versao 2 percorre com iteradores internos
    }

    public Carro getCarroC(String cod){
        if(!this.carros.containsKey(cod)){
            throw new CarroInexistenteException();
        }
        for(Carro c : this.carros.values()){
            if(cod.equals(c.getMatricula())){
                return c;
            }
        } return null;
    }

    public void registaViagem(String cod, float numKms){
        if(!this.carros.containsKey(cod)){
            throw new CarroInexistenteException();
        }
        for(Carro c : this.carros.values()){
            if(cod.equals(c.getMatricula())){
                c.setTotalKms(c.getTotalKms() + numKms);
            }
        }
    }

    public void atestarCarro(String cod) throws CarroInexistenteException{
        if(!this.carros.containsKey(cod)){
            throw new CarroInexistenteException();
        }
        for(Carro c : this.carros.values()){
            if(c.getMatricula().equals(cod)){
                if(c instanceof CarroCombustao){
                    ((CarroCombustao) c).setCapDeposito(c.getAutonomia());
                } else if(c instanceof CarroEletrico){
                    ((CarroEletrico) c).setCapCarga(c.getAutonomia());
                }
            }
        }
    }


    public Carro obterCarroMaisEco(){
        return this.carros.values().stream()
                .reduce((a,b) -> a.custoRealKm() < b.custoRealKm()?a:b)
                .map(Carro::clone) // usar sempre um clone antes de "lançar" a variável para fora da classe!!
                .orElse(null);
    }

    public Set<CarroEletrico> comBateriaDe(int nivelMinimo){
        return this.carros.values().stream()
                .filter(c -> c instanceof CarroEletrico)
                .map(c -> (CarroEletrico) c)
                .filter(c -> c.getAutonomia() < nivelMinimo)
                .map(CarroEletrico::clone)
                .collect(Collectors.toSet());

    }

    public Set<CarroEletrico> ordenado(){
        return this.carros.values().stream()
                .filter(c -> c instanceof CarroEletrico)
                .map(c -> (CarroEletrico) c)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public int compareTo(Carro other) {
       return 0;
    }

    public Comparator<Carro> comparaVelMedia() {
        return Comparator.comparingDouble(Carro::getVelMedia);
    }

    public Comparator<Carro> comparaPreco(){
        return Comparator.comparingDouble(Carro::getVelMedia);
    }

    public Comparator<Carro> comparaAnoFabrico(){
        return Comparator.comparingInt(Carro::getAnoFabrico);
    }

    //etc

    public Iterator<Carro> ordenarCarros(String criterio){
        switch(criterio){
            case "VM" -> {
                comparaVelMedia();
            }

            case "Preço" -> {
                comparaPreco();
            }

            case "AF" -> {
                comparaAnoFabrico();
            }

            // e por ai em diante
        } while(criterio!=null);

       return  this.carros.values().stream()
                .sorted()
                .iterator();
    }


    public Map<Float, List<Carro>> carrosPorAutonomia(){ // pus float porque a minha autonomia é em float
        return this.carros.values().stream()
                .collect(Collectors.groupingBy(Carro::getAutonomia));
    }

    @Override
    public int compareTo(CarroEletrico o) {
        return 0;
    }

    // na fase 3 ex 1, temos de fazer um compareTo na clase carro que ordene pelo numero de kms e pelo custo por km, de seguida, na CarRental fazemos.stream() .sorted() e vamos buscar o compareTo do Carro


    public List<PontosPorKm> verPontos(){
       return this.carros.values().stream()
               .filter(c -> c instanceof CarroEletrico)
               .map(c -> (CarroEletrico) c)
               .sorted(Comparator.comparingDouble(CarroEletrico::pontosPorCarro))
               .collect(Collectors.toList());
    }

    public List<CarroHibrido> getHibridos(){
        return this.carros.values().stream()
                .filter(c -> c instanceof CarroHibrido)
                .map(c -> (CarroHibrido) c)
                .map(c -> (CarroHibrido) c.clone())
                .collect(Collectors.toList());
    }




}
