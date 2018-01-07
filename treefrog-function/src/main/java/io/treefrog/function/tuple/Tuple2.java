package io.treefrog.function.tuple;

import io.treefrog.function.Consumer2;
import io.treefrog.function.Function2;
import io.treefrog.function.Predicate2;

public interface Tuple2<V1, V2> extends Tuple {
  <R> Tuple1<R> map(Function2<? super V1, ? super V2, ? extends R> mapping);
  <T extends Tuple> T flatMap(Function2<? super V1, ? super V2, ? extends T> mapping);
  Tuple2<? super V1, ? super V2> peek(Consumer2<? super V1, ? super V2> peeking);

  boolean matches(Predicate2<? super V1, ? super V2> condition);

  <R> R then(Function2<? super V1, ? super V2, ? extends R> ending);
}
