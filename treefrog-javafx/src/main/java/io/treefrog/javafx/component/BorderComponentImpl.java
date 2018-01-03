package io.treefrog.javafx.component;

import io.treefrog.javafx.property.BorderPosition;
import io.treefrog.javafx.property.ParentProperty;
import javafx.scene.layout.BorderPane;

final class BorderComponentImpl<B extends BorderPane> implements BorderComponent, Base<B> {
  private final Base<B> border;
  private final ParentProperty[] properties;
  private final BorderPosition[] positions;

  BorderComponentImpl(Base<B> border, ParentProperty[] properties) {
    this(border, properties, new BorderPosition[]{});
  }

  private BorderComponentImpl(Base<B> border, ParentProperty[] properties, BorderPosition[] positions) {
    this.border = border;
    this.properties = properties;
    this.positions = positions;
  }

  @Override
  public BorderComponent with(BorderPosition... positions) {
    return new BorderComponentImpl<>(border, properties, positions);
  }

  @Override
  public B origin() {
    final B origin = border.origin();
    for (ParentProperty property : properties) property.onParent(origin);
    for (BorderPosition position : positions) position.onBorder(origin);
    return origin;
  }

  @Override
  public BorderPane element() {
    return origin();
  }
}
