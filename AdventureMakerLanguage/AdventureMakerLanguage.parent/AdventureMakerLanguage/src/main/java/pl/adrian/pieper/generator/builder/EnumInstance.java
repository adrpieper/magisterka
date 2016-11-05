package pl.adrian.pieper.generator.builder;

import java.util.List;

/**
 * Created by Adi on 2016-11-04.
 */
public class EnumInstance {
    private final String name;
    private final List<String> params;

    public EnumInstance(String name, List<String> params) {
        this.name = name;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public List<String> getParams() {
        return params;
    }
}
