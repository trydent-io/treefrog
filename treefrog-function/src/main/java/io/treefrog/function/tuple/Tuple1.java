package io.treefrog.function.tuple;

import io.treefrog.function.Consumer1;
import io.treefrog.function.Function1;
import io.treefrog.function.Predicate1;

public interface Tuple1<V> extends Tuple {
  

  <R> Tuple1<R> map(Function1<? super V, ? extends R> mapping);
  <T extends Tuple> T flatMap(Function1<? super V, ? extends T> mapping);
  Tuple1<? super V> peek(Consumer1<? super V> peeking);

  boolean matches(Predicate1<? super V> condition);

  <R> R yield(Function1<? super V, R> ending);
}
