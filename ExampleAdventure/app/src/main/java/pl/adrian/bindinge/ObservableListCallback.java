package pl.adrian.bindinge;

import android.databinding.ObservableList;
import android.widget.BaseAdapter;

/**
 * Created by Adi on 2016-12-05.
 */
public class ObservableListCallback<T> extends ObservableList.OnListChangedCallback<ObservableList<T>> {
    private final BaseAdapter adapter;

    public ObservableListCallback(BaseAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onChanged(ObservableList<T> sender) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
        adapter.notifyDataSetChanged();
    }
}
