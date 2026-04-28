package app.algoritms.cycleDetektor;

import app.algoritms.Node;

import static app.algoritms.cycleDetektor.ListFactory.hasCycle;

public class Main {

    public static void main(String[] args) {
        Node list = ListFactory.buildList(1, 2, 3, 4, 5);
        if(!hasCycle(list))
            System.out.println(list + " This does not have a cycle");

        Node circularList = ListFactory.buildListWithCycle();
        if(hasCycle(circularList))
            System.out.println(circularList.value);
    }
}
