package io.treefrog.lang.array;

import java.util.Optional;

import static java.util.Objects.nonNull;

public abstract class DefaultIndexedArray<T> extends DefaultArray<T> implements IndexedArray<T> {
  public DefaultIndexedArray(T[] items) {
    super(items);
  }

  @Override
  public final int indexOf(T t) {
    boolean notNull = nonNull(this.items);
    int i = 0;
    while (notNull && i < items.length && !items[i].equals(t)) i++;
    return i;
  }

  @Override
  public final Optional<T> at(int index) {
    return Optional.of(index)
      .filter(it -> it >= 0 && it < items.length)
      .map(it -> items[it]);
  }
}
