package pl.adrian.bindinge;

import android.view.View;

/**
 * Created by Adi on 2016-11-09.
 */
public class SimpleBinder<ViewType extends View & Bindable<ModelType>,ModelType> implements ModelBinder<ViewType,ModelType> {

    @Override
    public void bind(ViewType view, ModelType model) {
        view.bind(model);
    }
}
