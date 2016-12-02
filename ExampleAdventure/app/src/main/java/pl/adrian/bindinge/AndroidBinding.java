package pl.adrian.bindinge;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;

public class AndroidBinding {

    public static <DataModel> ModelBinder<View,DataModel> createBinder(final int variableId) {
        return new ModelBinder<View, DataModel>() {
            @Override
            public void bind(View view, DataModel model) {
                ViewDataBinding binding = DataBindingUtil.getBinding(view);
                binding.setVariable(variableId, model);
            }
        };
    }

    public static ViewFactory<View> createViewFactory(Context context,final int layoutId) {
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        return new ViewFactory<View>() {
            @Override
            public View createView(Context context) {
                ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, layoutId, null, false);

                return binding.getRoot();
            }
        };
    }
}
