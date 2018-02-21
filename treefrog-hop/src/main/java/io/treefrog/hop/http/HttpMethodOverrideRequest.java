package io.treefrog.hop.http;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static io.treefrog.hop.http.HttpMethod.INVALID;

final class HttpMethodOverrideRequest implements HttpMethodOverride {
  private static final String METHOD_OVERRIDE = "X-HTTP-Method-Override";
  private final HttpServletRequest request;

  HttpMethodOverrideRequest(HttpServletRequest request) {
    this.request = request;
  }

  @Override
  public HttpMethod method() {
    return Optional.ofNullable(request)
      .map(it -> it.getHeader(METHOD_OVERRIDE))
      .map(String::toUpperCase)
      .map(HttpMethod::valueOf)
      .orElse(INVALID);
  }
}
