package app;
import app.BigOExamples.BigOExamples;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int n = 10000;

        BigOExamples bigOExamples = new BigOExamples();

        bigOExamples.oN(n);
        System.out.println("------------------------------------------------- \n");
        bigOExamples.oLog(n);
        System.out.println("------------------------------------------------- \n");
        bigOExamples.o1(n);

    }
}