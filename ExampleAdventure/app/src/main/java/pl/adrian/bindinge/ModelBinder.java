package pl.adrian.bindinge;

import android.view.View;

public interface ModelBinder<ViewType extends View, ModelType> {
    void bind(ViewType view, ModelType model);
}
