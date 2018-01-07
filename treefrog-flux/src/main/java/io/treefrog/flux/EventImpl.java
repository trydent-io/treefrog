package io.treefrog.flux;

import io.treefrog.function.Function1;
import io.treefrog.function.tuple.Tuple;

import java.util.Objects;

public class EventImpl<Y extends Enum, R extends Tuple> implements Event {
  private final Y type;
  private final R tuple;

  EventImpl(Y type, R tuple) {
    this.type = type;
    this.tuple = tuple;
  }

  @Override
  public <E extends Enum> boolean is(E type) {
    return Objects.equals(this.type, type);
  }

  @Override
  public <T extends Tuple> boolean apply(Function1<T, Boolean> applying) {
    return false;
  }
}
