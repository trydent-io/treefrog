package io.treefrog.lang.array;

import java.util.Iterator;

import static java.lang.System.arraycopy;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class DefaultArray<T> implements Array<T> {
  final T[] items;

  DefaultArray(T[] items) {
    this.items = items;
  }

  @Override
  public final int length() {
    return isNull(items) ? -1 : items.length;
  }

  @Override
  public final T[] copy(T[] dest) {
    if (nonNull(dest) && dest.length == items.length) arraycopy(this.items, 0, dest, 0, this.items.length);
    return dest;
  }

  @Override
  public final Iterator<T> iterator() {
    return new RawCursor<>(items);
  }
}
