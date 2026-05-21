package app.designpatterns.exercises.composite;

public class SimpleTask implements Task{

    private String name;
    public SimpleTask(String name){
        this.name = name;
    }
    @Override
    public void complete() {
        System.out.println("Udfører opgave: "+name);
    }
}
