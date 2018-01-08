package io.treefrog.function.struct;

import io.treefrog.function.Functional;

public interface Chaining<F extends Functional.Fun, C extends Functional.Con> {
  <R> R then(F<R> f);
  void then(C c);
}
