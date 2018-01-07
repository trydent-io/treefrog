package io.treefrog.flux;

import io.treefrog.function.Function1;
import io.treefrog.function.tuple.Tuple;

public interface Event {
  static <E extends Enum, T extends Tuple> Event event(E type, T tuple) {
    return new EventImpl<>(type, tuple);
  }

  <E extends Enum> boolean is(E type);
  <T extends Tuple> boolean apply(Function1<T, Boolean> applying);
}
