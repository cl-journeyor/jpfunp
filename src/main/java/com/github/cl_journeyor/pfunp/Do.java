package com.github.cl_journeyor.pfunp;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public final class Do {
    private Do() {

    }

    // Test if it works
    public static <T> Stream<T> repeat(T item) {
        return Stream.iterate(item, Func::identity);
    }

    public static <T> T scope(Supplier<T> supplier) {
        Objects.requireNonNull(supplier);

        return supplier.get();
    }

    public static <T> T to(T mutable, Consumer<T> mutator) {
        Objects.requireNonNull(mutator);

        mutator.accept(mutable);

        return mutable;
    }

    public static <T> T until(T seed, Predicate<T> condition, UnaryOperator<T> accumulator) {
        Objects.requireNonNull(condition);
        Objects.requireNonNull(accumulator);

        while (!condition.test(seed)) {
            seed = accumulator.apply(seed);
        }

        return seed;
    }
}
