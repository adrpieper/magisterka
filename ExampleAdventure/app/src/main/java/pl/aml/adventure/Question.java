package pl.aml.adventure;

import java.util.Arrays;

public class Question implements AStage {

    private final String question;
    private final QuestionAnswer[] answers;

    Question(String question, QuestionAnswer... answers) {
        this.question = question;
        this.answers = answers;
    }

    @Override
    public void run(AdventureEngine initializer) {
        initializer.ask(question, Arrays.asList(answers));
    }

    public String getQuestion() {
        return question;
    }

    public QuestionAnswer[] getAnswers() {
        return answers;
    }
}
