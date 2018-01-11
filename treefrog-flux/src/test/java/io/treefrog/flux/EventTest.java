package io.treefrog.flux;

import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
//@RunWith(JUnitPlatform.class)
class EventTest {
/*  public enum TestEvents { Pointless }

  @Test
  void shouldBeNotNull() {
    assertThat(event(Pointless, "v1")).isNotNull();
  }

  @Test
  void shouldBePointless() {
    assertThat(event(Pointless,  tuple("v1")).is(Pointless)).isTrue();
  }

  @Test
  void shouldBeUppercased() {
    final AtomicReference<String> ref = new AtomicReference<>();
    event(Pointless, "uppercase").<Tuple1<String>>take(it -> ref.set(it.yield(String::toUpperCase)));
    assertThat(ref.get()).isEqualTo("uppercase".toUpperCase());
  }*/
}
