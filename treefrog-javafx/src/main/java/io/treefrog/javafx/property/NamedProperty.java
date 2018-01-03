package io.treefrog.javafx.property;

import io.treefrog.function.Consumer1;
import javafx.scene.control.ToggleGroup;

public interface NamedProperty extends Consumer1<ToggleGroup> {
  static NamedProperty named(String name) {
    return t -> t.setUserData(name);
  }
}
