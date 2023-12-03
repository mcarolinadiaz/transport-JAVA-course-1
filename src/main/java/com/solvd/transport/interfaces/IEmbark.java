package com.solvd.transport.interfaces;

import com.solvd.transport.InvalidOperationException;

import java.util.List;

public interface IEmbark {
    public abstract void embarkPassengers(List<String> passengers) throws InvalidOperationException;
    public abstract void disembarkPassengers(List<String> passengers) throws InvalidOperationException;
}
