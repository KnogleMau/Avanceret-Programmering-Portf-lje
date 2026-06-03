package app.designpatterns.CommandPåSort;

public class Main {

    public static void main(String[] args) {
        Sorter sorter = new Sorter();

        int[] arr1 = {5, 2, 9, 1, 7, 4, 8, 3, 6,21,45,12,43,35,11,10,99,75,81,44,56};
        int[] arr2 = {5, 2, 9, 1, 7, 4, 8, 3, 6,21,45,12,43,35,11,10,99,75,81,44,56};
        int[] arr3 = {5, 2, 9, 1, 7, 4, 8, 3, 6,21,45,12,43,35,11,10,99,75,81,44,56};

        SortButton bubble = new SortButton(new BubbleSortCommand(sorter, arr1));
        SortButton quick  = new SortButton(new QuickSortCommand(sorter, arr2));
        SortButton merge  = new SortButton(new MergeSortCommand(sorter, arr3));

        bubble.press();
        quick.press();
        merge.press();
    }
}
