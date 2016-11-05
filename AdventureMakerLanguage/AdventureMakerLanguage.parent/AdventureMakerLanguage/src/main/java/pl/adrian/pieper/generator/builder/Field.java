package pl.adrian.pieper.generator.builder;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Adi on 2016-11-04.
 */
public class Field extends Parameter {
    private final Set<Accessor> accessors;

    public Field(String type, String name, Accessor... accessors) {
        super(type, name);
        this.accessors = EnumSet.copyOf(Arrays.asList(accessors));
    }

    public Set<Accessor> getAccessors() {
        return accessors;
    }
}
