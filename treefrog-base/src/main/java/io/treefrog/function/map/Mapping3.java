package io.treefrog.function.map;

import io.treefrog.function.Function3;
import io.treefrog.function.Functional;
import io.treefrog.function.tuple.Tuple3;

@FunctionalInterface
public interface Mapping3<V1, V2, V3> extends Functional.Map {
  <R1, R2, R3, T extends Tuple3<R1, R2, R3>> Mapping3<R1, R2, R3> map(Function3<V1, V2, V3, T> f);
}
