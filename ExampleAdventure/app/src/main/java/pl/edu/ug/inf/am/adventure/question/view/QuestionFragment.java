package pl.edu.ug.inf.am.adventure.question.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import pl.adrian.bindinge.Adapters;
import pl.adrian.bindinge.ModelBinder;
import pl.adrian.bindinge.ViewFactories;
import pl.aml.adventure.QuestionAnswer;
import pl.edu.ug.inf.am.adventure.question.controller.QuestionController;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionComponent;
import pl.edu.ug.inf.am.adventure.question.state.QuestionState;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.QuestionLayoutBinding;

import javax.inject.Inject;

public class QuestionFragment extends Fragment {

    @Inject
    QuestionController controller;

    public QuestionFragment() {
        App.getComponent(QuestionComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final QuestionState question = controller.getQuestion();
        final QuestionLayoutBinding binding = QuestionLayoutBinding.inflate(inflater);

        binding.questionTextView.setText(question.getQuestion());
        binding.answersListView.setAdapter(createAdapter(question));
        binding.answersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                controller.answer(question.getAnswers().get(i));
            }
        });
        return binding.getRoot();
    }

    private ListAdapter createAdapter(QuestionState question) {
        return Adapters.createFor(getActivity(), TextView.class, question.getAnswers())
                .withBinder(createBinder())
                .withViewFactory(ViewFactories.textViewFactory())
                .bind();
    }

    @NonNull
    private static ModelBinder<TextView, QuestionAnswer> createBinder() {
        return new ModelBinder<TextView, QuestionAnswer>() {
            @Override
            public void bind(TextView view, QuestionAnswer model) {
                view.setText(model.getAnswer());
            }
        };
    }


}
