package Transport;

public class NotClosedException extends RuntimeException{
    public NotClosedException(String message) {
        super(message);
    }
}
