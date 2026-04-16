package app.bigOExamples;

public class BigOExamples {


    public void oN(int n){
        for(int i = 0; i<n; i++){
            System.out.println(i);
        }
    }

    public void oLog(int n){
        for(int i = n; i > 1; i /= 2){
            System.out.println(i);
        }

    }

    public void o1(int n){
        System.out.println(n);
    }




}
