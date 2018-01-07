package io.treefrog.function.tuple;

public interface Tuple {
  static <V> Tuple1<V> tuple(V value) {
    return new Tuple1Impl<>(value);
  }

  static <V1, V2> Tuple2<V1, V2> tuple(V1 v1, V2 v2) {
    return new Tuple2Impl<>(v1, v2);
  }

  static <V1, V2, V3> Tuple3<V1, V2, V3> tuple(V1 v1, V2 v2, V3 v3) {
    return new Tuple3Impl<>(v1, v2, v3);
  }
}
