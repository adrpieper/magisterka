package pl.edu.ug.inf.am.adventure.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
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
        binding.answersListView.setAdapter(new AnswersAdapter(question.getAnswers()));
        binding.answersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                controller.answer(question.getAnswers()[i]);
            }
        });
        return binding.getRoot();
    }

    class AnswersAdapter extends BaseAdapter {


        private final QuestionAnswer[] answers;

        public AnswersAdapter(QuestionAnswer[] answers) {

            this.answers = answers;
        }

        @Override
        public int getCount() {
            return answers.length;
        }

        @Override
        public QuestionAnswer getItem(int position) {
            return answers[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView textView;
            if (convertView instanceof TextView){
                textView = (TextView) convertView;
            }else {
                textView = new TextView(getActivity());
            }
            textView.setText(getItem(position).getAnswer());
            return textView;
        }
    }
}
