package com.solvd.transport;
@FunctionalInterface
public interface ICalculateFee<T> {
    T calculateFee(T t);
}
