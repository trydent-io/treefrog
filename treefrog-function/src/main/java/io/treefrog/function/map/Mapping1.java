package io.treefrog.function.map;

import io.treefrog.function.Function1;
import io.treefrog.function.Functional;

@FunctionalInterface
public interface Mapping1<V1> extends Functional.Map {
  <R, M extends Mapping1<R>> M map(Function1<V1, R> f);
}
