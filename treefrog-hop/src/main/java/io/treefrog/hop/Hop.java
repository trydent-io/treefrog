package io.treefrog.hop;

import io.treefrog.hop.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static io.treefrog.hop.MatchedHop.hasAll;
import static io.treefrog.hop.MatchedHop.hasSame;
import static io.treefrog.hop.MatchedHop.hasSameSlash;
import static io.treefrog.hop.MatchedHop.needsTrailingSpaces;
import static java.util.stream.StreamSupport.stream;

interface Jump extends Consumer<HttpServletRequest> {
}

final class Hop {
  private final HttpMethod method;
  private final String path;
  private final Jump jump;

  private Hop(HttpMethod method, String path, Jump jump) {
    this.method = method;
    this.path = path;
    this.jump = jump;
  }

  public static Hop hop(HttpMethod method, String path, Jump jump) {
    return new Hop(method, path, jump);
  }

  public HttpMethod method() {
    return method;
  }

  public String path() {
    return path;
  }

  public Jump jump() {
    return jump;
  }
}

interface MatchedHop extends Predicate<Hop> {
  static MatchedHop hasSame(final HttpMethod method) {
    return it -> it.method().equals(method);
  }
  static MatchedHop hasSame(final String path) {
    return it -> it.path().equals(path);
  }
  static MatchedHop hasAll() {
    return it -> it.path().equals("*");
  }
  static MatchedHop needsTrailingSpaces() {
    return it -> true;
  }
  static MatchedHop hasSameSlash(final String path) {
    return it -> !((it.path().endsWith("/") || path.endsWith("/")) && (Text.lastOf(it.path()) != Text.lastOf(path)));
  }
  static MatchedHop isIndexed(final String path) {
    return it -> {
      final boolean hasSameLength = PathLeaves.of(it.path()).length() == PathLeaves.of(path).length();
      return false;
    };
  }
}

final class MatchedHops implements Iterable<Hop> {

  private final Iterable<Hop> hops;
  private final HttpMethod method;
  private final String path;

  private MatchedHops(Iterable<Hop> hops, HttpMethod method, String path) {
    this.hops = hops;
    this.method = method;
    this.path = path;
  }

  @Override
  public Iterator<Hop> iterator() {
    return stream(hops.spliterator(), false)
      .filter(hasSame(method)
        .or(hasAll())
        .or(hasSame(path))
        .or(needsTrailingSpaces().or(hasSameSlash(path)))
      )
      .iterator();
  }
}

