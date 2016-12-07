package pl.adrian.util;

public class Reflection {

    public static <T> T newInstance(Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Can't create default instance");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Can't create default instance");
        }
    }
}
