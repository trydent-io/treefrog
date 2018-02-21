package io.treefrog.hop;

import java.util.Optional;

public final class SlashedUri {
  private static final String SLASH = "/";
  private final String uri;

  private SlashedUri(String uri) {
    this.uri = uri;
  }

  public String value() { return uri; }
  public String[] branches() { return uri.split("/"); }

  public static Optional<SlashedUri> of(final String uri) {
    return Optional.ofNullable(uri)
      .filter(it -> it.contains(SLASH))
      .map(SlashedUri::new);
  }
}
