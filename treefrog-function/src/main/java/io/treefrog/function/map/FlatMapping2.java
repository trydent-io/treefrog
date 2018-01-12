package io.treefrog.function.map;

import io.treefrog.function.Function2;
import io.treefrog.function.Functional;

@FunctionalInterface
public interface FlatMapping2<V1, V2> {
  <R extends Functional.Map> R flatMap(Function2<V1, V2, ? extends R> f);
}
