package io.treefrog.function.map;

import io.treefrog.function.Function1;
import io.treefrog.function.Functional;

@FunctionalInterface
public interface FlatMapping1<V1> {
  <R extends Functional.Map> R flatMap(Function1<V1, ? extends R> f);
}
