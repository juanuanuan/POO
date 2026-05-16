public class CarroTemDeExistirParaViagemException extends RuntimeException {
    public CarroTemDeExistirParaViagemException(){
        super("Só podem ser registadas viagens em carros que existam");
    }
    public CarroTemDeExistirParaViagemException(String message) {
        super(message);
    }

    //A excessão do Carro nao existir já cobre esta, sendo esta inútil.
}
