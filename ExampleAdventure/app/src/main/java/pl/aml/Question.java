package pl.aml;

public class Question implements AStage {

    private final String question;
    private final QuestionAnswer[] answers;

    Question(String question, QuestionAnswer... answers) {
        this.question = question;
        this.answers = answers;
    }
}
