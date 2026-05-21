package app.designpatterns.exercises.command;

public class Main {

    public static void main(String[] args) {
        CardReader terminal = new CardReader();

        Button green = new Button(new AcceptCommand(terminal));

        Button yellow = new Button(new RemoveCommand(terminal));

        Button red = new Button(new DeclineCommand(terminal));

        green.press();
        yellow.press();
        red.press();


    }
}
