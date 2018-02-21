package io.treefrog.lang.array;

final class ArrayImpl<T> extends DefaultArray<T> implements Array<T> {
  ArrayImpl(T[] ts) {
    super(ts);
  }
}
