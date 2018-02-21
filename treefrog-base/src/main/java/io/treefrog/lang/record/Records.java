package io.treefrog.lang.record;

import io.treefrog.function.Consumer2;

import static io.treefrog.lang.PrintLine.println;
import static java.util.Objects.requireNonNull;

public interface Records<K, V> extends Iterable<Record<K, V>> {
  Iterable<K> keys();
  Iterable<V> values();

  Records<K, V> forEach(final Consumer2<K, V> consumer2);

  @SafeVarargs
  static <P, L> Records<P, L> of(final Record<P, L>... records) {
    return new RecordsImpl<>(records);
  }

  static void main(String[] args) {
    final Records<Integer, String> records = Records.of(
      Record.of(12, "12"),
      Record.of(13, "13")
    );

    records.forEach((key, value) -> println("Let's test it too: (%d, %s)", key, value));
  }
}
