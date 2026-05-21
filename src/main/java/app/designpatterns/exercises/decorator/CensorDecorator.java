package app.designpatterns.exercises.decorator;

import java.util.List;

public class CensorDecorator implements TextWriter {
    private TextWriter wrappee;

    private List<String> censorWords = List.of("fandens", "pokkers", "satans", "lort");

    public CensorDecorator(TextWriter wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void write(String text) {
        String modified = text;
        for (String word : censorWords) {
            modified = modified.replace(word, "****");
        }
        wrappee.write(modified);
    }
}
