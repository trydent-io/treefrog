package io.treefrog.lang.array;

import java.util.Enumeration;
import java.util.Iterator;

final class EnumerationArray<S> implements Array<S> {
  private final Enumeration<S> enumeration;

  EnumerationArray(Enumeration<S> enumeration) {
    this.enumeration = enumeration;
  }

  @Override
  public int length() {
    if (!enumeration.hasMoreElements()) return 0;
    synchronized (this) {
      final Iterator<S> iterator = enumeration.asIterator();
      int length = 0;
      while (iterator.hasNext()) {
        length++;
        iterator.next();
      }
      return length;
    }
  }

  @Override
  public boolean isEmpty() {
    return !enumeration.hasMoreElements();
  }

  @Override
  public boolean isNotEmpty() {
    return enumeration.hasMoreElements();
  }

  @Override
  public S[] copy(S[] dest) {
    return dest;
  }

  @Override
  public Iterator<S> iterator() {
    return enumeration.asIterator();
  }
}
