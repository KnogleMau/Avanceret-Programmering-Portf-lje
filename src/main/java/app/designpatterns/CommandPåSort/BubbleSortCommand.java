package app.designpatterns.CommandPåSort;

public class BubbleSortCommand implements SortCommand {
    private Sorter sorter;
    private int[] arr;

    public BubbleSortCommand(Sorter sorter, int[] arr) {
        this.sorter = sorter;
        this.arr = arr;
    }

    public void execute() {
        sorter.bubbleSort(arr);
    }
}
