package pl.edu.ug.inf.am.adventure.result.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.adrian.bindinge.Adapters;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.adventure.result.controller.AdventureResultController;
import pl.edu.ug.inf.am.adventure.result.dagger.AdventureResultComponent;
import pl.edu.ug.inf.am.adventure.state.AdventureResult;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.AdventureResultFragmentBinding;

import javax.inject.Inject;


public class AdventureResultFragment extends Fragment {

    @Inject
    AdventureResultController controller;

    @Inject
    AdventureResult result;

    public AdventureResultFragment() {
        App.getComponent(AdventureResultComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        AdventureResultFragmentBinding binding = AdventureResultFragmentBinding.inflate(inflater);
        binding.setResult(result);
        binding.acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.acceptResult();
            }
        });

        Adapters.createFor(binding.itemsListView, result.getCollectedItems())
                .withBinding(R.layout.item_view, BR.item)
                .bind();

        return binding.getRoot();
    }
}
