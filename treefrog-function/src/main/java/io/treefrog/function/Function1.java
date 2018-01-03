package io.treefrog.function;

import java.util.function.Function;

public interface Function1<T, R> extends Function<T, R> {
  default <V> Function<T, V> then(Function<? super R, ? extends V> after) {
    return andThen(after);
  }
}
