package io.treefrog.javafx.component.grid;

import io.treefrog.javafx.component.Component;
import io.treefrog.javafx.property.IdProperty;
import io.treefrog.javafx.property.ParentProperty;
import javafx.scene.layout.GridPane;

public interface GridComponent extends Component {
  static GridComponent grid(IdProperty id, ParentProperty... properties) {
    return new GridComponentImpl(new GridPane(), id, properties);
  }

  GridComponent with(RowComponent... components);
}
