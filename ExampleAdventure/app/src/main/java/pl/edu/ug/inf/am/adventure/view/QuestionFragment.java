package pl.edu.ug.inf.am.adventure.view;

import android.app.Fragment;
import android.content.Context;
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
import pl.adrian.bindinge.ViewFactory;
import pl.aml.Location;
import pl.aml.Question;
import pl.aml.QuestionAnswer;
import pl.edu.ug.inf.am.adventure.controller.QuestionController;
import pl.edu.ug.inf.am.databinding.QuestionLayoutBinding;

import javax.inject.Inject;

public class QuestionFragment extends Fragment {

    @Inject
    QuestionController controller;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final Question question = controller.getQuestion();
        final QuestionLayoutBinding binding = QuestionLayoutBinding.inflate(inflater);

        binding.questionTextView.setText(question.getQuestion());
        binding.answersListView.setAdapter(createAdapter(question));
        binding.answersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                controller.answer(question.getAnswers()[i]);
            }
        });
        return binding.getRoot();
    }

    private ListAdapter createAdapter(Question question) {
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
