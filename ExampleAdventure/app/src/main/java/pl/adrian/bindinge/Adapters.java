package pl.adrian.bindinge;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;

import java.util.Arrays;
import java.util.List;

public class Adapters {

    public static <ViewType extends View, ModelType> AdapterBuilder<ViewType,ModelType>
    createFor(Context context, Class<ViewType> viewClass, List<ModelType> objects){
        return new AdapterBuilder<>(context, viewClass, objects);
    }

    public static <ViewType extends View, ModelType> AdapterBuilder<ViewType,ModelType>
    createFor(Context context, Class<ViewType> viewClass, ModelType[] objects){
        return createFor(context, viewClass, Arrays.asList(objects));
    }

}
