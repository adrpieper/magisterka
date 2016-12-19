package pl.edu.ug.inf.am.adventure.message.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import pl.aml.adventure.Adventure;
import pl.aml.adventure.AdventureEngine;
import pl.edu.ug.inf.am.adventure.dagger.AdventureComponent;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.ShowMessageViewBinding;

import javax.inject.Inject;

public class ShowMessageFragment extends Fragment {

    public static String TEXT_BUNDLE = "view.ShowMessageFragment.text";

    @Inject
    AdventureEngine adventureEngine;
    private String text;

    public ShowMessageFragment() {
        App.getComponent(AdventureComponent.class).inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = getArguments().getString(TEXT_BUNDLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ShowMessageViewBinding binding = ShowMessageViewBinding.inflate(inflater);
        binding.textView.setText(text);
        binding.okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adventureEngine.end();
            }
        });
        return binding.getRoot();
    }

    public static ShowMessageFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString(TEXT_BUNDLE, text);
        ShowMessageFragment fragment = new ShowMessageFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
