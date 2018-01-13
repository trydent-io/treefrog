package io.treefrog.flux;

import io.treefrog.function.Function2;
import io.treefrog.function.Functional;
import io.treefrog.function.map.Mapping2;
import io.treefrog.function.tuple.Tuple2;

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
  public <R extends Functional.Map> R flatMap(Function2<V1, V2, ? extends R> f) {
    return null;
  }

  @Override
  public <R1, R2, T extends Tuple2<R1, R2>> Mapping2<R1, R2> map(Function2<V1, V2, T> f) {
    return null;
  }
}
