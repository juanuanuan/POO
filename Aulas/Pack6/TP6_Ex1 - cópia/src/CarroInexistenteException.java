public class CarroInexistenteException extends RuntimeException {

    public CarroInexistenteException(){
        super("Não existe carro com a respetiva matrícula");
    }
    public CarroInexistenteException(String message) {

        super(message);
    }
}
