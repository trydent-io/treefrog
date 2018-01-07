package io.treefrog.javafx.component;

import io.treefrog.javafx.JavaFXTest;
import javafx.scene.control.Button;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static io.treefrog.javafx.component.ParentComponent.parent;
import static io.treefrog.javafx.property.IdProperty.id;

class ParentComponentTest extends JavaFXTest {
  private static final String BUTTON = "button";

  @Test
  void shouldHaveId() {
    final ParentComponent button = parent(Button::new, id(BUTTON));

    assertThat(button.element().getId()).isEqualTo(BUTTON);
  }

  @Test
  void shouldBeNotEqual() {
    final ParentComponent parent = parent(Button::new, id(BUTTON));

    assertThat(parent.element()).isNotEqualTo(parent.get());
  }
}
