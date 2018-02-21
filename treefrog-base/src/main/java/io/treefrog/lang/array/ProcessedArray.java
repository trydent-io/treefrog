package io.treefrog.lang.array;

public interface ProcessedArray<T> extends Array<T> {
  ProcessedArray<T> add(T... items);
  ProcessedArray<T> remove(T item);
  ProcessedArray<T> clean();

  @SafeVarargs
  static <T> ProcessedArray<T> of(ArraySupplier<T> initializer, T... items) {
    return new ProcessedArrayImpl<>(items, initializer);
  }
}
