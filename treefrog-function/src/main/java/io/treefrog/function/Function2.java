package io.treefrog.function;

import java.util.function.BiFunction;

public interface Function2<T1, T2, R> extends BiFunction<T1, T2, R> {
  default <V> BiFunction<T1, T2, V> then(Function1<? super R, ? extends V> after) {
    return andThen(after);
  }
}
