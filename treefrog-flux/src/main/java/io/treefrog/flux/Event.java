package io.treefrog.flux;

import java.time.LocalDateTime;

import static io.treefrog.flux.Event.States.*;
import static io.treefrog.flux.Event.States.Modified;
import static io.treefrog.function.tuple.Tuple.tuple;
import static java.time.LocalDateTime.*;

public interface Event {
  static <E extends Enum, T> Event1<E, T> event(E type, T value) {
    return new Event1<>(type, tuple(value));
  }

  static <E extends Enum, T1, T2> Event2<E, T1, T2> event(E type, T1 t1, T2 t2) {
    return new Event2<>(type, tuple(t1, t2));
  }

  static <E extends Enum, T1, T2, T3> Event3<E, T1, T2, T3> event(E type, T1 t1, T2 t2, T3 t3) {
    return new Event3<>(type, tuple(t1, t2, t3));
  }

  <E extends Enum> boolean is(E type);

  enum States { Created, Modified, Removed }

  static void main(String[] args) {
    event(Created, "Luke")
      .change(it -> it + " Skywalker")
      .trigger(it -> event(Modified, it, now()))
      .eventually((name, date) -> System.out.println("Let's see " + name + " " + date.toString()));
  }
}
