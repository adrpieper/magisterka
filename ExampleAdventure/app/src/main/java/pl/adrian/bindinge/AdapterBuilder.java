package pl.adrian.bindinge;

import android.content.Context;
import android.databinding.ObservableList;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

import java.util.List;

public class AdapterBuilder<ModelType> {
    private final Context context;
    private final AbsListView absListView;
    private final List<ModelType> objects;

    public AdapterBuilder(AbsListView absListView, List<ModelType> objects) {
        this.context = absListView.getContext();
        this.absListView = absListView;
        this.objects = objects;
    }

    public <ViewType extends View> ViewAdapterBuilder<ViewType,ModelType> withBinder(ModelBinder<ViewType, ModelType> binder) {
        return new ViewAdapterBuilder<ViewType, ModelType>().withBinder(binder);
    }

    public <ViewType extends View> ViewAdapterBuilder<ViewType, ModelType> withViewFactory(Class<ViewType> viewClass) {
        return new ViewAdapterBuilder<ViewType, ModelType>().withViewFactory(viewClass);
    }

    public <ViewType extends View> ViewAdapterBuilder<ViewType, ModelType> withViewFactory(ViewFactory<ViewType> viewFactory) {
        return new ViewAdapterBuilder<ViewType, ModelType>().withViewFactory(viewFactory);
    }

    public ViewAdapterBuilder<View, ModelType> withBinding(int layoutId, int variableId) {
        return new ViewAdapterBuilder<View, ModelType>()
            .withViewFactory(AndroidBinding.createViewFactory(context,layoutId))
            .withBinder(AndroidBinding.<ModelType>createBinder(variableId));
    }

    public AdapterBuilder<ModelType> withListener(final OnDataClickListener<ModelType> listener) {
        absListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.click(objects.get(position));
            }
        });
        return this;
    }

    public interface OnDataClickListener<ModelType> {
        void click(ModelType object);
    }

    public class ViewAdapterBuilder<ViewType extends View ,ModelType> {

        private ModelBinder<ViewType, ModelType> binder;
        private ViewFactory<ViewType> viewFactory;

        public ViewAdapterBuilder<ViewType, ModelType> withBinder(ModelBinder<ViewType, ModelType> binder) {
            this.binder = binder;
            return this;
        }

        public ViewAdapterBuilder<ViewType, ModelType> withViewFactory(Class<ViewType> viewClass) {
            return withViewFactory(ViewFactories.createFor(viewClass));
        }

        public ViewAdapterBuilder<ViewType, ModelType> withViewFactory(ViewFactory<ViewType> viewFactory) {
            this.viewFactory = viewFactory;
            return this;
        }

        public void bind() {
            ListAdapter adapter = new ListAdapter(binder, viewFactory, context, objects);
            absListView.setAdapter(adapter);
            if (objects instanceof ObservableList) {
                ObservableList observableList = (ObservableList) objects;
                observableList.addOnListChangedCallback(new ObservableListCallback(adapter));
            }
        }
    }
}