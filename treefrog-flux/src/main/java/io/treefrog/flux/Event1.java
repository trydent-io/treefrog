package io.treefrog.flux;

import io.treefrog.function.Consumer1;
import io.treefrog.function.Function1;
import io.treefrog.function.tuple.Tuple;
import io.treefrog.function.tuple.Tuple1;

import static io.treefrog.flux.Event.event;
import static io.treefrog.function.tuple.Tuple.tuple;
import static java.util.Objects.requireNonNull;

public final class Event1<E extends Enum, V1> implements Event {
  private final E type;
  private final Tuple1<V1> tuple;

  Event1(E type, Tuple1<V1> tuple) {
    this.type = type;
    this.tuple = tuple;
  }

  @Override
  public <T extends Enum> boolean is(T type) {
    return this.type.equals(type);
  }

  public <R> Event1<E, R> change(Function1<V1, R> f) {
    return new Event1<>(type, tuple.then(it -> Tuple.tuple(requireNonNull(f, "").apply(it))));
  }

  public Event1<E, V1> then(Consumer1<V1> c) {
    tuple.peek(it -> requireNonNull(c, "Consumer must be not null").accept(it));
    return this;
  }

  public void eventually(Consumer1<V1> c) {
    tuple.peek(it -> requireNonNull(c, "Consumer must be not null").accept(it));
  }

  public Event1<E, V1> fire() {
    return this;
  }

  public <X extends Event> X trigger(Function1<V1, X> f) {
    return tuple.then(it -> requireNonNull(f, "Function must be not null").apply(it));
  }
}
