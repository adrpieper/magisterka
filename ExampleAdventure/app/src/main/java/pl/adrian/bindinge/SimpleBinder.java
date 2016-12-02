package pl.adrian.bindinge;

import android.view.View;

public class SimpleBinder<ViewType extends View & Bindable<ModelType>,ModelType> implements ModelBinder<ViewType,ModelType> {

    @Override
    public void bind(ViewType view, ModelType model) {
        view.bind(model);
    }
}
