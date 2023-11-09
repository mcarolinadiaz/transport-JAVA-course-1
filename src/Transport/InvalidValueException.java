package Transport;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException(String message, Throwable error) {
        super(message, error);
    }
    public InvalidValueException(String message) {
        super(message);
    }

}
