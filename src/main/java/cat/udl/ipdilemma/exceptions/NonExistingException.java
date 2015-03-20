package cat.udl.ipdilemma.exceptions;

/**
 * Exception to be thrown when it is tried to retrieve an non existing element
 */
public class NonExistingException extends Exception {
    
    public NonExistingException() {
        super();
    }
    
    public NonExistingException(String msg) {
        super(msg);
    }
}
