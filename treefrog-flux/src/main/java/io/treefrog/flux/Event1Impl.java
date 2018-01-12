package io.treefrog.flux;

import io.treefrog.function.Function1;
import io.treefrog.function.Functional;
import io.treefrog.function.map.Mapping1;

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
  public <F extends Functional.Fun> F map(Function1<V1, F> f) {
    return null;
  }

  @Override
  public <TA, R extends Mapping1<TA>> R flatMap(Function1<V1, R> f) {
    return null;
  }
}
