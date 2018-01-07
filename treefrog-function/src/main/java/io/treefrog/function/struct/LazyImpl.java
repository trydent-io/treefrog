package io.treefrog.function.struct;

import java.util.function.Supplier;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNullElseGet;

final class LazyImpl<P> implements Lazy<P> {
  private volatile Supplier<P> supply;
  private volatile P value;

  LazyImpl(Supplier<P> supply) {
    this.supply = supply;
  }

  @Override
  public Lazy<P> reset() {
    this.value = null;
    return this;
  }

  @Override
  public Lazy<P> set(Supplier<P> supply) {
    synchronized (this) {
      this.supply = supply;
    }

    return this;
  }

  @Override
  public P setAndGet(Supplier<P> supply) {
    set(supply);
    return get();
  }

  @Override
  public P get() {
    if (isNull(value) && nonNull(supply)) synchronized (this) {
      this.value = requireNonNullElseGet(this.value, supply);
    }

    return value;
  }
}
