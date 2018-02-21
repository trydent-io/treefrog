package io.treefrog.hop;

import io.treefrog.lang.array.DefaultIndexedArray;
import io.treefrog.lang.array.IndexedArray;

public interface Hops extends IndexedArray<Hop> {
  static Hops of(Hop... hops) {
    return new HopsImpl(hops);
  }

  class HopsImpl extends DefaultIndexedArray<Hop> implements Hops {
    HopsImpl(Hop[] items) {
      super(items);
    }
  }
}
