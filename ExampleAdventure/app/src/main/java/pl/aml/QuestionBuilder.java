package pl.aml;

import java.util.List;

public class QuestionBuilder implements AStageBuilder{

    private String question;
    private List<QuestionAnswer> answers;

    public QuestionBuilder(String question) {
        this.question = question;
    }

    public QuestionBuilder withAnswer(String answer, AStage stage) {
        answers.add(new QuestionAnswer(answer, stage));
        return this;
    }

    @Override
    public AStage build() {
        return new Question(question, answers.toArray(new QuestionAnswer[answers.size()]));
    }
}
