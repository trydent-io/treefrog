package io.treefrog.function.struct;

import io.treefrog.function.Function2;
import io.treefrog.function.Functional;

public interface Mapping2<V1, V2> {
  <R1, R2> Mapping2<R1, R2> map(Function2<V1, V2, R1, R2> f);
  <T1, T2, R extends Mapping2<T1, T2>> R flatMap(Function2<V1, V2, R> f);
}
