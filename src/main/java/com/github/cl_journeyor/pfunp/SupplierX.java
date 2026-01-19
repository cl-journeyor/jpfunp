package com.github.cl_journeyor.pfunp;

/**
 * Represents a type that may fail to return a value.
 * 
 * @param <T> the type of the value supplied by this instance
 * @param <X> the exception type that may be thrown
 * @author cl-journeyor
 * @version 2026-01-18
 * @since 1.0-SNAPSHOT
 */
@FunctionalInterface
public interface SupplierX<T, X extends Throwable> {
    /**
     * Returns this implementation's value.
     * 
     * @return an object
     * @throws X if an error occurs
     */
    T get() throws X;
}
