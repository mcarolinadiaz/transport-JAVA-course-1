package Transport;

public interface IEmbark {
    public abstract void embarkPassengers(int passengers) throws InvalidOperationException;
    public abstract void disembarkPassengers(int passengers) throws InvalidOperationException;
}
