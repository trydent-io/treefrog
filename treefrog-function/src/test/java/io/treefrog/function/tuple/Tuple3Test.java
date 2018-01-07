package io.treefrog.function.tuple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.concurrent.atomic.AtomicReference;

import static com.google.common.truth.Truth.assertThat;
import static io.treefrog.function.tuple.Tuple.tuple;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@RunWith(JUnitPlatform.class)
class Tuple3Test {
  private static final Tuple3<String, String, String> TUPLE = tuple("v1", "v2", "v3");

  @Test
  void shouldBeNotNull() {
    assertThat(TUPLE).isNotNull();
  }

  @Test
  void shouldMap() {
    assertThat(TUPLE.map((v1, v2, v3) -> v1)).isNotNull();
  }

  @Test
  void shouldFlatMap() {
    assertThat(TUPLE.<Tuple1<String>>flatMap((v1, v2, v3) -> tuple(v1))).isNotNull();
  }

  @Test
  void shouldMatches() {
    assertThat(TUPLE.matches((v1, v2, v3) -> v1.equals("v1"))).isTrue();
  }

  @Test
  void shouldPeekResult() {
    final AtomicReference<Object> result = new AtomicReference<>();
    TUPLE.peek((v1, v2, v3) -> result.set(v1 + v2));
    assertThat(result.get()).isEqualTo("v1v2");
  }
}
