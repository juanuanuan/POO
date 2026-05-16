public class MatriculaUnicaException extends RuntimeException {
    public MatriculaUnicaException(){
        super("As matrículas são únicas, dois carros não podem ter a mesma matrícula ");
    }

    public MatriculaUnicaException(String message) {

        super(message);
    }


    // não há nenhuma implementação coerente desta excessão, mas vale a pena defini-la
}
