package app.designpatterns.exercises.command;

public class RemoveCommand implements Command{
    private CardReader terminal;

    public RemoveCommand(CardReader terminal) {
        this.terminal = terminal;
    }
    @Override
    public void execute() {
        terminal.clear();
    }
}
