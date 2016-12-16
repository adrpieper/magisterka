package pl.aml.adventure;

import java.util.ArrayList;
import java.util.List;

public class QuestionBuilder implements AStageBuilder{

    private String question;
    private List<QuestionAnswer> answers = new ArrayList<>();

    public QuestionBuilder(String question) {
        this.question = question;
    }

    public QuestionBuilder withAnswer(String answer, AStage stage) {
        answers.add(new QuestionAnswer(answer, stage));
        return this;
    }

    public QuestionBuilder withAnswer(String answer, AStageBuilder stage) {
        return withAnswer(answer, stage.build());
    }

    @Override
    public AStage build() {
        return new Question(question, answers.toArray(new QuestionAnswer[answers.size()]));
    }
}
