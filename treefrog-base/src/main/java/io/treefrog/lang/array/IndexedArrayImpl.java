package io.treefrog.lang.array;

final class IndexedArrayImpl<T> extends DefaultIndexedArray<T> implements IndexedArray<T> {
  IndexedArrayImpl(T[] items) {
    super(items);
  }
}
