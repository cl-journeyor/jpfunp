package com.github.cl_journeyor.pfunp;

/**
 * Defines functions typically used as method references.
 * 
 * @author cl-journeyor
 * @version 2026-01-18
 * @since 1.0-SNAPSHOT
 */
public final class Func {
    private Func() {

    }

    /**
     * Returns the provided value.
     * 
     * @param <T> the type of the input
     * @param input an object
     * @return the object
     */
    public static <T> T identity(T input) {
        return input;
    }
}
