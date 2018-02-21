package io.treefrog.lang.record;

final class RecordsImpl<K, V> extends DefaultRecords<K, V> implements Records<K, V> {
  RecordsImpl(Record<K, V>[] records) {
    super(records);
  }
}
