package io.treefrog.amphitrite;

import io.treefrog.javafx.component.Component;
import io.treefrog.javafx.property.IdProperty;
import io.treefrog.javafx.property.ParentProperty;
import javafx.scene.Parent;

import java.util.UUID;

import static io.treefrog.javafx.component.LabeledComponent.label;
import static io.treefrog.javafx.component.PaneComponent.flow;
import static io.treefrog.javafx.property.LabeledProperty.text;

public final class Alert implements Component {
  private final IdProperty id;
  private final String text;
  private final ParentProperty[] properties;

  public Alert(IdProperty id, String text, ParentProperty... properties) {
    this.id = id;
    this.text = text;
    this.properties = properties;
  }

  @Override
  public Parent get() {
    return flow(id, properties).with(
      label(it -> it.setId(UUID.randomUUID().toString()), text(this.text))
    ).get();
  }
}
