package io.treefrog.lang.array;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RawArrayCursorTest {
  @Test
  void shouldHasNext() {
    final Integer[] ts = {1, 2, 3};
    final RawCursor<Integer> cursor = new RawCursor<>(ts);

    assertThat(cursor.hasNext()).isTrue();
  }

  @Test
  void shouldNotHasNext() {
    final Integer[] ts = {};
    final RawCursor<Integer> cursor = new RawCursor<>(ts);

    assertThat(cursor.hasNext()).isFalse();
  }

  @Test
  void shouldRetrieveFirstThenSecondThenThird() {
    final Integer[] ts = {1, 2, 3};
    final RawCursor<Integer> cursor = new RawCursor<>(ts);

    assertThat(cursor.next()).isEqualTo(1);
    assertThat(cursor.next()).isEqualTo(2);
    assertThat(cursor.next()).isEqualTo(3);
  }

  @Test
  void shouldBreaks() {
    final Integer[] ts = {};
    final RawCursor<Integer> cursor = new RawCursor<>(ts);

    assertThrows(IndexOutOfBoundsException.class, cursor::next);
  }
}
