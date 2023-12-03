package com.solvd.transport.interfaces;
@FunctionalInterface
public interface ICalculateFee<T> {
    T calculateFee(T t);
}
