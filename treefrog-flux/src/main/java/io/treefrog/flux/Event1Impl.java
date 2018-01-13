package io.treefrog.flux;

import io.treefrog.function.Function1;
import io.treefrog.function.Functional;
import io.treefrog.function.map.Mapping1;

import static io.treefrog.flux.Event1.*;

final class Event1Impl<E extends Enum, V1> implements Event1<V1> {
  private final E type;
  private final V1 value;

  Event1Impl(E type, V1 value) {
    this.type = type;
    this.value = value;
  }

  @Override
  public <T extends Enum> boolean is(T type) {
    return false;
  }

  @Override
  public <R extends Functional.Map> R flatMap(Function1<V1, ? extends R> f) {
    return null;
  }


  @Override
  public <R, M extends Mapping1<R>> M map(Function1<V1, R> f) {
    final Event1<R> e = Event1.event1(type, f.apply(value));
    return e;
  }
}
