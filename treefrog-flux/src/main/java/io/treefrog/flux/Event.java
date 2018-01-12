package io.treefrog.flux;

import io.treefrog.function.tuple.Tuple;

public interface Event extends Tuple {
  <E extends Enum> boolean is(E type);
}
