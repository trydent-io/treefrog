package io.treefrog.lang.array;

import io.treefrog.lang.PrintLine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.google.common.truth.Truth.assertThat;
import static io.treefrog.lang.PrintLine.*;

class ProcessedArrayTest {
  @Test
  void shouldBeNotEmpty() {
    final ProcessedArray<Integer> array = ProcessedArray.of(Integer[]::new, 12, 13, 14);

    assertThat(array).isNotEmpty();
  }

  @Test
  void shouldBeWithOneMoreItem() {
    final ProcessedArray<Integer> array = ProcessedArray.of(Integer[]::new, 12, 13, 14).add(15);

    assertThat(array.length()).isEqualTo(4);
  }

  @Test
  void benchmarkTest() {
    for (int count = 0; count < 10; count++) {
      final ProcessedArray<Integer> boxed = ProcessedArray.of(Integer[]::new);
      final List<Integer> listed = new ArrayList<>();

      long current = System.currentTimeMillis();
      IntStream.range(0, 100_000_000)
        .parallel()
        .forEach(listed::add);
      //for (int i = 0; i < 100_000_000; i++) listed.add(i);
      println("Total time for List: %d millisecs.", (System.currentTimeMillis() - current));

      current = System.currentTimeMillis();
      final long counted = IntStream.range(0, 100_000_000)
        .parallel()
        .mapToObj(listed::add)
        .count();
      //for (int i = 0; i < 100_000_000; i++) boxed.add(i);
      println("Total time for Boxed: %d millisecs.", (System.currentTimeMillis() - current));
    }
  }
}
