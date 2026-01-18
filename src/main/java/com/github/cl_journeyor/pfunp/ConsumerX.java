package com.github.cl_journeyor.pfunp;

@FunctionalInterface
public interface ConsumerX<T, X extends Throwable> {
    void accept(T value) throws X;
}
