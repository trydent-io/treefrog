package io.treefrog.flux;

import io.treefrog.function.map.FlatMapping2;
import io.treefrog.function.map.Mapping2;

import java.time.LocalDateTime;
import java.util.Random;

import static io.treefrog.flux.Event1.event1;
import static io.treefrog.flux.Event2.EventiOrdinativo.*;
import static io.treefrog.flux.Event2.EventiOrdinativo.MandatoInviato;

public interface Event2<V1, V2> extends Event, Mapping2<V1, V2>, FlatMapping2<V1, V2> {
  static <N extends Enum, T1, T2> Event2<T1, T2> event2(N type, T1 v1, T2 v2) {
    return new Event2Impl<>(type, v1, v2);
  }

  enum EventiOrdinativo {
    MandatoCreato,
    MandatoInviato,
    MandatoScartato
  }

  static void main(String[] args) {
    event2(MandatoInviato, LocalDateTime.now(), "OPI")
      .flatMap((when, opi) -> event1(MandatoScartato, opi + when.toString()))
      .map(it -> new Random().nextInt())
      .map(it -> Character.getName(it));
  }
}
