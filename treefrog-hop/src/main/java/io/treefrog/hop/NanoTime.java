package io.treefrog.hop;

public final class NanoTime {
  private NanoTime() {}

  public static NanoTime ofSystem() {
    return new NanoTime();
  }

  public long value() {
    return System.nanoTime();
  }

  public String asString() {
    return Long.toString(value());
  }

  @Override
  public String toString() {
    return asString();
  }
}
