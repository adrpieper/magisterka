package pl.adrian.pieper.generator.builder

import org.eclipse.xtend.lib.annotations.Accessors

public class Parameter {

    @Accessors
    private final String type;
    @Accessors
    private final String name;

    new(String type, String name) {
        this.type = type;
        this.name = name;
    }
}