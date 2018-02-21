package io.treefrog.lang.array;

import java.util.Optional;

public interface IndexedArray<T> extends Array<T> {
  int indexOf(T t);
  Optional<T> at(int index);
  default boolean has(T value) { return indexOf(value) >= 0; }

  @SafeVarargs
  static <S> IndexedArray<S> indexedArray(S... values) {
    return new IndexedArrayImpl<>(values);
  }
}

