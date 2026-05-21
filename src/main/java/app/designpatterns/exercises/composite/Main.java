package app.designpatterns.exercises.composite;

public class Main {

    public static void main(String[] args) {
        // Simple opgaver
        Task dbTask = new SimpleTask("Lav database");
        Task loginTask = new SimpleTask("Byg login-side");
        Task umlTask = new SimpleTask("Lav UML-diagram");
        Task readmeTask = new SimpleTask("Skriv README");

        // Undergruppe: Dokumentation
        TaskGroup docs = new TaskGroup("Dokumentation");
        docs.add(umlTask);
        docs.add(readmeTask);

        // Hovedgruppe: Sprint 1
        TaskGroup sprint = new TaskGroup("Sprint 1");
        sprint.add(dbTask);
        sprint.add(loginTask);
        sprint.add(docs);

        // Udfør hele sprinten
        sprint.complete();
    }
}
