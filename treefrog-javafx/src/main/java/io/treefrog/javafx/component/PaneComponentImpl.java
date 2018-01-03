package io.treefrog.javafx.component;

import io.treefrog.javafx.property.IdProperty;
import io.treefrog.javafx.property.ParentProperty;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

final class PaneComponentImpl implements PaneComponent {
  private final IdProperty id;
  private final Pane pane;
  private final ParentProperty[] properties;
  private final Component[] components;

  PaneComponentImpl(Pane pane, IdProperty id, ParentProperty[] properties) {
    this(pane, id, properties, new Component[]{});
  }

  private PaneComponentImpl(Pane pane, IdProperty id, ParentProperty[] properties, Component[] components) {
    this.pane = pane;
    this.id = id;
    this.properties = properties;
    this.components = components;
  }

  @Override
  public PaneComponent with(Component... components) {
    return new PaneComponentImpl(pane, id, properties, components);
  }

  @Override
  public Parent get() {
    id.onParent(pane);
    for (ParentProperty property : properties) property.onParent(pane);
    for (Component component : components) pane.getChildren().addAll(component.get());
    return pane;
  }
}
