package io.treefrog.hop;

import java.util.Iterator;
import java.util.stream.Stream;

final class SplittedPathLeaves implements PathLeaves {
  private final String path;

  SplittedPathLeaves(String path) {
    this.path = path;
  }

  @Override
  public Iterator<PathLeaf> iterator() {
    return Stream.of(path.split("/"))
      .map(PathLeaf::pathLeaf)
      .iterator();
  }
}
