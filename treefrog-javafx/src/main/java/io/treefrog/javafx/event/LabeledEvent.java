package io.treefrog.javafx.event;

import io.treefrog.function.Consumer2;
import io.treefrog.function.Function1;
import io.treefrog.javafx.property.LabeledProperty;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;

@FunctionalInterface
public interface LabeledEvent {
  static LabeledEvent mouseClicked(Function1<MouseEvent, LabeledProperty> callback) {
    return it -> it.setOnMouseClicked(e -> callback.apply(e).onLabeled(it));
  }
  static LabeledEvent mouseClicked(Consumer2<MouseEvent, Labeled> callback) {
    return it -> it.setOnMouseClicked(e -> callback.accept(e, it));
  }

  void onLabeled(Labeled labeled);
}
