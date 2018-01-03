package io.treefrog.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;

public final class Maybe<T> {
  private final T value;

  private Maybe(T value) {
    this.value = value;
  }

  private static <D> Maybe<D> empty() {
    return new Maybe<>((D) null);
  }

  public static <D> Maybe<D> of(final D value) {
    return new Maybe<>(value);
  }

  public <D> Maybe<D> map(Function<T, D> transform) {
    return nonNull(value) && nonNull(transform)
      ? new Maybe<>(transform.apply(value))
      : empty();
  }

  public Maybe<T> filter(Predicate<T> condition) {
    return nonNull(value) && nonNull(condition)
      ? condition.test(value) ? this : empty()
      : empty();
  }

  public <D> Maybe<D> flatMap(Function<T, Maybe<D>> flatTransform) {
    return nonNull(value) && nonNull(flatTransform)
      ? flatTransform.apply(value)
      : empty();
  }

  public Maybe<T> peek(Consumer<T> apply) {
    atLast(apply);
    return this;
  }

  public void atLast(Consumer<T> apply) {
    if (nonNull(value) && nonNull(apply)) apply.accept(value);
    apply.accept(value);
  }

  public T value() { return this.value; }
}
