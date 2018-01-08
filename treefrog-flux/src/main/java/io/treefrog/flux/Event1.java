package io.treefrog.flux;

import io.treefrog.function.Consumer1;
import io.treefrog.function.Function1;
import io.treefrog.function.struct.Chaining;

public interface Event1<V1> extends Event, Chaining<Function1<V1, Event1<V1>>, Consumer1<V1>> {
}
