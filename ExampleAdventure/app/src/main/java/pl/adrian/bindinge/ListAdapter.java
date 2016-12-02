package pl.adrian.bindinge;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class ListAdapter<ViewType extends View, ModelType> extends BaseAdapter {
    private final ModelBinder<ViewType, ModelType> binder;
    private final ViewFactory<ViewType> viewFactory;
    private final Context context;
    private final List<ModelType> objects;

    public ListAdapter(ModelBinder<ViewType, ModelType> binder, ViewFactory<ViewType> viewFactory, Context context, List<ModelType> objects) {
        this.binder = binder;
        this.viewFactory = viewFactory;
        this.context = context;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public ModelType getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View oldView, ViewGroup viewGroup) {

        ViewType view;
        if (oldView != null) {
            view = (ViewType) oldView;
        }else {
            view = viewFactory.createView(context);
        }

        binder.bind(view, objects.get(i));
        return view;
    }

}
