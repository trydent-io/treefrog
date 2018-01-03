package io.treefrog.function;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public abstract class RawStreamable<T> implements Streamable<T> {
  protected final T[] ts;

  protected RawStreamable(T[] ts) {
    this.ts = ts;
  }

  @Override
  public Stream<T> stream() {
    return StreamSupport.stream(this.spliterator(), false);
  }

  @Override
  public Iterator<T> iterator() {
    return List.of(ts).iterator();
  }

  @Override
  public void forEach(Consumer<? super T> action) {
    for (T t : ts) action.accept(t);
  }

  @Override
  public Spliterator<T> spliterator() {
    return List.of(ts).spliterator();
  }
}
