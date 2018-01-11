package io.treefrog.function.struct;

import io.treefrog.function.Function1;
import io.treefrog.function.Functional;

public interface Mapping1<V1> extends Functional.Map {
  <R> Mapping1<R> map(Function1<V1, ? super R> f);
  <T, R extends Mapping1<T>> R flatMap(Function1<V1, ? extends R> f);
}
