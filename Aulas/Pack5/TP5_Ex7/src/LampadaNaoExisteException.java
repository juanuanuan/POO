public class LampadaNaoExisteException extends NullPointerException {
    public LampadaNaoExisteException(){
        super("Esta lâmpada não existe.");

    }

    public LampadaNaoExisteException(String message) {

        super(message);
    }
}
