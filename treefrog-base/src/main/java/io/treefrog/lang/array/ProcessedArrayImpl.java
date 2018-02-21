package io.treefrog.lang.array;

final class ProcessedArrayImpl<T> extends DefaultProcessedArray<T> implements ProcessedArray<T> {
  ProcessedArrayImpl(T[] items, ArraySupplier<T> initializer) {
    super(items, initializer);
  }
}
