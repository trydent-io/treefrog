package io.treefrog.function.tuple;

import io.treefrog.function.Consumer3;
import io.treefrog.function.Function3;
import io.treefrog.function.Predicate3;

public interface Tuple3<V1, V2, V3> extends Tuple {

  <R> Tuple1<R> map(Function3<? super V1, ? super V2, ? super V3, ? extends R> mapping);
  <T extends Tuple> T flatMap(Function3<? super V1, ? super V2, ? super V3, ? extends T> mapping);

  Tuple3<V1, V2, V3> peek(Consumer3<? super V1, ? super V2, ? super V3> peeking);

  boolean matches(Predicate3<? super V1, ? super V2, ? super V3> condition);
}
