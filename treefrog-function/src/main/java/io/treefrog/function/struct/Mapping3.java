package io.treefrog.function.struct;

import io.treefrog.function.Function1;
import io.treefrog.function.Function2;
import io.treefrog.function.Function3;
import io.treefrog.function.Functional;

public interface Mapping3<V1, V2, V3> {
  <F extends Functional.Fun> F map(Function3<V1, V2, V3, F> f);
  <T1, T2, T3, R extends Mapping3<T1, T2, T3>> R flatMap(Function3<V1, V2, V3, R> f);
}
