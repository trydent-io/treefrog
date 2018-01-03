package io.treefrog.javafx.property;

import io.treefrog.javafx.component.Component;
import javafx.scene.layout.BorderPane;

public interface BorderPosition {
  static BorderPosition top(Component component) {
    return it -> it.setTop(component.get());
  }

  static BorderPosition right(Component component) {
    return it -> it.setRight(component.get());
  }

  static BorderPosition center(Component component) {
    return it -> it.setCenter(component.get());
  }

  static BorderPosition bottom(Component component) {
    return it -> it.setBottom(component.get());
  }

  static BorderPosition left(Component component) {
    return  it -> it.setLeft(component.get());
  }

  void onBorder(BorderPane border);
}
