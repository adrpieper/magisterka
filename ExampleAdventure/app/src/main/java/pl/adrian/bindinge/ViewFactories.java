package pl.adrian.bindinge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.Inflater;

public class ViewFactories {

    public static ViewFactory<TextView> textViewFactory(){
        return new ViewFactory<TextView>() {
            @Override
            public TextView createView(Context context) {
                return new TextView(context);
            }
        };
    }

    public static <ViewType extends View> ViewFactory<ViewType> createFor(Class<ViewType> viewClass){

        try {
            final Constructor<ViewType> constructor = viewClass.getConstructor(Context.class);

        return new ViewFactory<ViewType>() {
            @Override
            public ViewType createView(Context context) {
                try {
                    return constructor.newInstance(context);
                } catch (InstantiationException e) {
                    throw exception(e);
                } catch (IllegalAccessException e) {
                    throw exception(e);
                } catch (InvocationTargetException e) {
                    throw exception(e);
                }

            }
        };

        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Dla klasy " + viewClass.getName() + " nie istnieje odpowiedni konstructor", e);
        }
    }

    private static RuntimeException exception(Exception e){
        return new RuntimeException("Nie można utworzyć instancji.", e);
    }

    public static ViewFactory<View> createFor(final int layoutRes) {
        return new ViewFactory<View>() {
            @Override
            public View createView(Context context) {
                return LayoutInflater.from(context).inflate(layoutRes, null, false);
            }
        };
    }
}
