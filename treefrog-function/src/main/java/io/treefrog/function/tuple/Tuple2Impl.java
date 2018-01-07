package io.treefrog.function.tuple;

import io.treefrog.function.Consumer2;
import io.treefrog.function.Function2;
import io.treefrog.function.Predicate2;

import static io.treefrog.function.tuple.Tuple.tuple;
import static java.util.Objects.requireNonNull;

final class Tuple2Impl<V1, V2> implements Tuple2<V1, V2> {
  private final V1 v1;
  private final V2 v2;

  Tuple2Impl(V1 v1, V2 v2) {
    this.v1 = v1;
    this.v2 = v2;
  }

  @Override
  public <R> Tuple1<R> map(Function2<? super V1, ? super V2, ? extends R> mapping) {
    return tuple(requireNonNull(mapping, "Mapping must be not null").apply(v1, v2));
  }

  @Override
  public <T extends Tuple> T flatMap(Function2<? super V1, ? super V2, ? extends T> mapping) {
    return requireNonNull(mapping, "Flat-Mapping must be not null").apply(v1, v2);
  }

  @Override
  public Tuple2<? super V1, ? super V2> peek(Consumer2<? super V1, ? super V2> peeking) {
    requireNonNull(peeking, "Peeking must be not null").accept(v1, v2);
    return this;
  }

  @Override
  public boolean matches(Predicate2<? super V1, ? super V2> condition) {
    return requireNonNull(condition, "Condition must be not null").test(v1, v2);
  }

  @Override
  public <R> R then(Function2<? super V1, ? super V2, ? extends R> ending) {
    return requireNonNull(ending, "Then must be not null").apply(v1, v2);
  }
}
