package io.treefrog.javafx.component;

import io.treefrog.javafx.property.IdProperty;
import javafx.scene.Parent;

import java.util.function.Supplier;

public interface ParentComponent extends Source<Parent> {
  static <P extends Parent> ParentComponent parent(Supplier<P> p, IdProperty id) {
    return new ParentComponentImpl<>(p, id);
  }
}
