package io.treefrog.hop;

import io.treefrog.lang.array.DefaultIndexedArray;
import io.treefrog.lang.array.IndexedArray;

import javax.servlet.http.HttpServletRequest;

interface PathLeaves extends IndexedArray<PathLeaf> {
  PathLeaves EMPTY = new PathLeavesImpl(new PathLeaf[0]);

  static PathLeaves of(final HttpServletRequest request) {
    return new RequestPathLeafs(request);
  }
  static PathLeaves of(final String path) {
    return new SplittedPathLeaves(path);
  }
  static PathLeaves pathLeaves(final PathLeaf... leaves) {
    return new PathLeavesImpl(leaves);
  }

  // default implementation
  final class PathLeavesImpl extends DefaultIndexedArray<PathLeaf> implements PathLeaves {
    private PathLeavesImpl(PathLeaf[] items) {
      super(items);
    }
  }
}
