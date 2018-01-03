package io.treefrog.function;

import java.util.Objects;
import java.util.function.Consumer;

public interface Consumer1<T> extends Consumer<T> {
  default Consumer1<T> then(Consumer1<? super T> after) {
    Objects.requireNonNull(after);
    return (T t) -> { accept(t); after.accept(t); };
  }
}
