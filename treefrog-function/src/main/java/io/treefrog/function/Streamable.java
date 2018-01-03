package io.treefrog.function;

import java.util.stream.Stream;

public interface Streamable<T> extends Iterable<T> {
  Stream<T> stream();
}
