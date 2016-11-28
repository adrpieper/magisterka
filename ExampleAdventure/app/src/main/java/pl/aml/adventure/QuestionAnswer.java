package pl.aml.adventure;

public class QuestionAnswer{
    private final String answer;
    private final AStage aStage;

    public QuestionAnswer(String answer, AStage aStage) {
        this.answer = answer;
        this.aStage = aStage;
    }

    public AStage getAStage() {
        return aStage;
    }

    public String getAnswer() {
        return answer;
    }
}
