package com.solvd.transport;

import java.util.ArrayList;

public interface IEmbark {
    public abstract void embarkPassengers(ArrayList<String> passengers) throws InvalidOperationException;
    public abstract void disembarkPassengers(ArrayList<String> passengers) throws InvalidOperationException;
}
