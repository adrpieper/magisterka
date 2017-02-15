package pl.edu.ug.inf.am.trip.items;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import pl.adrian.bindinge.AdapterBuilder;
import pl.adrian.bindinge.Adapters;
import pl.adrian.bindinge.ModelBinder;
import pl.adrian.bindinge.ViewFactories;
import pl.aml.impl.items.ItemType;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.ItemsFragmentBinding;
import pl.edu.ug.inf.am.trip.dagger.TripComponent;
import pl.edu.ug.inf.am.trip.items.model.ItemsModel;
import pl.edu.ug.inf.am.trip.items.model.SlotModel;
import pl.edu.ug.inf.am.trip.model.StatsModel;

import javax.inject.Inject;
import java.util.ArrayList;

public class ItemsFragment extends Fragment {

    @Inject
    ItemsController itemsController;

    @Inject
    StatsModel statsModel;

    public ItemsFragment() {
        App.getComponent(TripComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        ItemsFragmentBinding binding = ItemsFragmentBinding.inflate(inflater);
        final ItemsModel model = itemsController.createModel();
        binding.setStats(statsModel);

        Adapters.createFor(binding.slotsListView, new ArrayList<>(model.getSlots()))
                .withListener(new AdapterBuilder.OnDataClickListener<SlotModel>() {
                    @Override
                    public void click(SlotModel object) {
                        itemsController.takeOffItem(object.getSlotType(), model);
                    }
                })
                .withBinding(R.layout.slot_view, BR.slot)
                .bind();

        Adapters.createFor(binding.bagItemsListView,model.getItemsInBag())
                .withListener(new AdapterBuilder.OnDataClickListener<ItemType>() {
                    @Override
                    public void click(ItemType object) {
                        itemsController.takeOnItem(object, model);
                    }
                })
                .withBinding(R.layout.item_view, BR.item)
                .bind();


        return binding.getRoot();
    }
}
