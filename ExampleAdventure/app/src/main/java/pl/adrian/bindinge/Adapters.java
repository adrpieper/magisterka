package pl.adrian.bindinge;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;

import java.util.Arrays;
import java.util.List;

public class Adapters {

    public static <ModelType> AdapterBuilder<ModelType>
    createFor(AbsListView absListView, List<ModelType> objects){
        return new AdapterBuilder<>(absListView, objects);
    }


}
