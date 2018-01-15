package io.treefrog.flux;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

public final class Event0<E extends Enum> implements Event {
  private final E type;

  Event0(E type) {
    this.type = type;
  }

  @Override
  public <T extends Enum> boolean is(T type) {
    return this.type.equals(type);
  }

  public Event0<E> then(Runnable r) {
    requireNonNull(r, "Runnable must be not null").run();
    return this;
  }

  public void eventually(Runnable r) {
    requireNonNull(r, "Runnable must be not null").run();
  }

  public Event0<E> fire() {
    return this;
  }

  public <X extends Event> X trigger(Supplier<X> s) {
    return requireNonNull(s, "Supplier must be not null").get();
  }
}
