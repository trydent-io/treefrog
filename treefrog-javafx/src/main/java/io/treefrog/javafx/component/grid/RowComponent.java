package io.treefrog.javafx.component.grid;

import io.treefrog.function.Consumer2;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static javafx.scene.layout.ConstraintsBase.CONSTRAIN_TO_PREF;

public interface RowComponent extends Consumer2<GridPane, Integer> {
  static RowComponent row(RowProperty... properties) {
    return new RowComponentImpl(new RowConstraints(CONSTRAIN_TO_PREF, CONSTRAIN_TO_PREF, CONSTRAIN_TO_PREF), properties);
  }

  static RowComponent autoRow(RowProperty... properties) {
    return new RowComponentImpl(new RowConstraints(), properties);
  }

  RowComponent with(ColumnComponent... components);
}
