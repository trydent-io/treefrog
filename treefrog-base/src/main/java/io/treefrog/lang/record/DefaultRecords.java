package io.treefrog.lang.record;

import io.treefrog.function.Consumer2;
import io.treefrog.lang.array.RawCursor;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public abstract class DefaultRecords<K, V> implements Records<K, V> {
  private final Record<K, V>[] records;

  protected DefaultRecords(Record<K, V>[] records) {
    this.records = records;
  }

  @Override
  public final Iterable<K> keys() {
    return () -> Stream.of(records).map(Record::key).iterator();
  }

  @Override
  public final Iterable<V> values() {
    return () -> Stream.of(records).map(Record::value).iterator();
  }

  @Override
  public final Iterator<Record<K, V>> iterator() {
    return new RawCursor<>(records);
  }

  @Override
  public void forEach(Consumer<? super Record<K, V>> action) {
    requireNonNull(action, "Must be not null");
    for (Record<K, V> record : records) action.accept(record);
  }

  @Override
  public Records<K, V> forEach(Consumer2<K, V> action) {
    requireNonNull(action, "Must be not null");
    for (Record<K, V> record : records) action.accept(record.key(), record.value());
    return this;
  }

}
