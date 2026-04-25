
import java.util.*;
import java. util. stream. Collectors;


public class CarRental {
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
        this.carros.put(v.getMatricula(), v);
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
        for(Carro c : this.carros.values()){
            if(cod.equals(c.getMatricula())){
                return c;
            }
        } return null;
    }

    public void registaViagem(String cod, float numKms){
        for(Carro c : this.carros.values()){
            if(cod.equals(c.getMatricula())){
                c.setTotalKms(c.getTotalKms() + numKms);
            }
        }
    }

    public void atestarCarro(String cod){
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



















}
