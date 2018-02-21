package io.treefrog.hop;

import java.util.Formatter;
import java.util.Locale;

import static java.lang.Character.MIN_VALUE;
import static java.util.Optional.ofNullable;

public enum  Text {
  Template(new Formatter());

  private final Formatter formatter;

  Text(Formatter formatter) {
    this.formatter = formatter;
  }

  public String format(String pattern, Object... values) {
    return formatter.format(pattern, values).toString();
  }

  public String format(String pattern, Locale locale, Object... values) {
    return formatter.format(locale, pattern, values).toString();
  }

  public static char lastOf(final String value) {
    return ofNullable(value)
      .filter(it -> it.length() > 0)
      .map(it -> it.charAt(it.length() - 1))
      .orElse(MIN_VALUE);
  }
}
