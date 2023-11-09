package Transport;
// Custom exception class to represent invalid model.
public class InvalidModelException extends RuntimeException{
    // Constructor with a message for the exception.
    public InvalidModelException(String message) {
        super(message);
    }
}
