package io.treefrog.hop;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static java.util.Objects.requireNonNullElse;

final class RequestPathLeafs implements PathLeaves {
  private final HttpServletRequest request;

  RequestPathLeafs(HttpServletRequest request) {
    this.request = request;
  }

  @Override
  public Iterator<PathLeaf> iterator() {
    final HttpServletRequest req = requireNonNull(request, "Require can not be null");
    return new SplittedPathLeaves(requireNonNullElse(req.getRequestURI(), ""))
      .iterator();
  }

  @Override
  public int length() {
    return 0;
  }

  @Override
  public PathLeaf[] copy(PathLeaf[] dest) {
    return new PathLeaf[0];
  }

  @Override
  public int indexOf(PathLeaf pathLeaf) {
    return 0;
  }

  @Override
  public Optional<PathLeaf> at(int index) {
    return Optional.empty();
  }
}
