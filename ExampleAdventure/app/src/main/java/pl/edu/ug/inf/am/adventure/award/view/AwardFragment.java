package pl.edu.ug.inf.am.adventure.award.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.adrian.bindinge.AdapterBuilder;
import pl.adrian.bindinge.Adapters;
import pl.aml.adventure.AdventureEngine;
import pl.aml.impl.item.ItemType;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.adventure.dagger.AdventureComponent;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.AwardFragmentViewBinding;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AwardFragment extends Fragment{
    public static final String ITEMS = "view.AwardFragment.items";
    private List<ItemType> items;

    @Inject
    AdventureEngine adventureEngine;

    public AwardFragment() {
        App.getComponent(AdventureComponent.class).inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Integer> itemsIds = getArguments().getIntegerArrayList(ITEMS);
        items = new ArrayList<>(itemsIds.size());
        for (Integer itemsId : itemsIds) {
            items.add(ItemType.values()[itemsId]);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        AwardFragmentViewBinding binding = AwardFragmentViewBinding.inflate(inflater);
        binding.okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adventureEngine.end();
            }
        });
        Adapters.createFor(binding.itemsListView,items)
                .withBinding(R.layout.item_view, BR.item)
                .bind();
        return binding.getRoot();
    }

    public static AwardFragment newInstance(List<ItemType> items){
        Bundle args = new Bundle();
        ArrayList<Integer> itemsIds = new ArrayList<>(items.size());
        for (ItemType item : items) {
            itemsIds.add(item.ordinal());
        }

        args.putIntegerArrayList(ITEMS,itemsIds);
        AwardFragment awardFragment = new AwardFragment();
        awardFragment.setArguments(args);
        return awardFragment;
    }
}
