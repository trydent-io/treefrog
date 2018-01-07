package io.treefrog.flux;

import io.treefrog.function.tuple.Tuple1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static com.google.common.truth.Truth.assertThat;
import static io.treefrog.flux.Event.event;
import static io.treefrog.flux.EventTest.TestEvents.Pointless;
import static io.treefrog.function.tuple.Tuple.tuple;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@RunWith(JUnitPlatform.class)
class EventTest {
  public enum TestEvents { Pointless }

  @Test
  void shouldBeNotNull() {
    assertThat(event(Pointless, tuple("v1"))).isNotNull();
  }

  @Test
  void shouldBePointless() {
    assertThat(event(Pointless,  tuple("v1")).is(Pointless)).isTrue();
  }

  @Test
  void shouldBeUppercased() {
    abstract class MyTuple implements Tuple1<String> {}
    event(Pointless, tuple("uppercase"))
      .<MyTuple>apply(it -> it.then(t -> t.toUpperCase()));
    assertThat())
  }
}
