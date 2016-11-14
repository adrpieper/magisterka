package pl.edu.ug.inf.am.common;

import pl.edu.ug.inf.am.app.dagger.PerApp;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@PerApp
public class ComponentsManager {
    private final Map<Class,Object> components = new HashMap<>();

    @Inject
    public ComponentsManager() {}

    public <T> void add(Class<T> componentInterface, T component) {
        components.put(componentInterface, component);
    }

    public <T> T get(Class<T> componentInterface) {
        return (T) components.get(componentInterface);
    }

    public void remove(Class componentInterface) {
        components.remove(componentInterface);
    }
}
