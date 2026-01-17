package com.github.cl_journeyor.pfunp;

public record Pair<T, U>(T item1, U item2) {
    public static <T, U> Pair<T, U> $(T item1, U item2) {
        return new Pair<>(item1, item2);
    }
}
