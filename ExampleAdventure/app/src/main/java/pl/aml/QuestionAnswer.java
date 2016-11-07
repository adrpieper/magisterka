package pl.aml;

public class QuestionAnswer implements AStage{
    private final String answer;
    private final AStage aStage;

    public QuestionAnswer(String answer, AStage aStage) {
        this.answer = answer;
        this.aStage = aStage;
    }
}
