package com.github.cl_journeyor.pfunp;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Utility functions for functional programming.
 * <p>
 * Passing null to a functional interface argument from any method of this class will throw a
 * <code>NullPointerException</code>, unless noted otherwise.
 * 
 * @author cl-journeyor
 * @version 2026-01-18
 * @since 1.0-SNAPSHOT
 */
public final class Do {
    private Do() {

    }

    /**
     * Returns an infinite stream by repeating the provided value.
     * 
     * @param <T> the type of the repeated value
     * @param item the item to be repeated in the stream
     * @return the infinite stream
     */
    public static <T> Stream<T> repeat(T item) {
        return Stream.iterate(item, Func::identity);
    }

    /**
     * Defines a new local scope on which statements may be written in order to return a new value.
     * 
     * @param <T> the type of the value this local scope returns
     * @param supplier a parameterless function that allows writting statements within an expression
     * @return what the supplier returns
     */
    public static <T> T scope(Supplier<T> supplier) {
        Objects.requireNonNull(supplier);

        return supplier.get();
    }

    /**
     * Defines a nested scope on which statements may be written in order to return a value,
     * with the chance to propagate checked exceptions to the enclosing scope.
     * 
     * @param <T> the type of the value this scope returns
     * @param <X> the type of the exception the scope may throw
     * @param supplier a parameterless function that allows writting statements within an expression
     * @return what the supplier returns
     * @throws X if the supplier fails to return
     */
    public static <T, X extends Throwable> T scopeX(SupplierX<T, X> supplier) throws X {
        Objects.requireNonNull(supplier);

        return supplier.get();
    }

    /**
     * Takes a mutable object, mutates it with the provided mutator function and returns the mutated object.
     * 
     * @param <T> the type of the mutable object
     * @param mutable an object
     * @param mutator a procedure that takes the mutable object
     * @return the mutated object
     */
    public static <T> T to(T mutable, Consumer<T> mutator) {
        Objects.requireNonNull(mutator);

        mutator.accept(mutable);

        return mutable;
    }

    /**
     * Takes a mutable object, mutates it with the provided mutator function and returns the mutated object,
     * with the chance to propagate checked exceptions to the caller.
     * 
     * @param <T> the type of the mutable object
     * @param <X> the type of the exception the mutator may throw
     * @param mutable an object
     * @param mutator a procedure that takes the mutable object
     * @return the mutated object
     * @throws X if the mutator fails to complete
     */
    public static <T, X extends Throwable> T toX(T mutable, ConsumerX<T, X> mutator) throws X {
        Objects.requireNonNull(mutator);

        mutator.accept(mutable);

        return mutable;
    }

    /**
     * Accumulates the provided seed on loop and returns it when the condition is true.
     * 
     * @param <T> the type of the initial value (seed)
     * @param seed the value to be tested and accumulated
     * @param condition the condition that controls the loop
     * @param accumulator a function to be applied to the seed
     * @return the result of accumulating the seed once the condition is true
     */
    public static <T> T until(T seed, Predicate<T> condition, UnaryOperator<T> accumulator) {
        Objects.requireNonNull(condition);
        Objects.requireNonNull(accumulator);

        while (!condition.test(seed)) {
            seed = accumulator.apply(seed);
        }

        return seed;
    }
}
