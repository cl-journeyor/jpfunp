package com.github.cl_journeyor.pfunp;

/**
 * Represents a type that may fail to process a given value.
 * 
 * @param <T> the type of the value to consume
 * @param <X> the exception type that may be thrown
 * @author cl-journeyor
 * @version 2026-01-18
 * @since 1.0-SNAPSHOT
 */
@FunctionalInterface
public interface ConsumerX<T, X extends Throwable> {
    /**
     * Uses the provided value, presumably for side-effects.
     * 
     * @param value an object
     * @throws X if an error occurs
     */
    void accept(T value) throws X;
}
