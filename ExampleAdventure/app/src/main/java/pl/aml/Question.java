package pl.aml;

public class Question implements AStage {

    private final String question;
    private final QuestionAnswer[] answers;

    Question(String question, QuestionAnswer... answers) {
        this.question = question;
        this.answers = answers;
    }

    @Override
    public void show(AStageDisplayer manager) {
        manager.show(this);
    }

    @Override
    public void init(AStageInitializer initializer) {
        initializer.init(this);
    }

    public String getQuestion() {
        return question;
    }

    public QuestionAnswer[] getAnswers() {
        return answers;
    }
}
