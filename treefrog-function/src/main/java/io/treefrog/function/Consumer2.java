package io.treefrog.function;

import java.util.Objects;
import java.util.function.BiConsumer;

public interface Consumer2<T1, T2> extends BiConsumer<T1, T2> {
  default Consumer2<T1, T2> then(Consumer2<? super T1, ? super T2> after) {
    Objects.requireNonNull(after);
    return (l, r) -> {
      accept(l, r);
      after.accept(l, r);
    };
  }
}
