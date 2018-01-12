package io.treefrog.function.map;

import io.treefrog.function.Function2;
import io.treefrog.function.Functional;
import io.treefrog.function.tuple.Tuple2;

@FunctionalInterface
public interface Mapping2<V1, V2> extends Functional.Map {
  <R1, R2, T extends Tuple2<R1, R2>> Mapping2<R1, R2> map(Function2<V1, V2, T> f);
}
