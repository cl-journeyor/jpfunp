package com.github.cl_journeyor.pfunp;

/**
 * Heterogeneous data structure of two items.
 * 
 * @param <T> the type of the item 1
 * @param <U> the type of the item 2
 * @param item1 an object
 * @param item2 another object
 * @author cl-journeyor
 * @version 2026-01-18
 * @since 1.0-SNAPSHOT
 */
public record Pair<T, U>(T item1, U item2) {
    /**
     * Convenience method to create pairs without explicit type arguments.
     * <p>
     * Note: Use a static import on this method for syntactic sugar.
     * 
     * @param <T> the type of the item 1
     * @param <U> the type of the item 2
     * @param item1 an object
     * @param item2 another object
     * @return a pair
     */
    public static <T, U> Pair<T, U> $(T item1, U item2) {
        return new Pair<>(item1, item2);
    }
}
