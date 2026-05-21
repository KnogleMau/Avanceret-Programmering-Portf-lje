package app.designpatterns.exercises.composite;

import java.util.ArrayList;
import java.util.List;

public class TaskGroup implements Task {
    private String name;
    private List<Task> tasks = new ArrayList<>();

    public TaskGroup(String name) {
        this.name = name;
    }

    public void add(Task t) {
        tasks.add(t);
    }

    public void complete() {
        System.out.println("✔ Starter opgavesamling: " + name);
        for (Task t : tasks) {
            t.complete();
        }
    }
}
