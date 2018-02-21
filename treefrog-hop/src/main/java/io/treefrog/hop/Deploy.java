package io.treefrog.hop;

import io.undertow.server.HttpHandler;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import static io.treefrog.hop.Text.Template;
import static io.undertow.servlet.Servlets.defaultContainer;
import static io.undertow.servlet.Servlets.deployment;
import static io.undertow.servlet.Servlets.servlet;

public interface Deploy {
  static <S extends Servlet> Deploy of(final Class<S> servlet) {
    return of(servlet, servlet.getSimpleName().toLowerCase().replaceAll("servlet", ""));
  }
  static <S extends Servlet> Deploy of(final Class<S> servlet, final String name) {
    return new Default<>(servlet, name);
  }

  HttpHandler start();

  final class Default<S extends Servlet> implements Deploy {
    private static final String CONTEXT_PATH = "/%s";
    private static final String WAR_EXT = "%s.war";
    private static final String ALL = "/*";

    private final Class<S> servlet;
    private final String name;

    Default(Class<S> servlet, String name) {
      this.servlet = servlet;
      this.name = name;
    }

    @Override
    public HttpHandler start() {
      try {

        final DeploymentManager container = defaultContainer()
          .addDeployment(deployment()
          .setClassLoader(Main.class.getClassLoader())
          .setContextPath(Template.format(CONTEXT_PATH, name))
          .setDeploymentName(Template.format(WAR_EXT, name))
          .addServlets(servlet(servlet.getSimpleName(), servlet).addMapping(ALL)));
        container.deploy();

        return container.start();
      } catch (ServletException e) {
        throw new HopException(e.getMessage());
      }
    }
  }
}
