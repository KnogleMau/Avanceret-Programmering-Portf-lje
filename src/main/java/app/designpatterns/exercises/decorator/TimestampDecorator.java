package app.designpatterns.exercises.decorator;

import designpatterns.exercises.decorator.TextWriter;

import java.time.LocalDateTime;

public class TimestampDecorator implements TextWriter {
    private TextWriter wrappee;

    public TimestampDecorator(TextWriter wrappee) {
        this.wrappee = wrappee;
    }

    public void write(String text) {
        String modified = "[" + LocalDateTime.now() + "] " + text;
        wrappee.write(modified);
    }
}

