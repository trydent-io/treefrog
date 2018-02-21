package io.treefrog.hop.http;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public enum HttpMethod {
  GET, POST, PUT, PATCH, DELETE, HEAD, TRACE, CONNECT, OPTIONS, BEFORE, AFTER, INVALID
}
