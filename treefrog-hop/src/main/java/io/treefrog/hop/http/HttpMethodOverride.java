package io.treefrog.hop.http;

import javax.servlet.http.HttpServletRequest;

public interface HttpMethodOverride {
  static HttpMethodOverride from(HttpServletRequest request) {
    return new HttpMethodOverrideRequest(request);
  }

  HttpMethod method();
}
