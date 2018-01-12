package io.treefrog.flux;

import io.treefrog.function.Function2;
import io.treefrog.function.Functional;
import io.treefrog.function.map.Mapping2;

final class Event2Impl<N extends Enum, V1, V2> implements Event2<V1, V2> {
  private final N type;
  private final V1 v1;
  private final V2 v2;

  Event2Impl(N type, V1 v1, V2 v2) {
    this.type = type;
    this.v1 = v1;
    this.v2 = v2;
  }

  @Override
  public <E extends Enum> boolean is(E type) {
    return false;
  }

  @Override
  public <F extends Functional.Fun> F map(Function2<V1, V2, F> f) {
    return null;
  }

  @Override
  public <T1, T2, R extends Mapping2<T1, T2>> R flatMap(Function2<V1, V2, R> f) {
    return null;
  }
}
