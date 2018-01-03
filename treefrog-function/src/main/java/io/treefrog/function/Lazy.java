package io.treefrog.function;

import java.util.function.Supplier;

public interface Lazy<T> extends Supplier<T> {
  static <P> Lazy<P> lazy(Supplier<P> supply) {
    return new LazyImpl<>(supply);
  }
  static <P> Lazy<P> empty() {
    return new LazyImpl<>(null);
  }

  Lazy<T> reset();
  Lazy<T> set(Supplier<T> supply);
  T setAndGet(Supplier<T> supply);
}
