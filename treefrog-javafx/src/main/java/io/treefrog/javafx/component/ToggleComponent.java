package io.treefrog.javafx.component;

import io.treefrog.javafx.property.IdProperty;
import io.treefrog.javafx.property.ToggleProperty;
import javafx.scene.control.ToggleButton;

public interface ToggleComponent extends Source<ToggleButton> {
  static ToggleComponent toggle(IdProperty id, ToggleProperty... properties) {
    return new ToggleComponentImpl<>(new ParentComponentImpl<>(ToggleButton::new, id), properties);
  }
}
