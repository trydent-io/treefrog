package io.treefrog.lang.array;

final class EmptyCursor<T> implements ArrayCursor<T> {
  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public T next() {
    return null;
  }
}
