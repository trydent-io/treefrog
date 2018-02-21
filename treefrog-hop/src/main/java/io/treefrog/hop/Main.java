package io.treefrog.hop;

import io.undertow.Undertow;

import static io.undertow.Handlers.path;
import static io.undertow.Handlers.redirect;

public interface Main {
  static void main(String[] args) {
    Undertow.builder()
      .addHttpListener(8080, "localhost")
      .setHandler(path(redirect("/hop"))
        .addPrefixPath("/hop", Deploy.of(HopServlet.class).start()))
      .build()
      .start();
  }
}
