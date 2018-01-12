package io.treefrog.function.map;

import io.treefrog.function.Function1;
import io.treefrog.function.Functional;

@FunctionalInterface
public interface Mapping1<V1> extends Functional.Map {
  <R> Mapping1<R> map(Function1<V1, ? super R> f);
}
