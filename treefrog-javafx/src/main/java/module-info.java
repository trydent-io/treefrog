module treefrog.javafx {
  requires treefrog.base;

  requires javafx.controls;
  requires javafx.swing;

  exports io.treefrog.javafx.component;
  exports io.treefrog.javafx.component.grid;
  exports io.treefrog.javafx.property;
  exports io.treefrog.javafx.event;
}
