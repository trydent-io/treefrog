package io.treefrog.flux;

import io.treefrog.function.Consumer1;
import io.treefrog.function.Function1;

public class Event1Impl<V1> implements Event1<V1> {
  @Override
  public <E extends Enum> boolean is(E type) {
    return false;
  }

  @Override
  public <R> R then(Function1<V1, Event1<V1>> v1Event1Function1) {
    return null;
  }

  @Override
  public void then(Consumer1<V1> v1Consumer1) {

  }
}
