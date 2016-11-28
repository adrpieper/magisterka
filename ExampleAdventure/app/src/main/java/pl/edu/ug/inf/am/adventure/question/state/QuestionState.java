package pl.edu.ug.inf.am.adventure.question.state;

import pl.aml.adventure.QuestionAnswer;

import java.util.List;

public class QuestionState {
    private final String question;
    private final List<QuestionAnswer> answers;

    public QuestionState(String question, List<QuestionAnswer> answers) {

        this.question = question;
        this.answers = answers;
    }

    public List<QuestionAnswer> getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }
}
