import java.util.HashMap;
import java.util.Map;

public class MasterUber {
    private Map<String, UbersPOO> empresas;
    private Map<String, Carro> carros;

    public Map<String, Carro> getCarros() {
        Map<String, Carro> copia = new HashMap<>();
        this.carros.forEach((k,v) -> copia.put(k, v.clone()));

        return copia;
    }

    public Map<String, UbersPOO> getEmpresas() {
        Map<String, UbersPOO> copia = new HashMap<>();
        this.empresas.forEach((k,v) -> copia.put(k, v.clone()));

        return copia;
    }



    public void forneceCarro(Carro c, String empresaLocal){
        this.empresas.values().stream()
                .filter(e -> e.getNomeCompanhia().equals(empresaLocal))
                .findFirst()
                .map(UbersPOO::clone)
                .ifPresent(k -> k.adicionaCarroFornecido(c));
    }
}

