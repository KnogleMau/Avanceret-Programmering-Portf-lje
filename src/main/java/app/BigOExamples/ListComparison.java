package app.BigOExamples;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class ListComparison {
    public static void main(String[] args) {
        int size = 500000;

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
            hashSet.add(i);
        }

        System.out.println("ArrayList:");

        System.out.println("Get:");
        long start = System.currentTimeMillis();
        arrayList.get(250000);
        long end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        System.out.println("Add:");
        start = System.currentTimeMillis();
        arrayList.add(250000, 99);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));


        System.out.println("Remove:");
        start = System.currentTimeMillis();
        arrayList.remove(250000);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));


        System.out.println("\nListedList:");

        System.out.println("Get:");
        start = System.currentTimeMillis();
        linkedList.get(250000);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        System.out.println("Add:");
        System.out.println("ArrayList:");
        start = System.currentTimeMillis();
        linkedList.add(250000, 99);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        System.out.println("Remove:");
        start = System.currentTimeMillis();
        linkedList.remove(250000);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));


        System.out.println("\nHashSet Vs ArrayList:");
        System.out.println("ArrayList Contains:");
        start = System.currentTimeMillis();
        arrayList.contains(250000);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        System.out.println("HashSet Contains:");
        start = System.currentTimeMillis();
        hashSet.contains(250000);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        System.out.println("Arraylist Contains Something that dosnt exist:");
        start = System.currentTimeMillis();
        arrayList.contains(500001);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        System.out.println("HashSet Contains Something that dosnt exist:");
        start = System.currentTimeMillis();
        hashSet.contains(500001);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        // I et Hashset kigger de efter hashet hvor i et array løber den hele
        // arrayet igennem indtil den finder værdien vi søger, så det tager længere tid
        //Hvor i Hashset finder den hashet hurtigere og bruger logikken o(1)
        //Hvor Arraylisten er o(n)
    }
}
