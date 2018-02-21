package io.treefrog.hop;

import io.treefrog.hop.http.HttpMethod;
import io.treefrog.hop.http.HttpMethodOverride;
import org.slf4j.Logger;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

public final class HopServlet extends HttpServlet implements Servlet {
  private static final Logger log = getLogger(HopServlet.class);

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
    log.info("Someone wants to ping");

    final HttpMethod overrided = HttpMethodOverride.from(req).method();
    final Optional<SlashedUri> slashed = SlashedUri.of(req.getRequestURI());
    slashed.ifPresent();

    res.getWriter().format("Hi there %s", "Luca");
    res.addHeader("Http-Server", "Treefrog");
    res.addHeader("Http-Server-Start-Time", NanoTime.ofSystem().asString());
  }
}
