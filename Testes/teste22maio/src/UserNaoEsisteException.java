public class UserNaoEsisteException extends Exception {

    public UserNaoEsisteException(){
        super();
        System.out.println("User não existe");
    }

    // Excessão esta incompleta. Apenas para ser chamada em métodos
}
