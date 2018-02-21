package io.treefrog.lang.array;

import java.util.Iterator;

final class EmptyArray<T> implements Array<T> {
  private final ArrayCursor<T> cursor;

  EmptyArray(ArrayCursor<T> cursor) {
    this.cursor = cursor;
  }

  @Override
  public int length() {
    return 0;
  }

  @Override
  public T[] copy(T[] dest) {
    return dest;
  }

  @Override
  public Iterator<T> iterator() {
    return cursor;
  }
}
