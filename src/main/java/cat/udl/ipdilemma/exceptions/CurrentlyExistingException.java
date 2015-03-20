package cat.udl.ipdilemma.exceptions;

/**
 * Exception to be thrown when there can only be one element and it is tried to
 * add more
 */
public class CurrentlyExistingException extends Exception {
    
    public CurrentlyExistingException() {
        super();
    }
    
    public CurrentlyExistingException(String msg) {
        super(msg);
    }
}
