package pl.aml;

import pl.edu.ug.inf.am.adventure.AStagePresenter;

public class Question implements AStage {

    private final String question;
    private final QuestionAnswer[] answers;

    Question(String question, QuestionAnswer... answers) {
        this.question = question;
        this.answers = answers;
    }

    @Override
    public void show(AStagePresenter manager) {
        manager.show(this);
    }

    @Override
    public void run(AdventureEngine initializer) {
        initializer.ask(question,answers);
    }

    public String getQuestion() {
        return question;
    }

    public QuestionAnswer[] getAnswers() {
        return answers;
    }
}
