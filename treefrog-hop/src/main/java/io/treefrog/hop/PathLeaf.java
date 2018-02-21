package io.treefrog.hop;

import java.util.Optional;

final class PathLeaf {
  private final String value;

  private PathLeaf(String value) {
    this.value = value;
  }

  public String value() { return value; }

  public static Optional<PathLeaf> of(final String path) {
    return Optional.ofNullable(path)
      .filter(it -> !it.isEmpty())
      .map(PathLeaf::new);
  }
  public static PathLeaf pathLeaf(final String path) {
    return of(path).orElseThrow(HopException::new);
  }
}
