package io.treefrog.lang.array;

import static java.lang.System.arraycopy;
import static java.util.Objects.isNull;

public abstract class DefaultProcessedArray<T> extends DefaultArray<T> implements ProcessedArray<T> {
  private final ArraySupplier<T> initializer;

  DefaultProcessedArray(T[] items, ArraySupplier<T> initializer) {
    super(items);
    this.initializer = initializer;
  }

  @Override
  @SafeVarargs
  public final ProcessedArray<T> add(T... items) {
    if (isNull(items)) return this;
    final T[] ts = initializer.get(this.items.length + items.length);
    arraycopy(this.items, 0, ts, 0, this.items.length);
    arraycopy(items, 0, ts, this.items.length, items.length);
    return new ProcessedArrayImpl<>(ts, initializer);
  }

  @Override
  public final ProcessedArray<T> remove(T item) {
    return new ProcessedArrayImpl<>(items, initializer);
  }

  @Override
  public final ProcessedArray<T> clean() {
    return new ProcessedArrayImpl<>(initializer.empty(), initializer);
  }
}
