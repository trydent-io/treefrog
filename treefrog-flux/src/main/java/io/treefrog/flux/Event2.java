package io.treefrog.flux;

import io.treefrog.function.struct.Mapping2;

public interface Event2<V1, V2> extends Event, Mapping2<V1, V2> {
  static <N extends Enum, T1, T2> Event2<T1, T2> event2(N type, T1 v1, T2 v2) {
    return new Event2Impl<>(type, v1, v2);
  }
}
