package io.treefrog.javafx;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@RunWith(JUnitPlatform.class)
@SuppressWarnings("JUnit5Platform")
public abstract class JavaFXTest {
  private final JFXPanel panel = new JFXPanel();
}


