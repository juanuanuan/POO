public class CarroCombustao extends Carro{
    @Override
    public CarroCombustao clone() {
        return new CarroCombustao();  // clone esta mal!!! mas esta assim so para ser chamado fora da classe
    }

    @Override
    public double valorAPagar() {
        return 0; // mesma explicação
    }

    // aqui a ideia de teste era apenas criar a classe, é escusado definir métodos


}
