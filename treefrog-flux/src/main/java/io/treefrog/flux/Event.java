package io.treefrog.flux;

public interface Event {


  <E extends Enum> boolean is(E type);
}
