package io.treefrog.hop.http;

import io.treefrog.function.Consumer2;
import io.treefrog.lang.array.Array;
import io.treefrog.lang.record.Record;
import io.treefrog.lang.record.Records;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Optional;

public interface HttpHeaders extends Records<String, String> {
  Optional<String> header(final String header);

  static HttpHeaders of(HttpServletRequest request) {
    return new HttpRequestHeaders(request);
  }

  final class HttpRequestHeaders implements HttpHeaders {
    private final HttpServletRequest request;

    HttpRequestHeaders(HttpServletRequest request) {
      this.request = request;
    }

    @Override
    public Optional<String> header(String name) {
      return Optional.ofNullable(request.getHeader(name));
    }

    @Override
    public Iterable<String> keys() {
      return Array.of(request.getHeaderNames());
    }

    @Override
    public Iterable<String> values() {
      for (String key : keys()) {

      }
      return Array.of(request.getHe);
    }

    @Override
    public Records<String, String> forEach(Consumer2<String, String> consumer2) {
      return null;
    }

    @Override
    public Iterator<Record<String, String>> iterator() {
      return null;
    }
  }
}
