package Transport;

public class NegativeValueException extends RuntimeException {
    public NegativeValueException(String message, Throwable error) {
        super(message, error);
    }
    public NegativeValueException(String message) {
        super(message);
    }
}
