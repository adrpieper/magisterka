package pl.adrian.bindinge;

import android.content.Context;
import android.view.View;

import java.util.List;

public class AdapterBuilder<ViewType extends View, ModelType> {
    private final Class<ViewType> viewClass;
    private ModelBinder<ViewType, ModelType> binder;
    private ViewFactory<ViewType> viewFactory;
    private final Context context;
    private final List<ModelType> objects;

    public AdapterBuilder(Context context, Class<ViewType> viewClass, List<ModelType> objects) {
        this.viewClass = viewClass;
        this.context = context;
        this.objects = objects;
    }

    public AdapterBuilder<ViewType,ModelType> withBinder(ModelBinder<ViewType, ModelType> binder) {
        this.binder = binder;
        return this;
    }

    public AdapterBuilder<ViewType,ModelType> withViewFactory(ViewFactory<ViewType> viewFactory) {
        this.viewFactory = viewFactory;
        return this;
    }

    public ListAdapter bind() {
        return new ListAdapter(viewClass, binder, viewFactory, context, objects);
    }
}