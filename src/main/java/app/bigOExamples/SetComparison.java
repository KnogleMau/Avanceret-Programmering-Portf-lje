package app.bigOExamples;

import app.bigOExamples.entitiy.CompareClass;

import java.util.HashSet;
import java.util.TreeSet;

public class SetComparison {
    public static void main(String[] args) {
        int size = 5000000;

        HashSet<CompareClass> hashSet = new HashSet<>();
        TreeSet<CompareClass> treeSet = new TreeSet<>();

        // Fylder begge sæt op med samme objekter
        for (int i = 0; i < size; i++) {
            hashSet.add(new CompareClass(i, i));
            treeSet.add(new CompareClass(i, i));
        }

        // Det objekt vi finder/fjerner/tilføjer på tværs af de to sæt
        CompareClass target = new CompareClass(250000, 250000);
        CompareClass newObject = new CompareClass(size + 1, size + 1);

        System.out.println("HashSet:");

        System.out.println("Add:");
        long start = System.currentTimeMillis();
        hashSet.add(newObject);
        long end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        System.out.println("Contains:");
        start = System.currentTimeMillis();
        hashSet.contains(target);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        System.out.println("Remove:");
        start = System.currentTimeMillis();
        hashSet.remove(target);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));


        System.out.println("\nTreeSet:");

        System.out.println("Add:");
        start = System.currentTimeMillis();
        treeSet.add(newObject);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        System.out.println("Contains:");
        start = System.currentTimeMillis();
        treeSet.contains(target);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        System.out.println("Remove:");
        start = System.currentTimeMillis();
        treeSet.remove(target);
        end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));

        // Kompleksitet for de tre operationer:
        //
        // HashSet (bygger på en hashtabel):
        //   add(o)      -> O(1) amortiseret (hashCode peger direkte på bucket)
        //   contains(o) -> O(1) amortiseret
        //   remove(o)   -> O(1) amortiseret
        //   Worst case bliver O(n), hvis alle hashes ender i samme bucket.
        //
        // TreeSet (bygger på et balanceret rød-sort træ):
        //   add(o)      -> O(log n) (skal finde rigtig plads via compareTo)
        //   contains(o) -> O(log n)
        //   remove(o)   -> O(log n)
        //   Til gengæld er elementerne altid sorteret efter compareTo.
        //
        // Forskellen:
        // HashSet er hurtigst når man bare vil tjekke om noget findes, tilføje
        // eller fjerne - og man er ligeglad med rækkefølge.
        // TreeSet er en smule langsommere, men holder elementerne sorterede og
        // giver adgang til operationer som first(), last(), headSet() osv.
    }
}
