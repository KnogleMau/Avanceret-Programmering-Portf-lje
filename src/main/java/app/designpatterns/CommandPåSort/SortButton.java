package app.designpatterns.CommandPåSort;

public class SortButton {
    private SortCommand command;

    public SortButton(SortCommand command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }
}
