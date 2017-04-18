package pl.aml.adventure;

public class ShowMessage extends AbsAState{

    private final String message;

    public ShowMessage(String message) {
        this.message = message;
    }

    @Override
    public void run(AdventureEngine engine) {
        engine.showMessage(message);
    }
}
