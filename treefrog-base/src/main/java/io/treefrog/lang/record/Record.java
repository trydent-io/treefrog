package io.treefrog.lang.record;

public final class Record<K, V> {
  private final K key;
  private final V value;

  private Record(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public final K key() { return this.key; }
  public final V value() { return this.value; }

  public static <P, L> Record<P, L> of(final P key, final L value) {
    return new Record<>(key, value);
  }
}
