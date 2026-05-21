package app.designpatterns.exercises.command;

public class DeclineCommand implements Command{
    private CardReader terminal;

    public DeclineCommand(CardReader terminal) {
        this.terminal = terminal;
    }

    @Override
    public void execute() {
        terminal.cancel();

    }
}
