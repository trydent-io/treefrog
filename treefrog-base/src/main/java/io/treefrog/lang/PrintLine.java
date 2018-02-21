package io.treefrog.lang;

import java.io.PrintStream;

import static java.lang.System.err;
import static java.lang.System.out;

public interface PrintLine {
  static <T> void println(T value) {
    out.println(value);
  }
  static PrintStream println(String template, Object... values) {
    return out.printf(template + "\n", values);
  }
  static PrintStream print(String template, Object... values) {
    return out.printf(template, values);
  }
  static <T> void errln(T value) {
    err.println(value);
  }
  static PrintStream errln(String template, Object... values) {
    return err.printf(template, values);
  }
}
