package io.treefrog.lang.array;

import java.util.Iterator;

import static java.util.Objects.nonNull;

public final class RawCursor<T> implements Iterator<T> {
  private final T[] ts;
  private int index;

  public RawCursor(T[] ts) {
    this(ts, 0);
  }
  private RawCursor(T[] ts, int index) {
    this.ts = ts;
    this.index = index;
  }

  @Override
  public boolean hasNext() {
    return nonNull(ts) && ts.length > 0 && index < ts.length;
  }

  @Override
  public T next() {
    return ts[index++];
  }
}
