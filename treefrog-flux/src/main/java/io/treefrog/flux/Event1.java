package io.treefrog.flux;

import io.treefrog.function.struct.Mapping1;

import static io.treefrog.flux.Event2.event2;

public interface Event1<V1> extends Event, Mapping1<V1> {
  static <N extends Enum, T> Event1<T> event(N type, T value) {
    return new Event1Impl<>(type, value);
  }

  enum Type {Greeting}
  enum Kind {Rude}

  class D {
    {
      Event e = event(Type.Greeting, "Hi").map(it -> event2(Kind.Rude, it, "mother fucker")).;
    }
  }
}
