package com.solvd.transport;

/** IStartUp is custom Lambda functions with generics.
 * @param <T> is a generic param.
 */
@FunctionalInterface
public interface IStartUp<T> {
    void run(T t);
}
