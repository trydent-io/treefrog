package io.treefrog.function;

import java.util.function.BiPredicate;

@FunctionalInterface
public interface Predicate2<T1, T2> extends BiPredicate<T1, T2>, Functional.Pre {
}
