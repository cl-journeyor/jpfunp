package com.github.cl_journeyor.pfunp;

@FunctionalInterface
public interface SupplierX<T, X extends Throwable> {
    T get() throws X;
}
