package io.treefrog.lang.array;

import java.util.Enumeration;

public interface Array<T> extends Iterable<T> {
  int length();
  default boolean isEmpty() { return length() <= 0; }
  default boolean isNotEmpty() { return length() > 0; }
  @Deprecated(forRemoval = true)
  T[] copy(T[] dest);

  @SafeVarargs
  static <S> Array<S> of(S... values) {
    return new ArrayImpl<>(values);
  }
  static <S> Array<S> empty() {
    return new EmptyArray<>(new EmptyCursor<>());
  }
  static <S> Array<S> of(Enumeration<S> enumeration) {
    return new EnumerationArray<>(enumeration);
  }
}
