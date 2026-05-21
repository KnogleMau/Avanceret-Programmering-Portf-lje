package app.designpatterns.exercises.decorator;

public class UppercaseDecorator implements TextWriter{

    private TextWriter uppercase;

    public UppercaseDecorator(TextWriter uppercase){
        this.uppercase = uppercase;
    }
    @Override
    public void write(String text) {
        String modified = text.toUpperCase();
        uppercase.write(modified);
    }
}
