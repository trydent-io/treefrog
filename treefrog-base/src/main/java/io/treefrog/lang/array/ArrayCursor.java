package io.treefrog.lang.array;

import io.treefrog.lang.array.ArrayCursor.DefaultArrayCursor.ArrayCursorImpl;

import java.util.Iterator;

import static java.util.Objects.nonNull;

public interface ArrayCursor<E> extends Iterator<E> {
  static <T> ArrayCursor<T> of(T[] ts) {
    return new ArrayCursorImpl<>(ts);
  }
  static <T> ArrayCursor<T> deadend() {
    return new EmptyCursor<T>();
  }

  abstract class DefaultArrayCursor<E> implements ArrayCursor<E> {
    private final E[] es;
    private int index;

    protected DefaultArrayCursor(E[] es) {
      this(es, 0);
    }
    DefaultArrayCursor(E[] es, int index) {
      this.es = es;
      this.index = index;
    }

    @Override
    public final boolean hasNext() {
      return nonNull(es) && es.length > 0 && index < es.length;
    }

    @Override
    public final E next() {
      return es[index++];
    }

    static final class ArrayCursorImpl<E> extends DefaultArrayCursor<E> implements ArrayCursor<E> {
      ArrayCursorImpl(E[] es) {
        super(es);
      }
    }
  }
}
