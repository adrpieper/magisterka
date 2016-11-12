package pl.edu.ug.inf.am.adventure.state;

import pl.aml.QuestionAnswer;

import java.util.Collection;

/**
 * Created by Adi on 2016-11-11.
 */
public class QuestionState extends AStageState{
    private final String question;
    private final Collection<QuestionAnswer> answers;

    public QuestionState(String question, Collection<QuestionAnswer> answers) {

        this.question = question;
        this.answers = answers;
    }

    public Collection<QuestionAnswer> getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }
}
