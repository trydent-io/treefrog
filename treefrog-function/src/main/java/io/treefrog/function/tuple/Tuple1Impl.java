package io.treefrog.function.tuple;

import io.treefrog.function.Consumer1;
import io.treefrog.function.Function1;
import io.treefrog.function.Predicate1;

import static io.treefrog.function.tuple.Tuple.tuple;
import static java.util.Objects.requireNonNull;

final class Tuple1Impl<V> implements Tuple1<V> {
  private final V value;

  Tuple1Impl(V value) {
    this.value = value;
  }

  @Override
  public <R> Tuple1<R> map(Function1<? super V, ? extends R> mapping) {
    return tuple(mapping.apply(value));
  }

  @Override
  public <T extends Tuple> T flatMap(Function1<? super V, ? extends T> mapping) {
    return mapping.apply(value);
  }

  @Override
  public Tuple1<V> peek(Consumer1<? super V> peeking) {
    peeking.accept(value);
    return this;
  }

  @Override
  public boolean matches(Predicate1<? super V> condition) {
    return requireNonNull(condition, "Condition must be not null").test(value);
  }

  @Override
  public <R> R then(Function1<? super V, R> ending) {
    return ending.apply(value);
  }
}
