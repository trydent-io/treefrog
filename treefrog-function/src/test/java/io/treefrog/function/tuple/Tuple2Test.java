package io.treefrog.function.tuple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.truth.Truth.assertThat;
import static io.treefrog.function.tuple.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@RunWith(JUnitPlatform.class)
class Tuple2Test {
  @Test
  void shouldMap() {
    final Tuple2<String, String> tuple = tuple("string1", "string2");

    assertThat(tuple.map((v1, v2) -> v1 + v2)).isNotNull();
  }

  @Test
  void shouldTrueCondition() {
    final Tuple2<String, String> tuple = tuple("A", "B");

    assertThat(tuple.matches((v1, v2) -> v1.equals("A"))).isTrue();
  }

  @Test
  void shouldFlatMap() {
    final Tuple2<String, String> tuple = tuple("A", "B");

    assertThat(tuple.<Tuple2<String, String>>flatMap((v1, v2) -> tuple("B", "A"))).isNotNull();
  }

  @Test
  void shouldPeekWithResult() {
    final Tuple2<Integer, Integer> tuple = tuple(1, 2);

    final AtomicInteger result = new AtomicInteger(0);
    tuple.peek((v1, v2) -> result.set(v1 + v2));
    assertThat(result.get()).isEqualTo(3);
  }

  @Test
  void shouldReturnsAB() {
    final Tuple2<String, String> tuple = tuple("A", "B");

    assertThat(tuple.<String>then((v1, v2) -> v1 + v2)).isEqualTo("AB");
  }

  @Test
  void shouldThrowException() {
    final Tuple2<String, String> tuple = tuple("v1", "v2");

    assertThrows(RuntimeException.class, () -> tuple.then(null));
  }
}
