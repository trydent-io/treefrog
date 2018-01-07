package io.treefrog.function.tuple;

import io.treefrog.function.Consumer3;
import io.treefrog.function.Function3;
import io.treefrog.function.Predicate3;

import static io.treefrog.function.tuple.Tuple.tuple;
import static java.util.Objects.requireNonNull;

final class Tuple3Impl<V1, V2, V3> implements Tuple3<V1, V2, V3> {
  private final V1 v1;
  private final V2 v2;
  private final V3 v3;

  Tuple3Impl(V1 v1, V2 v2, V3 v3) {
    this.v1 = v1;
    this.v2 = v2;
    this.v3 = v3;
  }

  @Override
  public <R> Tuple1<R> map(Function3<? super V1, ? super V2, ? super V3, ? extends R> mapping) {
    return tuple(requireNonNull(mapping, "Mapping must be not null").apply(v1, v2, v3));
  }

  @Override
  public <T extends Tuple> T flatMap(Function3<? super V1, ? super V2, ? super V3, ? extends T> mapping) {
    return requireNonNull(mapping, "Mapping must be not null").apply(v1, v2, v3);
  }

  @Override
  public Tuple3<V1, V2, V3> peek(Consumer3<? super V1, ? super V2, ? super V3> peeking) {
    requireNonNull(peeking, "Peeking must be not null").accept(v1, v2, v3);
    return this;
  }

  @Override
  public boolean matches(Predicate3<? super V1, ? super V2, ? super V3> condition) {
    return requireNonNull(condition, "Condition must be not null").test(v1, v2, v3);
  }
}
