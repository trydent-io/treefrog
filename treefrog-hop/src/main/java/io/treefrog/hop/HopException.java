package io.treefrog.hop;

public final class HopException extends RuntimeException {
  public HopException() {
    super();
  }

  public HopException(String message) {
    super(message);
  }

  public HopException(String message, Throwable cause) {
    super(message, cause);
  }

  public HopException(Throwable cause) {
    super(cause);
  }

  protected HopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
