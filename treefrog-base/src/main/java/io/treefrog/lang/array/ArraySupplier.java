package io.treefrog.lang.array;

@FunctionalInterface
public interface ArraySupplier<T> {
  @SuppressWarnings("unchecked")
  T[] get(int length);

  @SuppressWarnings("unchecked")
  default T[] empty() {
    return get(0);
  }
}
