package pl.edu.ug.inf.am.adventure.fight.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.adventure.fight.controller.ResultAccepter;
import pl.edu.ug.inf.am.adventure.fight.model.ResultModel;
import pl.edu.ug.inf.am.databinding.FightResultViewBinding;

import javax.inject.Inject;

public class WinFragment extends Fragment {

    @Inject
    ResultAccepter resultAccepter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fight_result_view, container, false);
        FightResultViewBinding binding = FightResultViewBinding.bind(view);
        final ResultModel result = resultAccepter.createResultModel();
        binding.setResult(result);

        binding.okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultAccepter.acceptResult(result);
            }
        });

        return view;
    }
}
