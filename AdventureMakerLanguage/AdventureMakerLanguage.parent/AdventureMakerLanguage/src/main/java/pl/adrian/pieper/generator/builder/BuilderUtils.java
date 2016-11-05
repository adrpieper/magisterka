package pl.adrian.pieper.generator.builder;

/**
 * Created by Adi on 2016-11-04.
 */
public class BuilderUtils {

    public static Parameter aParam(String type, String name) {
        return new Parameter(type, name);
    }

    public static Parameter aParam(Class type, String name) {
        return new Parameter(type.getName(), name);
    }
}
