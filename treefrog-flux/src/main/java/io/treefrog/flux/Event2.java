package io.treefrog.flux;

import io.treefrog.function.Consumer2;
import io.treefrog.function.Function2;
import io.treefrog.function.tuple.Tuple2;

import static java.util.Objects.requireNonNull;

public final class Event2<E extends Enum, V1, V2> implements Event {
  private final E type;
  private final Tuple2<V1, V2> tuple;

  Event2(E type, Tuple2<V1, V2> tuple) {
    this.type = type;
    this.tuple = tuple;
  }

  @Override
  public <T extends Enum> boolean is(T type) {
    return this.type.equals(type);
  }

  public <R1, R2> Event2<E, R1, R2> change(Function2<V1, V2, Tuple2<R1, R2>> f) {
    return new Event2<>(type, tuple.then((t1, t2) -> requireNonNull(f, "").apply(t1, t2)));
  }

  public Event2<E, V1, V2> then(Consumer2<V1, V2> c) {
    tuple.peek((t1, t2) -> requireNonNull(c, "Consumer must be not null").accept(t1, t2));
    return this;
  }

  public void eventually(Consumer2<V1, V2> c) {
    tuple.peek((t1, t2) -> requireNonNull(c, "Consumer must be not null").accept(t1, t2));
  }

  public Event2<E, V1, V2> fire() {
    return this;
  }

  public <X extends Event> X trigger(Function2<V1, V2, X> f) {
    return tuple.then((t1, t2) -> requireNonNull(f, "Function must be not null").apply(t1, t2));
  }
}
