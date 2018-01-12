package io.treefrog.flux;

import io.treefrog.function.map.FlatMapping1;
import io.treefrog.function.map.Mapping1;

public interface Event1<V1> extends Event, Mapping1<V1>, FlatMapping1<V1> {
  static <N extends Enum, T> Event1<T> event1(N type, T value) {
    return new Event1Impl<>(type, value);
  }
}
