package io.treefrog.flux;

import io.treefrog.function.Consumer3;
import io.treefrog.function.Function3;
import io.treefrog.function.tuple.Tuple3;

import static java.util.Objects.requireNonNull;

public final class Event3<E extends Enum, V1, V2, V3> implements Event {
  private final E type;
  private final Tuple3<V1, V2, V3> tuple;

  Event3(E type, Tuple3<V1, V2, V3> tuple) {
    this.type = type;
    this.tuple = tuple;
  }

  @Override
  public <T extends Enum> boolean is(T type) {
    return this.type.equals(type);
  }

  public <R1, R2, R3> Event3<E, R1, R2, R3> change(Function3<V1, V2, V3, Tuple3<R1, R2, R3>> f) {
    return new Event3<>(type, tuple.then((t1, t2, t3) -> requireNonNull(f, "").apply(t1, t2, t3)));
  }

  public Event3<E, V1, V2, V3> then(Consumer3<V1, V2, V3> c) {
    tuple.peek((t1, t2, t3) -> requireNonNull(c, "Consumer must be not null").accept(t1, t2, t3));
    return this;
  }

  public void eventually(Consumer3<V1, V2, V3> c) {
    tuple.peek((t1, t2, t3) -> requireNonNull(c, "Consumer must be not null").accept(t1, t2, t3));
  }

  public Event3<E, V1, V2, V3> fire() {
    return this;
  }

  public <X extends Event> X trigger(Function3<V1, V2, V3, X> f) {
    return tuple.then((t1, t2, t3) -> requireNonNull(f, "Function must be not null").apply(t1, t2, t3));
  }
}
