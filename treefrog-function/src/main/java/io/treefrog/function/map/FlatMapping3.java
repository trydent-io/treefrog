package io.treefrog.function.map;

import io.treefrog.function.Function3;
import io.treefrog.function.Functional;

@FunctionalInterface
public interface FlatMapping3<V1, V2, V3> {
  <R extends Functional.Map> R flatMap(Function3<V1, V2, V3, ? extends R> f);
}
