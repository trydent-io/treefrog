package io.treefrog.javafx;

import javafx.scene.Parent;

public interface Base<P extends Parent> {
  P origin();
}
